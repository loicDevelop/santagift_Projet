package ex.santagift.services;

import java.util.List;

public interface GenericService<T> {

    public List<T> findAll();

    public T findById(Long id);

    public T save(T entity);

    public T update(Long id, T entity);

    public void delete(Long id);

}