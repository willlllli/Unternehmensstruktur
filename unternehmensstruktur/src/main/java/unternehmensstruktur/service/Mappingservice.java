package unternehmensstruktur.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import unternehmensstruktur.model.db.*;
import unternehmensstruktur.model.dto.*;
import unternehmensstruktur.repository.*;

@Service
@RequiredArgsConstructor
public class Mappingservice<I extends BaseEntity, D extends BaseDto> {

    private final transient AdresseRepository adresseRepository;
    private final transient StandortRepository standortRepository;
    private final transient OrganisationseinheitRepository organisationseinheitRepository;
    private final transient MitarbeiterRepository mitarbeiterRepository;
    private final transient KundeRepository kundeRepository;
    private final transient ItAssetRepository itAssetRepository;
    private final transient BuerogebaeudeRepository buerogebaeudeRepository;

    public AdresseDto map(Adresse a) {
        if (a == null) return null;
        AdresseDto dto = new AdresseDto();
        dto.setAdresseId(a.getAdresseId());
        dto.setStrasse(a.getStrasse());
        dto.setHausnummer(a.getHausnummer());
        dto.setPlz(a.getPlz());
        dto.setStadt(a.getStadt());
        dto.setBundesland(a.getBundesland());
        dto.setLandIso(a.getLandIso());
        return dto;
    }

    public Adresse map(AdresseDto dto) {
        if (dto == null) return null;
        Adresse a = new Adresse();
        a.setAdresseId(dto.getAdresseId());
        a.setStrasse(dto.getStrasse());
        a.setHausnummer(dto.getHausnummer());
        a.setPlz(dto.getPlz());
        a.setStadt(dto.getStadt());
        a.setBundesland(dto.getBundesland());
        a.setLandIso(dto.getLandIso());
        return a;
    }

    public MitarbeiterDto map(Mitarbeiter m) {
        if (m == null) return null;
        MitarbeiterDto dto = new MitarbeiterDto();
        dto.setPersonalnummer(m.getPersonalnummer());
        dto.setName(m.getName());
        dto.setAKennung(m.getAKennung());
        dto.setGeburtsdatum(m.getGeburtsdatum());
        dto.setPrivatadresseId(m.getPrivatadresse() != null ? m.getPrivatadresse().getAdresseId() : null);
        dto.setEmailGeschaeftlich(m.getEmailGeschaeftlich());
        dto.setEmailPrivat(m.getEmailPrivat());
        dto.setMobilnummerGeschaeftlich(m.getMobilnummerGeschaeftlich());
        dto.setMobilnummerPrivat(m.getMobilnummerPrivat());
        dto.setStandortId(m.getStandortId());
        return dto;
    }

    public Mitarbeiter map(MitarbeiterDto dto) {
        if (dto == null) return null;
        Mitarbeiter m = new Mitarbeiter();
        m.setPersonalnummer(dto.getPersonalnummer());
        m.setName(dto.getName());
        m.setAKennung(dto.getAKennung());
        m.setGeburtsdatum(dto.getGeburtsdatum());
        if (dto.getPrivatadresseId() != null)
            m.setPrivatadresse(adresseRepository.findById(dto.getPrivatadresseId()).orElse(null));
        m.setEmailGeschaeftlich(dto.getEmailGeschaeftlich());
        m.setEmailPrivat(dto.getEmailPrivat());
        m.setMobilnummerGeschaeftlich(dto.getMobilnummerGeschaeftlich());
        m.setMobilnummerPrivat(dto.getMobilnummerPrivat());
        m.setStandortId(dto.getStandortId());
        return m;
    }

    public FirmaDto map(Firma f) {
        if (f == null) return null;
        FirmaDto dto = new FirmaDto();
        dto.setName(f.getName());
        dto.setStandortId(f.getStandortId());
        return dto;
    }

    public Firma map(FirmaDto dto) {
        if (dto == null) return null;
        Firma f = new Firma();
        f.setName(dto.getName());
        f.setStandortId(dto.getStandortId());
        return f;
    }

