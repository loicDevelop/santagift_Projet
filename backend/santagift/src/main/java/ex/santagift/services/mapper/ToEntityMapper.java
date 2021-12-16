package ex.santagift.services.mapper;

import java.util.List;

public interface ToEntityMapper<D, E> {
    E toEntity(D var);

    List<E> toEntity(List<D> vars);
}