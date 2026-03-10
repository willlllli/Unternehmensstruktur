package unternehmensstruktur.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.RouterLink;
import unternehmensstruktur.model.IctoNumber;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public abstract class SimpleSingleView<T> extends VerticalLayout implements BeforeEnterObserver {

    protected T dto;
    protected boolean createMode = false;
    protected boolean editMode   = false;

    private final String                 routeBase;
    private final Class<T>               dtoClass;
    private final Function<String, T>    loader;
    private final Consumer<T>            saver;
    private final Consumer<T>            deleter;
    private       Supplier<String>       headerSupplier;

    protected final Map<String, Map.Entry<Supplier<Object>, Consumer<Object>>> editableFields = new LinkedHashMap<>();
    protected final Map<String, Class<?>>                                      fieldTypes     = new LinkedHashMap<>();
    protected final Map<String, String>                                        fkRoutes       = new LinkedHashMap<>();

    protected SimpleSingleView(String routeBase, Class<T> dtoClass,
                                Function<String, T> loader,
                                Consumer<T> saver,
                                Consumer<T> deleter) {
        this.routeBase = routeBase;
        this.dtoClass  = dtoClass;
        this.loader    = loader;
        this.saver     = saver;
        this.deleter   = deleter;
    }

    protected void setHeaderSupplier(Supplier<String> supplier) {
        this.headerSupplier = supplier;
    }

    protected abstract void addFields();

    // --- Field registration helpers ---

    protected void addField(String label, Supplier<Object> getter, Consumer<Object> setter) {
        editableFields.put(label, Map.entry(getter, setter));
        fieldTypes.put(label, String.class);
    }

    protected void addField(String label, Supplier<Object> getter, Consumer<Object> setter, Class<?> type) {
        editableFields.put(label, Map.entry(getter, setter));
        fieldTypes.put(label, type);
    }

    protected void addFkField(String label, Supplier<Object> getter, Consumer<Object> setter, String tableRouteBase) {
        editableFields.put(label, Map.entry(getter, setter));
        fieldTypes.put(label, Integer.class);
        fkRoutes.put(label, tableRouteBase);
    }

    protected void addIctoFkField(String label, Supplier<Object> getter, Consumer<Object> setter, String tableRouteBase) {
        editableFields.put(label, Map.entry(getter, setter));
        fieldTypes.put(label, IctoNumber.class);
        fkRoutes.put(label, tableRouteBase);
    }

    // --- Lifecycle ---

    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        String param = event.getRouteParameters().get("id").orElse(null);
        createMode = "new".equals(param);
        editMode   = false;

        try {
            dto = createMode ? dtoClass.getDeclaredConstructor().newInstance() : loader.apply(param);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        addFields();
        buildPage();
    }

    private void buildPage() {
        removeAll();
        if (!createMode && headerSupplier != null) {
            add(new com.vaadin.flow.component.html.H2(headerSupplier.get()));
        }
        add(buildFields());
        add(buildButtons());
    }

    private FormLayout buildFields() {
        FormLayout form = new FormLayout();
        for (String label : editableFields.keySet()) {
            Class<?>  type         = fieldTypes.getOrDefault(label, String.class);
            String    fkTableRoute = fkRoutes.get(label);
            Object    value        = editableFields.get(label).getKey().get();

            if (fkTableRoute != null && !editMode && !createMode) {
                // View-Modus FK: Link-Button
                Button linkBtn = new Button(value != null ? value.toString() : "-");
                linkBtn.addClickListener(e -> linkBtn.getUI().ifPresent(
                        ui -> ui.navigate(fkTableRoute + "/" + value)));
                form.addFormItem(linkBtn, label);

            } else if (type == IctoNumber.class) {
                // ICTO-String-Feld (immer TextField, mit Placeholder + Validierung)
                TextField tf = new TextField(label);
                tf.setPlaceholder("ICTO-xxxx");
                tf.setPattern("ICTO-\\d+");
                tf.setErrorMessage("Format muss ICTO-xxxx sein (z. B. ICTO-2001)");
                if (value != null) tf.setValue(value.toString());
                if (editMode || createMode) {
                    Consumer<Object> setter = editableFields.get(label).getValue();
                    tf.addValueChangeListener(e -> setter.accept(e.getValue()));
                } else {
                    tf.setReadOnly(true);
                }
                form.addFormItem(tf, label);

            } else if (type == Integer.class) {
                IntegerField nf = new IntegerField(label);
                if (value != null) nf.setValue((Integer) value);
                if (editMode || createMode) {
                    Consumer<Object> setter = editableFields.get(label).getValue();
                    nf.addValueChangeListener(e -> setter.accept(e.getValue()));
                } else {
                    nf.setReadOnly(true);
                }
                form.addFormItem(nf, label);

            } else if (type == LocalDate.class) {
                DatePicker dp = new DatePicker(label);
                if (value != null) dp.setValue((LocalDate) value);
                if (editMode || createMode) {
                    Consumer<Object> setter = editableFields.get(label).getValue();
                    dp.addValueChangeListener(e -> setter.accept(e.getValue()));
                } else {
                    dp.setReadOnly(true);
                }
                form.addFormItem(dp, label);

            } else {
                // Standard TextField
                TextField tf = new TextField(label);
                if (value != null) tf.setValue(value.toString());
                if (editMode || createMode) {
                    Consumer<Object> setter = editableFields.get(label).getValue();
                    tf.addValueChangeListener(e -> setter.accept(e.getValue()));
                } else {
                    tf.setReadOnly(true);
                }
                form.addFormItem(tf, label);
            }
        }
        return form;
    }

    private HorizontalLayout buildButtons() {
        HorizontalLayout buttons = new HorizontalLayout();

        if (createMode) {
            Button saveBtn = new Button("Speichern", e -> {
                saver.accept(dto);
                Notification.show("Gespeichert");
                getUI().ifPresent(ui -> ui.navigate(routeBase));
            });
            Button cancelBtn = new Button("Abbrechen",
                    e -> getUI().ifPresent(ui -> ui.navigate(routeBase)));
            buttons.add(saveBtn, cancelBtn);

        } else if (editMode) {
            Button saveBtn = new Button("Speichern", e -> {
                saver.accept(dto);
                Notification.show("Gespeichert");
                editMode = false;
                buildPage();
            });
            Button cancelBtn = new Button("Abbrechen", e -> {
                editMode = false;
                buildPage();
            });
            buttons.add(saveBtn, cancelBtn);

        } else {
            Button editBtn = new Button("Bearbeiten", e -> {
                editMode = true;
                buildPage();
            });
            Button deleteBtn = new Button("L\u00f6schen", e -> {
                deleter.accept(dto);
                Notification.show("Gel\u00f6scht");
                getUI().ifPresent(ui -> ui.navigate(routeBase));
            });
            buttons.add(editBtn, deleteBtn);
        }
        return buttons;
    }

    // --- Type conversion helpers ---

    protected Integer toInt(Object value) {
        if (value == null) return null;
        if (value instanceof Integer i) return i;
        try { return Integer.parseInt(value.toString().trim()); }
        catch (NumberFormatException e) { return null; }
    }

    protected LocalDate toDate(Object value) {
        if (value == null) return null;
        if (value instanceof LocalDate d) return d;
        try { return LocalDate.parse(value.toString().trim()); }
        catch (Exception e) { return null; }
    }
}
