drop schema if exists Unternehmensstruktur cascade;
CREATE SCHEMA if not exists Unternehmensstruktur;

SET search_path TO Unternehmensstruktur, public;

create domain plz as int
check (VALUE between 1 and 99999);

create domain personalnummer as int
check (VALUE between 1 and 99999999);

create domain akennung as TEXT
check (VALUE ~ 'a[0-9]+');

create domain email as TEXT
check (VALUE ~ '^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$');

create domain mobilnummer as TEXT
check (VALUE ~ '\+[0-9]+');

create domain icto as TEXT
check (VALUE ~ 'ICTO-[0-9]+');

create domain kundennummer as TEXT
check (VALUE ~ 'C[0-9]+');

create domain arbeitsplatzbezeichnung as TEXT
check (VALUE ~ '[A-E]\.[0-9]{2}(-[0-9]{2})?');

create table if not exists Adresse (
	Adresse_id	serial		primary key,
	Strasse		text		not null,
	Hausnummer	text		not null,
	PLZ			plz			not null,
	Stadt		text		not null,
	Bundesland	text,
	Land_iso	char(2)		not null
);

create index on Adresse(Hausnummer, Strasse, PLZ, Stadt, Land_iso);

create table if not exists Mitarbeiter (
	Personalnummer				personalnummer	primary key,
	Name						text			not null,
	A_Kennung					akennung		unique,
	Geburtsdatum				date			not null,
	Privatadresse_id			int				references Adresse (Adresse_id),
	Email_geschaeftlich			email			unique,
	Email_privat				email			unique,
	Mobilnummer_geschaeftlich	mobilnummer		unique,
	Mobilnummer_privat			mobilnummer		unique,
	Standort_id					int
);

create index on Mitarbeiter(Standort_id);
create index on Mitarbeiter(Privatadresse_id);

create table if not exists Firma (
	Name		text	primary key,
	Standort_id	int
);

create table if not exists Standort (
	Standort_id			serial			primary key,
	Adresse_id			int				not null	unique	references Adresse (Adresse_id),
	Verantwortlicher	personalnummer	not null	references Mitarbeiter (Personalnummer),
	Firma				text			not null
);

alter table Mitarbeiter
add foreign key (Standort_id) references Standort (Standort_id);

alter table Firma
add foreign key (Standort_id) references Standort (Standort_id);

create table if not exists Organisationseinheit (
	Einheitsnummer		serial			primary key,
	Name				text			not null,
	Art					text			not null	check (Art in ('Squad', 'Supersquad', 'Chapter', 'Superchapter', 'Tribe')),
	Standort_id			int				not null	references Standort (Standort_id),
	uebergeordnete_OE	int							references Organisationseinheit (Einheitsnummer),
	Firma				text			not null	references Firma (Name),
	Leiter				personalnummer	not null	references Mitarbeiter (Personalnummer)
);

create index on Organisationseinheit(Standort_id);
create index on Organisationseinheit(uebergeordnete_OE);
create index on Organisationseinheit(Firma);
create index on Organisationseinheit(Leiter);

create table if not exists Mitglied (
	Mitarbeiter				personalnummer	references Mitarbeiter (Personalnummer),
	Organisationseinheit	int				references Organisationseinheit (Einheitsnummer),
	
	primary key (Mitarbeiter, Organisationseinheit)
);

create table if not exists Kunde (
	Kundennummer		serial	primary key,
	Firmenname			text	not null,
	Adresse_id			int		references Adresse (Adresse_id),
	Mobilnummer			mobilnummer		unique,
	Email				email			unique
);

create table if not exists IT_Asset (
	ICTO_Nummer				icto	primary key,
	Name					text	not null,
	Status					text	not null	check (Status in ('Nicht gestartet', 'In Progress', 'Abgeschlossen', 'Abgebrochen')),
	Risikostufe				int					check (Risikostufe between 1 and 5),
	Budget					int,
	Organisationseinheit	int 	not null	references Organisationseinheit (Einheitsnummer),
	Kunde					int		not null	references Kunde (Kundennummer)
);

create table if not exists Abhaengigkeit (
	Upstream_IT_Asset	icto	references IT_Asset (ICTO_Nummer),
	Downstream_IT_Asset	icto	references IT_Asset (ICTO_Nummer),
	
	primary key (Upstream_IT_Asset, Downstream_IT_Asset)
);

create table if not exists System (
	End_Of_Life_Datum	date
) inherits (IT_Asset);

create table if not exists Projekt (
	Deadline	date,
	Fortschritt	int		check (Fortschritt between 0 and 100)
) inherits (IT_Asset);

create table if not exists Telekom_Shop (
	Oeffnungszeit		time,
	Schliesszeit		time,
	Bestand_Router		int,
	Bestand_Handys		int,
	Bestand_SIM_Karten	int
) inherits (Standort);

create table if not exists Buerogebaeude (
	Standort_id			int		primary key,
	Kantine_vorhanden	boolean	default false
) inherits (Standort);

create table if not exists Arbeitsplatz (
	Bezeichnung		arbeitsplatzbezeichnung,
	Standort_id		int		references Buerogebaeude (Standort_id),
	LAN_vorhanden	boolean default false,
	WLAN_vorhanden	boolean default false,
	
	primary key (Bezeichnung, Standort_id)
);

create table if not exists Schreibtisch (
	hoehenverstellbar	boolean default true,
	Anzahl_Monitore		int
) inherits (Arbeitsplatz);

create table if not exists Meetingraum (
	Kapazitaet				int,
	Webex_Board_vorhanden	boolean default false
) inherits (Arbeitsplatz);

create table if not exists Buchung (
	Bezeichnung		arbeitsplatzbezeichnung,
	Standort_id		int				references Buerogebaeude (Standort_id),
	Datum			date,
	Mitarbeiter		personalnummer	references Mitarbeiter (Personalnummer),
	
	primary key (Bezeichnung, Standort_id, Datum)
);