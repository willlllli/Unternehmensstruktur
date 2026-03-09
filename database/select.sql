/*
SET search_path TO Unternehmensstruktur, public;

select distinct Mitarbeiter.Standort_id
from Mitarbeiter
	inner join Mitglied on Personalnummer=Mitarbeiter
	inner join
		(select * from Organisationseinheit where Name='Squad-1-1-1-1')
		on Organisationseinheit=Einheitsnummer
order by standort_id;

select Organisationseinheit, sum(Budget)
from IT_Asset
group by Organisationseinheit;

select count(Bezeichnung)
from Arbeitsplatz
group by Standort_id;
*/
/*
select Buchung.Standort_id, count(Buchung.Bezeichnung) as Auslastung, count(Arbeitsplatz.Bezeichnung) as Kapazitaet
from Buchung inner join Arbeitsplatz on Buchung.Standort_id=Arbeitsplatz.standort_id and Buchung.Bezeichnung=Arbeitsplatz.Bezeichnung
where Datum = '2026-03-02'
group by Buchung.Standort_id;

select
  s.standort_id,
  b.auslastung,
  a.kapazitaet
from Buerogebaeude s
left join (
  select Standort_id, count(*) as auslastung
  from Buchung
  group by Standort_id
) b using (Standort_id)
left join (
  select Standort_id, count(*) as kapazitaet
  from Arbeitsplatz
  group by Standort_id
) a using (Standort_id);

Select Personalnummer, Name from Mitarbeiter where Standort_id = 2

Select ICTO_Nummer, Name, Status, Risikostufe, Budget from IT_Asset where Kunde = 2

Select m.Personalnummer, m.Name, m.Email_geschaeftlich
from Mitarbeiter m
Inner join Mitglied mg on m.Personalnummer = mg.Mitarbeiter
where Organisationseinheit = 5

SELECT m.Bezeichnung, m.Kapazitaet, m.Webex_Board_vorhanden
FROM Meetingraum m
LEFT JOIN Buchung b
    ON m.Bezeichnung = b.Bezeichnung
    AND m.Standort_id = b.Standort_id
    AND b.Datum = '2026-03-02'
WHERE m.Standort_id = 5
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
WHERE k.Kundennummer = 1
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
WHERE up.ICTO_Nummer = 'ICTO-2001';
*/