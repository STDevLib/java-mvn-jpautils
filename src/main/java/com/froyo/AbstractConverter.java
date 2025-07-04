package com.froyo;

import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractConverter<E, D> {

    public abstract E fromDto(D dto);

    public abstract D fromEntity(E entity);

    public List<E> fromDto(List<D> dtos) {
        if (dtos == null) return null;
        return dtos.stream().map(this::fromDto).collect(Collectors.toList());
    }

    public List<D> fromEntity(List<E> entities) {
        if (entities == null) return null;
        return entities.stream().map(this::fromEntity).collect(Collectors.toList());
    }
}
