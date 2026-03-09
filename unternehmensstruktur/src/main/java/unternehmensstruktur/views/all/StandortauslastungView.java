package unternehmensstruktur.views.all;

import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import unternehmensstruktur.model.dto.StandortauslastungDto;
import unternehmensstruktur.service.StandortauslastungService;

import java.time.LocalDate;

@Route("standortauslastung")
@PageTitle("Standortauslastung")
public class StandortauslastungView extends VerticalLayout {

    private final StandortauslastungService service;
    private final Grid<StandortauslastungDto> grid = new Grid<>(StandortauslastungDto.class, false);

    @Autowired
    public StandortauslastungView(StandortauslastungService service) {
        this.service = service;

        H2 heading = new H2("Standortauslastung");

        DatePicker datePicker = new DatePicker("Datum");
        datePicker.setValue(LocalDate.now());
        datePicker.addValueChangeListener(e -> loadData(e.getValue()));

        grid.addColumn(StandortauslastungDto::getStandortId).setHeader("Standort-ID").setSortable(true);
        grid.addColumn(StandortauslastungDto::getBuchungen).setHeader("Buchungen").setSortable(true);
        grid.addColumn(StandortauslastungDto::getGesamtArbeitsplaetze).setHeader("Gesamt Arbeitspl\u00e4tze").setSortable(true);
        grid.addColumn(StandortauslastungDto::getAuslastungProzent).setHeader("Auslastung (%)").setSortable(true);
        grid.addColumn(StandortauslastungDto::getAuslastungsklasse).setHeader("Klasse").setSortable(true);
        grid.setWidthFull();

        add(heading, datePicker, grid);
        setSizeFull();

        loadData(datePicker.getValue());
    }

    private void loadData(LocalDate datum) {
        if (datum != null) {
            grid.setItems(service.getAuslastung(datum));
        }
    }
}
