package unternehmensstruktur.views.all;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import unternehmensstruktur.service.QueryService;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Route("anfragen")
@PageTitle("Anfragen")
public class AnfragenView extends VerticalLayout {

    private static final LocalDate DEFAULT_DATUM = LocalDate.of(2026, 3, 3);

    @Autowired
    public AnfragenView(QueryService queryService) {
        H2 heading = new H2("Vordefinierte Anfragen");
        heading.addClassName("h2-custom");

        Accordion accordion = new Accordion();
        accordion.setWidthFull();

        // Q1 – Mitarbeiter an Standort
        IntegerField q1Standort = new IntegerField("Standort-ID");
        q1Standort.setMin(1);
        Grid<Map<String, Object>> q1Grid = createGrid();
        accordion.add("Q1 \u2013 Mitarbeiter an Standort", buildContent(
            "Zeigt alle Mitarbeiter, die einem bestimmten Standort zugeordnet sind.",
            q1Standort,
            new Button("Abfragen", e -> {
                if (q1Standort.getValue() != null)
                    fillGrid(q1Grid, queryService.getMitarbeiterByStandort(q1Standort.getValue()));
            }),
            q1Grid
        ));

        // Q2 – IT-Assets eines Kunden
        IntegerField q2Kunde = new IntegerField("Kundennummer");
        q2Kunde.setMin(1);
        Grid<Map<String, Object>> q2Grid = createGrid();
        accordion.add("Q2 \u2013 IT-Assets eines Kunden", buildContent(
            "Listet alle IT-Assets (ICTO-Nummer, Name, Status, Risikostufe, Budget) eines bestimmten Kunden.",
            q2Kunde,
            new Button("Abfragen", e -> {
                if (q2Kunde.getValue() != null)
                    fillGrid(q2Grid, queryService.getITAssetsByKunde(q2Kunde.getValue()));
            }),
            q2Grid
        ));

        // Q3 – Mitarbeiter einer Organisationseinheit
        IntegerField q3OE = new IntegerField("Einheitsnummer");
        q3OE.setMin(1);
        Grid<Map<String, Object>> q3Grid = createGrid();
        accordion.add("Q3 \u2013 Mitarbeiter einer Organisationseinheit", buildContent(
            "Gibt alle direkten Mitarbeiter einer OE mit Personalnummer, Name und gesch\u00e4ftlicher E-Mail aus. Mitarbeiter von untergeordneten OEs sind nicht mit eingeschlossen.",
            q3OE,
            new Button("Abfragen", e -> {
                if (q3OE.getValue() != null)
                    fillGrid(q3Grid, queryService.getMitarbeiterByOE(q3OE.getValue()));
            }),
            q3Grid
        ));

        // Q4 – Freie Meetingräume (zwei Parameter)
        IntegerField q4Standort = new IntegerField("Standort-ID");
        q4Standort.setMin(1);
        DatePicker q4Datum = new DatePicker("Datum");
        q4Datum.setValue(DEFAULT_DATUM);
        Grid<Map<String, Object>> q4Grid = createGrid();
        accordion.add("Q4 \u2013 Freie Meetingr\u00e4ume nach Standort und Datum", buildContent(
            "Zeigt alle nicht gebuchten Meetingr\u00e4ume an einem Standort f\u00fcr ein gew\u00e4hltes Datum (LEFT JOIN).",
            q4Standort,
            q4Datum,
            new Button("Abfragen", e -> {
                if (q4Standort.getValue() != null && q4Datum.getValue() != null)
                    fillGrid(q4Grid, queryService.getFreieMeetingraeume(q4Standort.getValue(), q4Datum.getValue()));
            }),
            q4Grid
        ));

        // Q5 – Squads ohne IT-Assets
        Grid<Map<String, Object>> q5Grid = createGrid();
        accordion.add("Q5 \u2013 Squads ohne IT-Assets", buildContent(
            "Listet alle Squads, denen aktuell kein IT-Asset zugeordnet ist (RIGHT JOIN).",
            new Button("Laden", e -> fillGrid(q5Grid, queryService.getSquadsOhneITAssets())),
            q5Grid
        ));

        // Q6 – OE-Statistiken
        Grid<Map<String, Object>> q6Grid = createGrid();
        accordion.add("Q6 \u2013 OE-Statistiken nach Art", buildContent(
            "Aggregierte Statistiken aller Organisationseinheiten nach Art (GROUP BY, MIN/MAX, COALESCE).",
            new Button("Laden", e -> fillGrid(q6Grid, queryService.getOEStatistiken())),
            q6Grid
        ));

        // Q7 – Budget je OE
        Grid<Map<String, Object>> q7Grid = createGrid();
        accordion.add("Q7 \u2013 Budget-Summe je Squad", buildContent(
            "Summiert das IT-Asset-Budget pro Squad, dem tats\u00e4chlich ein IT-Asset zugeordnet ist.",
            new Button("Laden", e -> fillGrid(q7Grid, queryService.getBudgetJeOE())),
            q7Grid
        ));

        // Q8 – Durchschnittliche Standortauslastung für ein Datum
        DatePicker q8Datum = new DatePicker("Datum");
        q8Datum.setValue(DEFAULT_DATUM);
        Span q8Result = new Span("\u2013 noch nicht geladen \u2013");
        accordion.add("Q8 \u2013 Durchschnittliche Standortauslastung", buildContent(
            "Berechnet den Durchschnitt der prozentualen Auslastung aller Standorte f\u00fcr ein gew\u00e4hltes Datum \u00fcber die View v_Standortauslastung (AVG).",
            q8Datum,
            new Button("Laden", e -> {
                if (q8Datum.getValue() != null) {
                    Double avg = queryService.getAvgStandortauslastung(q8Datum.getValue());
                    q8Result.setText(avg != null
                        ? String.format("\u00d8 Auslastung am %s: %.2f %%", q8Datum.getValue(), avg)
                        : "Keine Daten f\u00fcr dieses Datum vorhanden");
                }
            }),
            q8Result
        ));

        // Q9 – DISTINCT-Vergleich
        IntegerField q9Kunde = new IntegerField("Kundennummer");
        q9Kunde.setMin(1);
        Grid<Map<String, Object>> q9GridMit  = createGrid();
        Grid<Map<String, Object>> q9GridOhne = createGrid();
        Span q9LabelMit  = new Span("MIT DISTINCT");
        Span q9LabelOhne = new Span("OHNE DISTINCT");
        VerticalLayout q9ColMit  = new VerticalLayout(q9LabelMit,  q9GridMit);
        VerticalLayout q9ColOhne = new VerticalLayout(q9LabelOhne, q9GridOhne);
        q9ColMit.setPadding(false);
        q9ColOhne.setPadding(false);
        HorizontalLayout q9Grids = new HorizontalLayout(q9ColMit, q9ColOhne);
        q9Grids.setWidthFull();
        q9Grids.setFlexGrow(1, q9ColMit, q9ColOhne);
        accordion.add("Q9 \u2013 Mitarbeiter in laufenden Projekten (DISTINCT-Vergleich)", buildContent(
            "Mitarbeiter mit Bezug zu IT-Assets eines Kunden mit Status 'In Progress'. " +
            "Der Vergleich MIT/OHNE DISTINCT zeigt Duplikate durch mehrere Assets desselben Kunden (Kundennummer 1 empfohlen).",
            q9Kunde,
            new Button("Abfragen", e -> {
                if (q9Kunde.getValue() != null) {
                    var mit  = queryService.getMitarbeiterInProgressDistinct(q9Kunde.getValue());
                    var ohne = queryService.getMitarbeiterInProgress(q9Kunde.getValue());
                    fillGrid(q9GridMit,  mit);
                    fillGrid(q9GridOhne, ohne);
                    q9LabelMit.setText( "MIT DISTINCT \u2013 "  + mit.size()  + " Zeile(n)");
                    q9LabelOhne.setText("OHNE DISTINCT \u2013 " + ohne.size() + " Zeile(n)");
                }
            }),
            q9Grids
        ));

        // Q10 – Abhängigkeitskette eines IT-Assets
        TextField q10ICTO = new TextField("ICTO-Nummer (Upstream)");
        q10ICTO.setPlaceholder("ICTO-xxxx");
        q10ICTO.setPattern("ICTO-\\d+");
        q10ICTO.setErrorMessage("Format muss ICTO-xxxx sein (z. B. ICTO-2001)");
        Grid<Map<String, Object>> q10Grid = createGrid();
        accordion.add("Q10 \u2013 Abh\u00e4ngigkeitskette eines IT-Assets", buildContent(
            "Zeigt alle Downstream-Assets eines Upstream-IT-Assets mit Risikostufe, verantwortlichem Team und Ansprechpartner (mehrere JOINs).",
            q10ICTO,
            new Button("Abfragen", e -> {
                String val = q10ICTO.getValue();
                if (val != null && !val.isBlank())
                    fillGrid(q10Grid, queryService.getAbhaengigkeiten(val.trim()));
            }),
            q10Grid
        ));

        add(heading, accordion);
        setSizeFull();
    }

    private VerticalLayout buildContent(String description, Component... components) {
        Paragraph desc = new Paragraph(description);
        desc.getStyle().set("color", "var(--lumo-secondary-text-color)");
        VerticalLayout layout = new VerticalLayout(desc);
        for (Component c : components) layout.add(c);
        layout.setPadding(false);
        return layout;
    }

    private Grid<Map<String, Object>> createGrid() {
        Grid<Map<String, Object>> grid = new Grid<>();
        grid.setWidthFull();
        grid.addClassName("grid-custom");
        return grid;
    }

    private void fillGrid(Grid<Map<String, Object>> grid, List<Map<String, Object>> data) {
        grid.removeAllColumns();
        if (!data.isEmpty()) {
            data.get(0).keySet().forEach(col ->
                grid.addColumn(row -> row.get(col))
                    .setHeader(col)
                    .setSortable(true)
                    .setAutoWidth(true)
            );
        }
        grid.setItems(data);
    }
}
