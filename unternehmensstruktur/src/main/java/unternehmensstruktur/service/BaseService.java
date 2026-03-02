package unternehmensstruktur.service;

import org.springframework.data.jpa.repository.JpaRepository;

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
        itemRepository.save(toEntity(dto));
    }

    public void saveEntity(I item) {
        itemRepository.save(item);
    }
}
