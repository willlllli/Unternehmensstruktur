/*
SET search_path TO Unternehmensstruktur, public;


Select Personalnummer, Name from Mitarbeiter where Standort_id = x

Select ICTO_Nummer, Name, Status, Risikostufe, Budget from IT_Asset where Kunde = x

Select m.Personalnummer, m.Name, m.Email_geschaeftlich
from Mitarbeiter m
Inner join Mitglied mg on m.Personalnummer = mg.Mitarbeiter
where Organisationseinheit = x

SELECT m.Bezeichnung, m.Kapazitaet, m.Webex_Board_vorhanden
FROM Meetingraum m
LEFT JOIN Buchung b
    ON m.Bezeichnung = b.Bezeichnung
    AND m.Standort_id = b.Standort_id
    AND b.Datum = y
WHERE m.Standort_id = x
	and b.Datum IS NULL;

SELECT oe.Einheitsnummer, oe.Name, oe.Leiter
FROM IT_Asset ia
RIGHT JOIN Organisationseinheit oe
    ON ia.Organisationseinheit = oe.Einheitsnummer
WHERE oe.Art = 'Squad'
	and ia.ICTO_Nummer is null;

SELECT
    Art,
    COUNT(*)                             AS Anzahl_Gesamt,
    COUNT(uebergeordnete_OE)             AS Hat_uebergeordnete_OE,
    COUNT(*) - COUNT(uebergeordnete_OE)  AS uebergeordnete_OE_ist_NULL,
    -- NULL-sichere Aggregation: MIN/MAX ignorieren NULLs automatisch
    MIN(uebergeordnete_OE)               AS Niedrigste_OE_Nr,
    MAX(uebergeordnete_OE)               AS Hoechste_OE_Nr,
    -- COALESCE-Variante: NULL → 0 als Fallback (verändert MIN!)
    MIN(COALESCE(uebergeordnete_OE, 0))  AS Niedrigste_OE_Nr_null_als_0
FROM Organisationseinheit
GROUP BY Art
ORDER BY Art;

select sum(ia.Budget), ia.Organisationseinheit, oe.Name
from IT_Asset ia
join Organisationseinheit oe on ia.Organisationseinheit = oe.Einheitsnummer
group by ia.Organisationseinheit, oe.Name;

select avg(Auslastung_Prozent) from v_Standortauslastung;

-- bei Kundennummer = 1 sieht man einen Unterschied durch select distinct (Anforderung der WAB) vielleicht einmal mit und einmal ohne distinct implementieren?
select distinct
    m.Personalnummer,
    m.Name,
    m.Email_geschaeftlich
FROM Mitarbeiter m
JOIN Mitglied mg
    ON m.Personalnummer       = mg.Mitarbeiter
JOIN IT_Asset ia
    ON mg.Organisationseinheit = ia.Organisationseinheit
JOIN Kunde k
    ON ia.Kunde               = k.Kundennummer
WHERE k.Kundennummer = x
  AND ia.Status    = 'In Progress'
ORDER BY m.Name;

SELECT
    up.ICTO_Nummer              AS Upstream_ITAsset,
    up.Name                     AS Upstream_Name,

    dn.ICTO_Nummer              AS Downstream_ITAsset,
    dn.Name                     AS Downstream_Name,
    dn.Risikostufe              AS Downstream_Risiko,

    oe.Name                     AS Downstream_Team,
    tl.Name                     AS Ansprechpartner,
    tl.Email_geschaeftlich      AS Kontakt_Email,
    tl.Mobilnummer_geschaeftlich AS Kontakt_Mobil
FROM IT_Asset up
JOIN Abhaengigkeit ab
    ON up.ICTO_Nummer = ab.Upstream_IT_Asset
JOIN IT_Asset dn
    ON ab.Downstream_IT_Asset = dn.ICTO_Nummer
JOIN Organisationseinheit oe
    ON dn.Organisationseinheit = oe.Einheitsnummer
JOIN Mitarbeiter tl
    ON oe.Leiter = tl.Personalnummer
WHERE up.ICTO_Nummer = x;
*/