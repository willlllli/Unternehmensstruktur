package unternehmensstruktur.views.single;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.OptionalParameter;
import com.vaadin.flow.router.QueryParameters;
import unternehmensstruktur.model.FieldType;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public abstract class SimpleSingleView<D> extends VerticalLayout implements HasUrlParameter<String> {

    protected D dto;
    private final String backUrl;
    private final Class<D> dtoClass;
    private final Function<String, D> loader;
    // Nicht final, damit Unterklassen nach super() noch einen eigenen Saver setzen können.
    private Consumer<D> saver;
    private final Consumer<D> deleter;
    private Supplier<String> headerSupplier;

    protected Map<String, Map.Entry<Supplier<Object>, Consumer<Object>>> editableFields;
    protected Map<String, FieldType> fieldTypes;
    /** Maps field label -> Basispfad der Zieltabelle (z. B. "standorte") fuer FK-Felder. */
    protected Map<String, String> fkRoutes;
    protected boolean editMode = false;
    protected boolean createMode = false;

    private Dialog parentDialog = null;

    /** Persistenter Fehler-Banner, der direkt im View angezeigt wird. */
    private Div errorBanner = null;

    protected SimpleSingleView(String backUrl, Class<D> dtoClass,
                               Function<String, D> loader,
                               Consumer<D> saver,
                               Consumer<D> deleter) {
        this.backUrl = backUrl;
        this.dtoClass = dtoClass;
        this.loader = loader;
        this.saver = saver;
        this.deleter = deleter;
        this.editableFields = new LinkedHashMap<>();
        this.fieldTypes = new LinkedHashMap<>();
        this.fkRoutes = new LinkedHashMap<>();
    }

    protected void setHeaderSupplier(Supplier<String> supplier) {
        this.headerSupplier = supplier;
    }

    /** Erlaubt Unterklassen, den Saver nach dem super()-Aufruf zu setzen/zu überschreiben. */
    protected void setSaver(Consumer<D> saver) {
        this.saver = saver;
    }

    public void setParentDialog(Dialog dialog) {
        this.parentDialog = dialog;
    }

    protected abstract void addFields();

    protected void setCreateAndEditMode() {}

    /** Registriert ein String-Feld. */
    protected void addField(String label, Supplier<Object> getter, Consumer<Object> setter) {
        editableFields.put(label, Map.entry(getter, setter));
        fieldTypes.put(label, FieldType.STRING);
    }

    /** Registriert ein Feld mit explizitem FieldType. */
    protected void addField(String label, Supplier<Object> getter, Consumer<Object> setter, FieldType type) {
        editableFields.put(label, Map.entry(getter, setter));
        fieldTypes.put(label, type);
    }

    /**
     * Registriert ein Foreign-Key-Feld mit Integer-PK.
     * Im View-Modus: klickbarer Link zur Zieltabelle.
     * Im Edit-Modus: IntegerField.
     */
    protected void addFkField(String label, Supplier<Object> getter, Consumer<Object> setter, String tableRouteBase) {
        editableFields.put(label, Map.entry(getter, setter));
        fieldTypes.put(label, FieldType.INTEGER);
        fkRoutes.put(label, tableRouteBase);
    }

    /**
     * Registriert ein Foreign-Key-Feld mit ICTO-Nummer als PK (Format "ICTO-xxxx").
     * Im View-Modus: klickbarer Link zur Zieltabelle.
     * Im Edit-Modus: TextField mit Placeholder "ICTO-xxxx" und Regex-Validierung.
     */
    protected void addIctoFkField(String label, Supplier<Object> getter, Consumer<Object> setter, String tableRouteBase) {
        editableFields.put(label, Map.entry(getter, setter));
        fieldTypes.put(label, FieldType.ICTO_NUMBER);
        fkRoutes.put(label, tableRouteBase);
    }

    @Override
    public void setParameter(BeforeEvent event, @OptionalParameter String parameter) {
        loadAndRender(parameter);
    }

    public void loadAndRender(String parameter) {
        try {
            setCreateAndEditMode();
            if (createMode) {
                dto = dtoClass.getDeclaredConstructor().newInstance();
            } else {
                editMode = false;
                dto = loader.apply(parameter);
            }
            editableFields.clear();
            fieldTypes.clear();
            fkRoutes.clear();
            addFields();
            render();
        } catch (Exception e) {
            renderError("Fehler", "Parameter: " + parameter + " - " + e.getMessage());
        }
    }

    public void loadCreateMode() {
        createMode = true;
        editMode = true;
        try {
            dto = dtoClass.getDeclaredConstructor().newInstance();
            editableFields.clear();
            fieldTypes.clear();
            fkRoutes.clear();
            addFields();
            render();
        } catch (Exception e) {
            renderError("Fehler beim Erstellen", e.getMessage());
        }
    }

    protected void render() {
        removeAll();
        errorBanner = null;
        String raw = (headerSupplier != null && dto != null) ? headerSupplier.get() : null;
        String title = (raw != null && !raw.isBlank()) ? raw : (createMode ? "Neu anlegen" : "Details");
        add(new H2(title), buildToolbar(), buildFields());
    }

    private Div buildToolbar() {
        Div toolbar = new Div();
        toolbar.addClassName("toolbar");

        if (parentDialog != null) {
            toolbar.add(new Button("\u2715 Schlie\u00dfen", e -> parentDialog.close()));
        } else {
            toolbar.add(new Button("\u2190 Zur\u00fcck", e -> UI.getCurrent().navigate(backUrl)));
        }

        if (createMode) {
            Button save = new Button("Speichern", e -> {
                clearErrorBanner();
                try {
                    saver.accept(dto);
                    if (parentDialog != null) parentDialog.close();
                    else UI.getCurrent().navigate(backUrl);
                } catch (Exception ex) {
                    showInlineError(ex);
                }
            });
            save.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_SUCCESS);
            Button cancel = new Button("Abbrechen", e -> {
                if (parentDialog != null) parentDialog.close();
                else UI.getCurrent().navigate(backUrl);
            });
            cancel.addThemeVariants(ButtonVariant.LUMO_ERROR);
            toolbar.add(save, cancel);
        } else if (!editMode) {
            Button edit = new Button("Bearbeiten", e -> {
                editMode = true;
                editableFields.clear();
                fieldTypes.clear();
                fkRoutes.clear();
                addFields();
                render();
            });
            edit.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_SUCCESS);
            Button delete = new Button("L\u00f6schen", e -> {
                deleter.accept(dto);
                if (parentDialog != null) parentDialog.close();
                else UI.getCurrent().navigate(backUrl);
            });
            delete.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_ERROR);
            toolbar.add(edit, delete);
        } else {
            Button save = new Button("Speichern", e -> {
                clearErrorBanner();
                try {
                    saver.accept(dto);
                    if (parentDialog != null) parentDialog.close();
                    else {
                        editMode = false;
                        editableFields.clear();
                        fieldTypes.clear();
                        fkRoutes.clear();
                        addFields();
                        render();
                    }
                } catch (Exception ex) {
                    showInlineError(ex);
                }
            });
            save.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_SUCCESS);
            Button cancel = new Button("Abbrechen", e -> {
                if (parentDialog != null) parentDialog.close();
                else {
                    editMode = false;
                    editableFields.clear();
                    fieldTypes.clear();
                    fkRoutes.clear();
                    addFields();
                    render();
                }
            });
            cancel.addThemeVariants(ButtonVariant.LUMO_ERROR);
            toolbar.add(save, cancel);
        }
        return toolbar;
    }

    /**
     * Zeigt einen persistenten Fehler-Banner direkt im View an.
     * Der Dialog bleibt offen, der Benutzer kann den Fehler lesen und die Eingabe korrigieren.
     */
    private void showInlineError(Exception ex) {
        Throwable cause = getRootCause(ex);
        String msg = cause.getMessage();
        if (msg == null || msg.isBlank()) msg = ex.getClass().getSimpleName();

        // Inline-Banner im View
        Div banner = new Div();
        banner.getStyle()
                .set("background", "var(--lumo-error-color-10pct)")
                .set("border", "1px solid var(--lumo-error-color)")
                .set("border-radius", "var(--lumo-border-radius-m)")
                .set("color", "var(--lumo-error-text-color)")
                .set("padding", "var(--lumo-space-s) var(--lumo-space-m)")
                .set("margin-top", "var(--lumo-space-s)")
                .set("width", "100%");

        HorizontalLayout row = new HorizontalLayout();
        row.setAlignItems(Alignment.CENTER);
        row.setSpacing(true);
        Icon icon = new Icon(VaadinIcon.EXCLAMATION_CIRCLE);
        icon.getStyle().set("color", "var(--lumo-error-color)").set("flex-shrink", "0");
        Span text = new Span("\u2716 Fehler beim Speichern: " + msg);
        row.add(icon, text);
        banner.add(row);

        // Alten Banner entfernen falls vorhanden, neuen einfügen
        clearErrorBanner();
        errorBanner = banner;
        add(banner);

        // Zusätzlich kurze Notification für sofortiges Feedback
        Notification notification = new Notification("Fehler beim Speichern: " + msg, 6000);
        notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
        notification.open();
    }

    private void clearErrorBanner() {
        if (errorBanner != null) {
            remove(errorBanner);
            errorBanner = null;
        }
    }

    private static Throwable getRootCause(Throwable t) {
        Throwable cause = t;
        while (cause.getCause() != null && cause.getCause() != cause) cause = cause.getCause();
        return cause;
    }

    private VerticalLayout buildFields() {
        VerticalLayout layout = new VerticalLayout();
        editableFields.forEach((label, entry) -> {
            Object value = entry.getKey().get();
            FieldType type = fieldTypes.getOrDefault(label, FieldType.STRING);
            String fkTableRoute = fkRoutes.get(label);

            if (fkTableRoute != null && !editMode) {
                HorizontalLayout row = new HorizontalLayout();
                row.setAlignItems(Alignment.CENTER);
                Span lbl = new Span(label + ": ");
                lbl.getStyle().set("font-weight", "bold").set("min-width", "180px");
                if (value != null) {
                    Button linkBtn = new Button(value.toString(), e -> {
                        if (parentDialog != null) parentDialog.close();
                        UI.getCurrent().navigate(
                                fkTableRoute,
                                new QueryParameters(Collections.singletonMap(
                                        "open", Collections.singletonList(value.toString()))));
                    });
                    linkBtn.addThemeVariants(ButtonVariant.LUMO_TERTIARY_INLINE);
                    row.add(lbl, linkBtn);
                } else {
                    row.add(lbl, new Span("\u2013"));
                }
                layout.add(row);
            } else {
                switch (type) {
                    case ICTO_NUMBER -> {
                        TextField tf = new TextField(label);
                        tf.setPlaceholder("ICTO-xxxx");
                        tf.setPattern("ICTO-\\d+");
                        tf.setErrorMessage("Format muss ICTO-xxxx sein (z. B. ICTO-2001)");
                        if (value != null) tf.setValue(value.toString());
                        tf.setReadOnly(!editMode);
                        tf.setWidthFull();
                        tf.setValueChangeMode(ValueChangeMode.EAGER);
                        tf.addValueChangeListener(e -> entry.getValue().accept(e.getValue()));
                        layout.add(tf);
                    }
                    case DATE -> {
                        DatePicker dp = new DatePicker(label);
                        dp.setLocale(Locale.GERMANY);
                        if (value instanceof LocalDate) dp.setValue((LocalDate) value);
                        dp.addValueChangeListener(e -> entry.getValue().accept(e.getValue()));
                        dp.setReadOnly(!editMode);
                        layout.add(dp);
                    }
                    case INTEGER -> {
                        IntegerField f = new IntegerField(label);
                        if (value instanceof Integer) f.setValue((Integer) value);
                        f.setReadOnly(!editMode);
                        f.addValueChangeListener(e -> entry.getValue().accept(e.getValue()));
                        layout.add(f);
                    }
                    case BOOLEAN -> {
                        Checkbox cb = new Checkbox(label);
                        cb.setValue(value instanceof Boolean ? (Boolean) value : false);
                        cb.addValueChangeListener(e -> entry.getValue().accept(e.getValue()));
                        cb.setReadOnly(!editMode);
                        layout.add(cb);
                    }
                    default -> {
                        TextField tf = new TextField(label);
                        if (value != null) tf.setValue(value.toString());
                        tf.setReadOnly(!editMode);
                        tf.setWidthFull();
                        tf.setValueChangeMode(ValueChangeMode.EAGER);
                        tf.addValueChangeListener(e -> entry.getValue().accept(e.getValue()));
                        layout.add(tf);
                    }
                }
            }
        });
        return layout;
    }

    private void renderError(String heading, String detail) {
        removeAll();
        HorizontalLayout h = new HorizontalLayout();
        h.setAlignItems(Alignment.CENTER);
        h.add(new Icon(VaadinIcon.EXCLAMATION_CIRCLE), new H2(heading));
        add(h, new Paragraph(detail), new Button("\u2190 Zur\u00fcck", e -> UI.getCurrent().navigate(backUrl)));
    }

    protected static Integer toInt(Object v) {
        if (v instanceof Integer) return (Integer) v;
        if (v == null || v.toString().isBlank()) return null;
        return Integer.parseInt(v.toString().trim());
    }

    protected static LocalDate toDate(Object v) {
        if (v instanceof LocalDate) return (LocalDate) v;
        if (v == null || v.toString().isBlank()) return null;
        return LocalDate.parse(v.toString().trim());
    }

    protected static Boolean toBool(Object v) {
        if (v instanceof Boolean) return (Boolean) v;
        return Boolean.parseBoolean(v != null ? v.toString() : "false");
    }

    protected static BigDecimal toBigDecimal(Object v) {
        if (v instanceof BigDecimal) return (BigDecimal) v;
        if (v == null || v.toString().isBlank()) return null;
        return new BigDecimal(v.toString().trim());
    }

    protected static LocalTime toTime(Object v) {
        if (v instanceof LocalTime) return (LocalTime) v;
        if (v == null || v.toString().isBlank()) return null;
        return LocalTime.parse(v.toString().trim());
    }
}
