package unternehmensstruktur.views.single;

import unternehmensstruktur.model.dto.TelekomShopDto;
import unternehmensstruktur.service.TelekomShopService;

public class SingleTelekomShopView extends SimpleSingleView<TelekomShopDto> {

    public SingleTelekomShopView(TelekomShopService service) {
        super("telekom-shops", TelekomShopDto.class,
                param -> service.findById(Integer.parseInt(param)),
                service::save,
                dto -> service.deleteById(dto.getStandortId()));
        setHeaderSupplier(() -> "Telekom Shop #" + dto.getStandortId());
    }

    @Override
    protected void addFields() {
        addField("Standort-ID",          () -> dto.getStandortId(),       value -> {},                                          Integer.class);
        addFkField("Firma",              () -> dto.getFirma(),            value -> dto.setFirma((String) value),                "firmen");
        addFkField("Adresse-ID",         () -> dto.getAdresseId(),        value -> dto.setAdresseId(toInt(value)),              "adressen");
        addFkField("Verantwortlicher",   () -> dto.getVerantwortlicher(), value -> dto.setVerantwortlicher(toInt(value)),       "mitarbeiter");
        addField("Öffnungszeit",         () -> dto.getOeffnungszeit(),    value -> dto.setOeffnungszeit(toTime(value)));
        addField("Schließzeit",          () -> dto.getSchliesszeit(),     value -> dto.setSchliesszeit(toTime(value)));
        addField("Bestand Router",       () -> dto.getBestandRouter(),    value -> dto.setBestandRouter(toInt(value)),          Integer.class);
        addField("Bestand Handys",       () -> dto.getBestandHandys(),    value -> dto.setBestandHandys(toInt(value)),          Integer.class);
        addField("Bestand SIM-Karten",   () -> dto.getBestandSimKarten(), value -> dto.setBestandSimKarten(toInt(value)),       Integer.class);
    }
}
