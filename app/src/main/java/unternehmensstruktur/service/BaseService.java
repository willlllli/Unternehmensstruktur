package unternehmensstruktur.service;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Field;
import java.util.List;

public abstract class BaseService<I, D, R extends JpaRepository<I, ID>, ID> {

    protected final R itemRepository;
    protected final Mappingservice<?, ?> mappingservice;

    protected BaseService(R itemRepository, Mappingservice<?, ?> mappingservice) {
        this.itemRepository = itemRepository;
        this.mappingservice = mappingservice;
    }

    protected abstract D toDto(I entity);

    protected abstract I toEntity(D dto);

    public List<D> findAll() {
        return itemRepository.findAll().stream().map(this::toDto).toList();
    }

    public D findById(ID id) {
        return toDto(itemRepository.findById(id).orElseThrow(RuntimeException::new));
    }

    public I getEntityById(ID id) {
        return itemRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public void deleteById(ID id) {
        itemRepository.deleteById(id);
    }

    public void save(D dto) {
        itemRepository.saveAndFlush(toEntity(dto));
    }

    /**
     * Speichert einen neuen Datensatz und verhindert, dass dabei versehentlich
     * ein bestehender Eintrag mit gleichem Primärschlüssel überschrieben wird.
     */
    @Transactional
    public void saveNew(D dto) {
        I entity = toEntity(dto);
        ID id = extractId(entity);

        if (id != null && itemRepository.existsById(id)) {
            throw new IllegalArgumentException("Ein Eintrag mit diesem Primärschlüssel existiert bereits.");
        }

        itemRepository.saveAndFlush(entity);
    }

    public void saveEntity(I item) {
        itemRepository.saveAndFlush(item);
    }

    /**
     * Liest generisch den (ggf. zusammengesetzten) Primärschlüssel eines JPA-Entities
     * über Reflection aus (@Id oder @EmbeddedId).
     */
    @SuppressWarnings("unchecked")
    protected ID extractId(I entity) {
        if (entity == null) {
            return null;
        }

        Class<?> type = entity.getClass();
        while (type != null && type != Object.class) {
            for (Field field : type.getDeclaredFields()) {
                if (field.isAnnotationPresent(Id.class) || field.isAnnotationPresent(EmbeddedId.class)) {
                    field.setAccessible(true);
                    try {
                        return (ID) field.get(entity);
                    } catch (IllegalAccessException e) {
                        throw new IllegalStateException("Primärschlüssel konnte nicht aus dem Entity gelesen werden.", e);
                    }
                }
            }
            type = type.getSuperclass();
        }
        return null;
    }
}
