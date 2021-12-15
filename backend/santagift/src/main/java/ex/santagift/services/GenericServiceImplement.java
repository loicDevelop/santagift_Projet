package ex.santagift.services;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public class GenericServiceImplement<T> implements GenericService<T> {

    private JpaRepository<T, Long> repository;


    public GenericServiceImplement(JpaRepository<T, Long> repository) {
        this.repository = repository;
    }

    @Override
    public List<T> findAll() {
        return this.repository.findAll();
    }

    @Override
    public T findById(Long id) {
        return this.repository.findById(id).get();
    }

    @Override
    public T save(T entity) {
        return this.repository.save(entity);
    }

    @Override
    public T update(Long id, T entity) {
        return this.repository.save(entity);
    }

    @Override
    public void delete(Long id) {
        this.repository.deleteById(id);
    }

}
