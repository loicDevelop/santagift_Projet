package ex.santagift.services.mapper;

import java.util.List;

public interface ToDtoMapper<E, D> {
    D toDto(E var);

    List<D> toDto(List<E> vars);
}
