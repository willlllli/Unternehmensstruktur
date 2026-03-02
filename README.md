# Unternehmensstruktur

Eine webbasierte Anwendung zur Verwaltung und Visualisierung von Unternehmenshierarchien, Mitarbeiterstrukturen und IT-Assets.

## Über das Projekt

Die Anwendung bildet die interne Struktur eines Unternehmens ab – von Mitarbeitern, Organisationseinheiten (Squads, Chapters, Tribes) und Standorten bis hin zu IT-Assets, Projekten, Kunden und Arbeitsplatzbuchungen. Die Datenbank wird beim Start automatisch mit Schema und Beispieldaten initialisiert.

**Tech-Stack:**
- **Backend:** Java 21, Spring Boot 4.0.1
- **Frontend:** Vaadin 25
- **Datenbank:** PostgreSQL 16

## Lokaler Start mit Docker

### Voraussetzungen

- [Docker](https://docs.docker.com/get-docker/) mit enthaltener Docker Compose-Integration (ab Docker Desktop 3.x bzw. Docker Engine 20.10+)

---

### 1. docker-compose.yml herunterladen

**Linux / macOS:**
```bash
curl -O https://raw.githubusercontent.com/willlllli/Unternehmensstruktur/main/docker-compose.yml
```

**Windows (PowerShell):**
```powershell
Invoke-WebRequest -Uri https://raw.githubusercontent.com/willlllli/Unternehmensstruktur/main/docker-compose.yml -OutFile docker-compose.yml
```

---

### 2. Anwendung starten

```bash
docker compose up
```

Docker startet zwei Container:
- **db** – PostgreSQL 16, wird automatisch mit Schema und Beispieldaten initialisiert
- **app** – Spring Boot / Vaadin Anwendung, wartet bis die Datenbank bereit ist

Die Anwendung ist anschließend unter **[http://localhost:8080](http://localhost:8080)** erreichbar.

---

### 3. Anwendung stoppen

```bash
docker compose down
```

---

## Datenbankstruktur

Die Datenbank (`unternehmenshierarchie`) liegt im Schema `Unternehmensstruktur` und enthält folgende Hauptentitäten:

| Tabelle | Beschreibung |
|---|---|
| `Mitarbeiter` | Mitarbeiterdaten inkl. Kontaktdaten, A-Kennung und Privatadressen |
| `Organisationseinheit` | Org-Struktur: Squad, Supersquad, Chapter, Superchapter, Tribe |
| `Firma` | Unternehmenseinheiten |
| `Standort` | Standorte (Bürogebäude mit Kantine, Telekom-Shops) |
| `Arbeitsplatz` | Schreibtische und Meetingräume inkl. LAN/WLAN-Info |
| `Buchung` | Arbeitsplatzbuchungen der Mitarbeiter |
| `IT_Asset` | IT-Systeme (`System`) und Projekte (`Projekt`) mit ICTO-Nummern |
| `Abhaengigkeit` | Upstream-/Downstream-Abhängigkeiten zwischen IT-Assets |
| `Kunde` | Kundenstammdaten |