    public StandortDto map(Standort s) {
        if (s == null) return null;
        StandortDto dto = new StandortDto();
        dto.setStandortId(s.getStandortId());
        dto.setAdresseId(s.getAdresse() != null ? s.getAdresse().getAdresseId() : null);
        dto.setVerantwortlicher(s.getVerantwortlicher());
        dto.setFirma(s.getFirma());
        return dto;
    }

    public Standort map(StandortDto dto) {
        if (dto == null) return null;
        Standort s = new Standort();
        s.setStandortId(dto.getStandortId());
        if (dto.getAdresseId() != null)
            s.setAdresse(adresseRepository.findById(dto.getAdresseId()).orElse(null));
        s.setVerantwortlicher(dto.getVerantwortlicher());
        s.setFirma(dto.getFirma());
        return s;
    }

    public TelekomShopDto map(TelekomShop t) {
        if (t == null) return null;
        TelekomShopDto dto = new TelekomShopDto();
        dto.setStandortId(t.getStandortId());
        dto.setAdresseId(t.getAdresse() != null ? t.getAdresse().getAdresseId() : null);
        dto.setVerantwortlicher(t.getVerantwortlicher());
        dto.setFirma(t.getFirma());
        dto.setOeffnungszeit(t.getOeffnungszeit());
        dto.setSchliesszeit(t.getSchliesszeit());
        dto.setBestandRouter(t.getBestandRouter());
        dto.setBestandHandys(t.getBestandHandys());
        dto.setBestandSimKarten(t.getBestandSimKarten());
        return dto;
    }

    public TelekomShop map(TelekomShopDto dto) {
        if (dto == null) return null;
        TelekomShop t = new TelekomShop();
        t.setStandortId(dto.getStandortId());
        if (dto.getAdresseId() != null)
            t.setAdresse(adresseRepository.findById(dto.getAdresseId()).orElse(null));
        t.setVerantwortlicher(dto.getVerantwortlicher());
        t.setFirma(dto.getFirma());
        t.setOeffnungszeit(dto.getOeffnungszeit());
        t.setSchliesszeit(dto.getSchliesszeit());
        t.setBestandRouter(dto.getBestandRouter());
        t.setBestandHandys(dto.getBestandHandys());
        t.setBestandSimKarten(dto.getBestandSimKarten());
        return t;
    }

    public BuerogebaeudeDto map(Buerogebaeude b) {
        if (b == null) return null;
        BuerogebaeudeDto dto = new BuerogebaeudeDto();
        dto.setStandortId(b.getStandortId());
        dto.setAdresseId(b.getAdresse() != null ? b.getAdresse().getAdresseId() : null);
        dto.setVerantwortlicher(b.getVerantwortlicher());
        dto.setFirma(b.getFirma());
        dto.setKantineVorhanden(b.getKantineVorhanden());
        return dto;
    }

    public Buerogebaeude map(BuerogebaeudeDto dto) {
        if (dto == null) return null;
        Buerogebaeude b = new Buerogebaeude();
        b.setStandortId(dto.getStandortId());
        if (dto.getAdresseId() != null)
            b.setAdresse(adresseRepository.findById(dto.getAdresseId()).orElse(null));
        b.setVerantwortlicher(dto.getVerantwortlicher());
        b.setFirma(dto.getFirma());
        b.setKantineVorhanden(dto.getKantineVorhanden());
        return b;
    }

    public OrganisationseinheitDto map(Organisationseinheit o) {
        if (o == null) return null;
        OrganisationseinheitDto dto = new OrganisationseinheitDto();
        dto.setEinheitsnummer(o.getEinheitsnummer());
        dto.setName(o.getName());
        dto.setArt(o.getArt());
        dto.setStandortId(o.getStandort() != null ? o.getStandort().getStandortId() : null);
        dto.setUebergeordneteOeId(o.getUebergeordneteOe() != null ? o.getUebergeordneteOe().getEinheitsnummer() : null);
        dto.setLeiterId(o.getLeiter() != null ? o.getLeiter().getPersonalnummer() : null);
        return dto;
    }

