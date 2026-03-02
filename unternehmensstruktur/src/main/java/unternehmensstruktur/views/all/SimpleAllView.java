package unternehmensstruktur.views.all;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.function.ValueProvider;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import unternehmensstruktur.views.single.SimpleSingleView;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;

public class SimpleAllView<D> extends VerticalLayout implements BeforeEnterObserver {

    protected final String urlBase;
    private final String header;
    private final Class<D> dtoClass;
    private final Supplier<List<D>> dataLoader;
    public Map<String, ValueProvider<D, ?>> gridColumns;
    public Button createButton;
    private Grid<D> grid;

    /** If set, a Details button column is added and double-click opens the detail dialog. */
    protected Function<D, String> detailsUrlProvider = null;

    /**
     * If set together with {@link #detailsUrlProvider}, clicking "Details" or double-clicking
     * a row opens a Dialog instead of navigating to a new page.
     * The same supplier is also used for the create dialog.
     */
    protected Supplier<SimpleSingleView<?>> detailViewSupplier = null;

    public SimpleAllView(Class<D> dtoClass, String header, String urlBase, Supplier<List<D>> dataLoader) {
        this.dtoClass = dtoClass;
        this.header = header;
        this.urlBase = urlBase;
        this.dataLoader = dataLoader;
        this.gridColumns = new LinkedHashMap<>();
        setSizeFull();
    }

    public void startPage() {
        H2 heading = new H2(header);
        heading.addClassName("h2-custom");
        grid = buildGrid();
        Div toolbar = buildToolbar(grid);
        add(heading, toolbar);
        addAndExpand(grid);
    }

    /**
     * Liest den optionalen Query-Parameter {@code ?open=<param>} und oeffnet den Detail-Dialog
     * fuer den referenzierten Eintrag, sofern {@link #detailViewSupplier} konfiguriert ist.
     * Wird z. B. aufgerufen, wenn ein FK-Link aus einer anderen View auf diese Tabellenansicht
     * zeigt.
     */
    @Override
    public void beforeEnter(BeforeEnterEvent event) {
        List<String> openParams = event.getLocation().getQueryParameters()
                .getParameters().getOrDefault("open", Collections.emptyList());
        if (!openParams.isEmpty() && detailViewSupplier != null && grid != null) {
            openDetailDialog(openParams.get(0), grid);
        }
    }

    private Div buildToolbar(Grid<D> grid) {
        Div toolbar = new Div();
        toolbar.setWidthFull();
        toolbar.addClassName("toolbar");

        if (createButton != null) {
            if (detailViewSupplier != null) {
                createButton.addClickListener(e -> openCreateDialog(grid));
            } else {
                createButton.addClickListener(e -> UI.getCurrent().navigate(urlBase + "/create"));
            }
            toolbar.add(createButton);
        }

        gridColumns.forEach((fieldName, provider) -> {
            TextField searchField = new TextField(fieldName);
            searchField.setPlaceholder("Suche");
            searchField.setPrefixComponent(new Icon(VaadinIcon.SEARCH));
            searchField.setValueChangeMode(ValueChangeMode.EAGER);
            searchField.addValueChangeListener(e -> {
                var dataView = grid.getListDataView();
                dataView.addFilter(dto -> {
                    String term = searchField.getValue().trim();
                    if (term.isEmpty()) return true;
                    Object val = provider.apply(dto);
                    return val != null && val.toString().toLowerCase().contains(term.toLowerCase());
                });
                dataView.refreshAll();
            });
            toolbar.add(searchField);
        });
        return toolbar;
    }

    private Grid<D> buildGrid() {
        Grid<D> newGrid = new Grid<>(dtoClass, false);
        newGrid.addClassName("grid-custom");
        newGrid.setWidthFull();

        gridColumns.forEach((colHeader, provider) ->
                newGrid.addColumn(provider).setHeader(colHeader).setSortable(true).setAutoWidth(true).setFlexGrow(1));

        if (detailViewSupplier != null && detailsUrlProvider != null) {
            newGrid.addComponentColumn(d -> {
                Button btn = new Button("Details");
                btn.addClickListener(e -> openDetailDialog(detailsUrlProvider.apply(d), newGrid));
                return btn;
            }).setWidth("120px").setFlexGrow(0);
            newGrid.addItemDoubleClickListener(e -> openDetailDialog(detailsUrlProvider.apply(e.getItem()), newGrid));
        }

        newGrid.setItems(dataLoader.get());
        newGrid.setMultiSort(true);
        return newGrid;
    }

    /**
     * Oeffnet einen Dialog mit der Detailansicht fuer den gegebenen Parameter-String.
     * Der Grid wird beim Schliessen des Dialogs automatisch aktualisiert.
     */
    private void openDetailDialog(String param, Grid<D> targetGrid) {
        SimpleSingleView<?> detailView = detailViewSupplier.get();
        Dialog dialog = buildDialog(targetGrid);
        detailView.setParentDialog(dialog);
        dialog.add(detailView);
        detailView.loadAndRender(param);
        dialog.open();
    }

    /**
     * Opens a Dialog with a fresh view in creation mode.
     * Reuses {@link #detailViewSupplier} - no separate Create*View class needed.
     */
    private void openCreateDialog(Grid<D> targetGrid) {
        SimpleSingleView<?> createView = detailViewSupplier.get();
        Dialog dialog = buildDialog(targetGrid);
        createView.setParentDialog(dialog);
        dialog.add(createView);
        createView.loadCreateMode();
        dialog.open();
    }

    /** Builds a preconfigured Dialog that refreshes the grid on close. */
    private Dialog buildDialog(Grid<D> targetGrid) {
        Dialog dialog = new Dialog();
        dialog.setWidth("650px");
        dialog.setCloseOnEsc(true);
        dialog.setCloseOnOutsideClick(false);
        dialog.addOpenedChangeListener(e -> {
            if (!e.isOpened()) targetGrid.setItems(dataLoader.get());
        });
        return dialog;
    }
}
