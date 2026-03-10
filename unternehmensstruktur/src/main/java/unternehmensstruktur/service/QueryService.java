package unternehmensstruktur.service;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service
public class QueryService {

    private final JdbcTemplate jdbc;

    public QueryService(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    // Q1 – Mitarbeiter an einem bestimmten Standort
    public List<Map<String, Object>> getMitarbeiterByStandort(int standortId) {
        String sql = """
                SELECT Personalnummer, Name
                FROM Mitarbeiter
                WHERE Standort_id = ?
                """;
        return jdbc.queryForList(sql, standortId);
    }

    // Q2 – IT-Assets eines bestimmten Kunden
    public List<Map<String, Object>> getITAssetsByKunde(int kundennummer) {
        String sql = """
                SELECT ICTO_Nummer, Name, Status, Risikostufe, Budget
                FROM IT_Asset
                WHERE Kunde = ?
                """;
        return jdbc.queryForList(sql, kundennummer);
    }

    // Q3 – Mitarbeiter einer Organisationseinheit
    public List<Map<String, Object>> getMitarbeiterByOE(int einheitsnummer) {
        String sql = """
                SELECT m.Personalnummer, m.Name, m.Email_geschaeftlich
                FROM Mitarbeiter m
                INNER JOIN Mitglied mg ON m.Personalnummer = mg.Mitarbeiter
                WHERE mg.Organisationseinheit = ?
                """;
        return jdbc.queryForList(sql, einheitsnummer);
    }

    // Q4 – Freie Meetingräume an einem Standort für ein bestimmtes Datum
    public List<Map<String, Object>> getFreieMeetingraeume(int standortId, LocalDate datum) {
        String sql = """
                SELECT m.Bezeichnung, m.Kapazitaet, m.Webex_Board_vorhanden
                FROM Meetingraum m
                LEFT JOIN Buchung b
                    ON m.Bezeichnung = b.Bezeichnung
                    AND m.Standort_id = b.Standort_id
                    AND b.Datum = ?
                WHERE m.Standort_id = ?
                  AND b.Datum IS NULL
                """;
        return jdbc.queryForList(sql, datum, standortId);
    }

    // Q5 – Squads ohne zugeordnete IT-Assets
    public List<Map<String, Object>> getSquadsOhneITAssets() {
        String sql = """
                SELECT oe.Einheitsnummer, oe.Name, oe.Leiter
                FROM IT_Asset ia
                RIGHT JOIN Organisationseinheit oe
                    ON ia.Organisationseinheit = oe.Einheitsnummer
                WHERE oe.Art = 'Squad'
                  AND ia.ICTO_Nummer IS NULL
                """;
        return jdbc.queryForList(sql);
    }

    // Q6 – Statistiken aller Organisationseinheiten gruppiert nach Art
    public List<Map<String, Object>> getOEStatistiken() {
        String sql = """
                SELECT Art,
                       COUNT(*)                            AS Anzahl_Gesamt,
                       COUNT(uebergeordnete_OE)            AS Hat_uebergeordnete_OE,
                       COUNT(*) - COUNT(uebergeordnete_OE) AS uebergeordnete_OE_ist_NULL,
                       MIN(uebergeordnete_OE)              AS Niedrigste_OE_Nr,
                       MAX(uebergeordnete_OE)              AS Hoechste_OE_Nr,
                       MIN(COALESCE(uebergeordnete_OE, 0)) AS Niedrigste_OE_Nr_null_als_0
                FROM Organisationseinheit
                GROUP BY Art
                ORDER BY Art
                """;
        return jdbc.queryForList(sql);
    }

    // Q7 – Budget-Summe pro Organisationseinheit
    public List<Map<String, Object>> getBudgetJeOE() {
        String sql = """
                SELECT oe.Name, ia.Organisationseinheit, SUM(ia.Budget) AS Budget_Gesamt
                FROM IT_Asset ia
                JOIN Organisationseinheit oe ON ia.Organisationseinheit = oe.Einheitsnummer
                GROUP BY ia.Organisationseinheit, oe.Name
                """;
        return jdbc.queryForList(sql);
    }

    // Q8 – Durchschnittliche Auslastung aller Standorte (via View)
    public Double getAvgStandortauslastung() {
        String sql = "SELECT AVG(Auslastung_Prozent) FROM v_Standortauslastung";
        return jdbc.queryForObject(sql, Double.class);
    }

    // Q9a – Mitarbeiter in laufenden Projekten eines Kunden MIT DISTINCT
    public List<Map<String, Object>> getMitarbeiterInProgressDistinct(int kundennummer) {
        String sql = """
                SELECT DISTINCT m.Personalnummer, m.Name, m.Email_geschaeftlich
                FROM Mitarbeiter m
                JOIN Mitglied mg       ON m.Personalnummer        = mg.Mitarbeiter
                JOIN IT_Asset ia       ON mg.Organisationseinheit = ia.Organisationseinheit
                JOIN Kunde k           ON ia.Kunde                = k.Kundennummer
                WHERE k.Kundennummer = ?
                  AND ia.Status = 'In Progress'
                ORDER BY m.Name
                """;
        return jdbc.queryForList(sql, kundennummer);
    }

    // Q9b – Selbe Anfrage OHNE DISTINCT (Vergleich für WAB)
    public List<Map<String, Object>> getMitarbeiterInProgress(int kundennummer) {
        String sql = """
                SELECT m.Personalnummer, m.Name, m.Email_geschaeftlich
                FROM Mitarbeiter m
                JOIN Mitglied mg       ON m.Personalnummer        = mg.Mitarbeiter
                JOIN IT_Asset ia       ON mg.Organisationseinheit = ia.Organisationseinheit
                JOIN Kunde k           ON ia.Kunde                = k.Kundennummer
                WHERE k.Kundennummer = ?
                  AND ia.Status = 'In Progress'
                ORDER BY m.Name
                """;
        return jdbc.queryForList(sql, kundennummer);
    }

    // Q10 – Abhängigkeitskette eines IT-Assets mit Ansprechpartner
    public List<Map<String, Object>> getAbhaengigkeiten(String ictoNummer) {
        String sql = """
                SELECT up.ICTO_Nummer              AS Upstream_ITAsset,
                       up.Name                     AS Upstream_Name,
                       dn.ICTO_Nummer              AS Downstream_ITAsset,
                       dn.Name                     AS Downstream_Name,
                       dn.Risikostufe              AS Downstream_Risiko,
                       oe.Name                     AS Downstream_Team,
                       tl.Name                     AS Ansprechpartner,
                       tl.Email_geschaeftlich       AS Kontakt_Email,
                       tl.Mobilnummer_geschaeftlich AS Kontakt_Mobil
                FROM IT_Asset up
                JOIN Abhaengigkeit ab ON up.ICTO_Nummer      = ab.Upstream_IT_Asset
                JOIN IT_Asset dn      ON ab.Downstream_IT_Asset = dn.ICTO_Nummer
                JOIN Organisationseinheit oe ON dn.Organisationseinheit = oe.Einheitsnummer
                JOIN Mitarbeiter tl   ON oe.Leiter = tl.Personalnummer
                WHERE up.ICTO_Nummer = ?
                """;
        return jdbc.queryForList(sql, ictoNummer);
    }
}