    public Organisationseinheit map(OrganisationseinheitDto dto) {
        if (dto == null) return null;
        Organisationseinheit o = new Organisationseinheit();
        o.setEinheitsnummer(dto.getEinheitsnummer());
        o.setName(dto.getName());
        o.setArt(dto.getArt());
        if (dto.getStandortId() != null)
            o.setStandort(standortRepository.findById(dto.getStandortId()).orElse(null));
        if (dto.getUebergeordneteOeId() != null)
            o.setUebergeordneteOe(organisationseinheitRepository.findById(dto.getUebergeordneteOeId()).orElse(null));
        if (dto.getLeiterId() != null)
            o.setLeiter(mitarbeiterRepository.findById(dto.getLeiterId()).orElse(null));
        return o;
    }

    public MitgliedDto map(Mitglied m) {
        if (m == null) return null;
        MitgliedDto dto = new MitgliedDto();
        dto.setMitarbeiterId(m.getId().getMitarbeiter());
        dto.setOrganisationseinheitId(m.getId().getOrganisationseinheit());
        return dto;
    }

    public Mitglied map(MitgliedDto dto) {
        if (dto == null) return null;
        Mitglied m = new Mitglied();
        m.setId(new MitgliedId(dto.getMitarbeiterId(), dto.getOrganisationseinheitId()));
        if (dto.getMitarbeiterId() != null)
            m.setMitarbeiter(mitarbeiterRepository.findById(dto.getMitarbeiterId()).orElse(null));
        if (dto.getOrganisationseinheitId() != null)
            m.setOrganisationseinheit(organisationseinheitRepository.findById(dto.getOrganisationseinheitId()).orElse(null));
        return m;
    }

    public KundeDto map(Kunde k) {
        if (k == null) return null;
        KundeDto dto = new KundeDto();
        dto.setKundennummer(k.getKundennummer());
        dto.setFirmenname(k.getFirmenname());
        dto.setAdresseId(k.getAdresse() != null ? k.getAdresse().getAdresseId() : null);
        dto.setMobilnummer(k.getMobilnummer());
        dto.setEmail(k.getEmail());
        return dto;
    }

    public Kunde map(KundeDto dto) {
        if (dto == null) return null;
        Kunde k = new Kunde();
        k.setKundennummer(dto.getKundennummer());
        k.setFirmenname(dto.getFirmenname());
        if (dto.getAdresseId() != null)
            k.setAdresse(adresseRepository.findById(dto.getAdresseId()).orElse(null));
        k.setMobilnummer(dto.getMobilnummer());
        k.setEmail(dto.getEmail());
        return k;
    }

    public ItAssetDto map(ItAsset a) {
        if (a == null) return null;
        ItAssetDto dto = new ItAssetDto();
        dto.setIctoNummer(a.getIctoNummer());
        dto.setName(a.getName());
        dto.setStatus(a.getStatus());
        dto.setRisikostufe(a.getRisikostufe());
        dto.setBudget(a.getBudget());
        dto.setOrganisationseinheitId(a.getOrganisationseinheit() != null ? a.getOrganisationseinheit().getEinheitsnummer() : null);
        dto.setKundeId(a.getKunde() != null ? a.getKunde().getKundennummer() : null);
        return dto;
    }

    public ItAsset map(ItAssetDto dto) {
        if (dto == null) return null;
        ItAsset a = new ItAsset();
        a.setIctoNummer(dto.getIctoNummer());
        a.setName(dto.getName());
        a.setStatus(dto.getStatus());
        a.setRisikostufe(dto.getRisikostufe());
        a.setBudget(dto.getBudget());
        if (dto.getOrganisationseinheitId() != null)
            a.setOrganisationseinheit(organisationseinheitRepository.findById(dto.getOrganisationseinheitId()).orElse(null));
        if (dto.getKundeId() != null)
            a.setKunde(kundeRepository.findById(dto.getKundeId()).orElse(null));
        return a;
    }

    public AbhaengigkeitDto map(Abhaengigkeit a) {
        if (a == null) return null;
        AbhaengigkeitDto dto = new AbhaengigkeitDto();
        dto.setUpstreamItAsset(a.getId().getUpstreamItAsset());
        dto.setDownstreamItAsset(a.getId().getDownstreamItAsset());
        return dto;
    }

