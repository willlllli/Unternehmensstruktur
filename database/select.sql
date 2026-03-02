--SET search_path TO Unternehmensstruktur, public;

/*
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
*/