package unternehmensstruktur.views.single;

import unternehmensstruktur.model.dto.FirmaDto;
import unternehmensstruktur.service.FirmaService;

public class SingleFirmaView extends SimpleSingleView<FirmaDto> {

    public SingleFirmaView(FirmaService service) {
        super("firmen", FirmaDto.class,
                service::findById,
                service::save,
                dto -> service.deleteById(dto.getName()));
        setHeaderSupplier(() -> dto.getName());
    }

    @Override
    protected void addFields() {
        addField("Name",          () -> dto.getName(),       value -> { if (createMode) dto.setName((String) value); });
        addFkField("Standort-ID", () -> dto.getStandortId(), value -> dto.setStandortId(toInt(value)),   "standorte");
    }
}