    public Abhaengigkeit map(AbhaengigkeitDto dto) {
        if (dto == null) return null;
        Abhaengigkeit a = new Abhaengigkeit();
        a.setId(new AbhaengigkeitId(dto.getUpstreamItAsset(), dto.getDownstreamItAsset()));
        if (dto.getUpstreamItAsset() != null)
            a.setUpstreamItAsset(itAssetRepository.findById(dto.getUpstreamItAsset()).orElse(null));
        if (dto.getDownstreamItAsset() != null)
            a.setDownstreamItAsset(itAssetRepository.findById(dto.getDownstreamItAsset()).orElse(null));
        return a;
    }

    public ItSystemDto map(ItSystem s) {
        if (s == null) return null;
        ItSystemDto dto = new ItSystemDto();
        dto.setIctoNummer(s.getIctoNummer());
        dto.setName(s.getName());
        dto.setStatus(s.getStatus());
        dto.setRisikostufe(s.getRisikostufe());
        dto.setBudget(s.getBudget());
        dto.setOrganisationseinheitId(s.getOrganisationseinheit() != null ? s.getOrganisationseinheit().getEinheitsnummer() : null);
        dto.setKundeId(s.getKunde() != null ? s.getKunde().getKundennummer() : null);
        dto.setEndOfLifeDatum(s.getEndOfLifeDatum());
        return dto;
    }

    public ItSystem map(ItSystemDto dto) {
        if (dto == null) return null;
        ItSystem s = new ItSystem();
        s.setIctoNummer(dto.getIctoNummer());
        s.setName(dto.getName());
        s.setStatus(dto.getStatus());
        s.setRisikostufe(dto.getRisikostufe());
        s.setBudget(dto.getBudget());
        if (dto.getOrganisationseinheitId() != null)
            s.setOrganisationseinheit(organisationseinheitRepository.findById(dto.getOrganisationseinheitId()).orElse(null));
        if (dto.getKundeId() != null)
            s.setKunde(kundeRepository.findById(dto.getKundeId()).orElse(null));
        s.setEndOfLifeDatum(dto.getEndOfLifeDatum());
        return s;
    }

    public ProjektDto map(Projekt p) {
        if (p == null) return null;
        ProjektDto dto = new ProjektDto();
        dto.setIctoNummer(p.getIctoNummer());
        dto.setName(p.getName());
        dto.setStatus(p.getStatus());
        dto.setRisikostufe(p.getRisikostufe());
        dto.setBudget(p.getBudget());
        dto.setOrganisationseinheitId(p.getOrganisationseinheit() != null ? p.getOrganisationseinheit().getEinheitsnummer() : null);
        dto.setKundeId(p.getKunde() != null ? p.getKunde().getKundennummer() : null);
        dto.setDeadline(p.getDeadline());
        dto.setFortschritt(p.getFortschritt());
        return dto;
    }

    public Projekt map(ProjektDto dto) {
        if (dto == null) return null;
        Projekt p = new Projekt();
        p.setIctoNummer(dto.getIctoNummer());
        p.setName(dto.getName());
        p.setStatus(dto.getStatus());
        p.setRisikostufe(dto.getRisikostufe());
        p.setBudget(dto.getBudget());
        if (dto.getOrganisationseinheitId() != null)
            p.setOrganisationseinheit(organisationseinheitRepository.findById(dto.getOrganisationseinheitId()).orElse(null));
        if (dto.getKundeId() != null)
            p.setKunde(kundeRepository.findById(dto.getKundeId()).orElse(null));
        p.setDeadline(dto.getDeadline());
        p.setFortschritt(dto.getFortschritt());
        return p;
    }

    public ArbeitsplatzDto map(Arbeitsplatz a) {
        if (a == null) return null;
        ArbeitsplatzDto dto = new ArbeitsplatzDto();
        dto.setBezeichnung(a.getId().getBezeichnung());
        dto.setStandortId(a.getId().getStandortId());
        dto.setLanVorhanden(a.getLanVorhanden());
        dto.setWlanVorhanden(a.getWlanVorhanden());
        return dto;
    }

    public Arbeitsplatz map(ArbeitsplatzDto dto) {
        if (dto == null) return null;
        Arbeitsplatz a = new Arbeitsplatz();
        a.setId(new ArbeitsplatzId(dto.getBezeichnung(), dto.getStandortId()));
        if (dto.getStandortId() != null)
            a.setBuerogebaeude(buerogebaeudeRepository.findById(dto.getStandortId()).orElse(null));
        a.setLanVorhanden(dto.getLanVorhanden());
        a.setWlanVorhanden(dto.getWlanVorhanden());
        return a;
    }

    public SchreibtischDto map(Schreibtisch s) {
        if (s == null) return null;
        SchreibtischDto dto = new SchreibtischDto();
        dto.setBezeichnung(s.getId().getBezeichnung());
        dto.setStandortId(s.getId().getStandortId());
        dto.setLanVorhanden(s.getLanVorhanden());
        dto.setWlanVorhanden(s.getWlanVorhanden());
        dto.setHoehenverstellbar(s.getHoehenverstellbar());
        dto.setAnzahlMonitore(s.getAnzahlMonitore());
        return dto;
    }

    public Schreibtisch map(SchreibtischDto dto) {
        if (dto == null) return null;
        Schreibtisch s = new Schreibtisch();
        s.setId(new ArbeitsplatzId(dto.getBezeichnung(), dto.getStandortId()));
        if (dto.getStandortId() != null)
            s.setBuerogebaeude(buerogebaeudeRepository.findById(dto.getStandortId()).orElse(null));
        s.setLanVorhanden(dto.getLanVorhanden());
        s.setWlanVorhanden(dto.getWlanVorhanden());
        s.setHoehenverstellbar(dto.getHoehenverstellbar());
        s.setAnzahlMonitore(dto.getAnzahlMonitore());
        return s;
    }

    public MeetingraumDto map(Meetingraum m) {
        if (m == null) return null;
        MeetingraumDto dto = new MeetingraumDto();
        dto.setBezeichnung(m.getId().getBezeichnung());
        dto.setStandortId(m.getId().getStandortId());
        dto.setLanVorhanden(m.getLanVorhanden());
        dto.setWlanVorhanden(m.getWlanVorhanden());
        dto.setKapazitaet(m.getKapazitaet());
        dto.setWebexBoardVorhanden(m.getWebexBoardVorhanden());
        return dto;
    }

    public Meetingraum map(MeetingraumDto dto) {
        if (dto == null) return null;
        Meetingraum m = new Meetingraum();
        m.setId(new ArbeitsplatzId(dto.getBezeichnung(), dto.getStandortId()));
        if (dto.getStandortId() != null)
            m.setBuerogebaeude(buerogebaeudeRepository.findById(dto.getStandortId()).orElse(null));
        m.setLanVorhanden(dto.getLanVorhanden());
        m.setWlanVorhanden(dto.getWlanVorhanden());
        m.setKapazitaet(dto.getKapazitaet());
        m.setWebexBoardVorhanden(dto.getWebexBoardVorhanden());
        return m;
    }

    public BuchungDto map(Buchung b) {
        if (b == null) return null;
        BuchungDto dto = new BuchungDto();
        dto.setBezeichnung(b.getId().getBezeichnung());
        dto.setStandortId(b.getId().getStandortId());
        dto.setDatum(b.getId().getDatum());
        dto.setMitarbeiterId(b.getMitarbeiter() != null ? b.getMitarbeiter().getPersonalnummer() : null);
        return dto;
    }

    public Buchung map(BuchungDto dto) {
        if (dto == null) return null;
        Buchung b = new Buchung();
        b.setId(new BuchungId(dto.getBezeichnung(), dto.getStandortId(), dto.getDatum()));
        if (dto.getStandortId() != null)
            b.setBuerogebaeude(buerogebaeudeRepository.findById(dto.getStandortId()).orElse(null));
        if (dto.getMitarbeiterId() != null)
            b.setMitarbeiter(mitarbeiterRepository.findById(dto.getMitarbeiterId()).orElse(null));
        return b;
    }
}
