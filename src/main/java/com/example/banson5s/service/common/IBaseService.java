package com.example.banson5s.service.common;

import com.example.banson5s.entity.common.BaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface IBaseService<E extends BaseEntity, ID extends Serializable> {
    E createNew(E entity);

    E update(E entity);

    void physicalDelete(ID id);

    void delete(ID id);

    void delete(E entity);

    Optional<E> findById(ID id);

    List<E> findAllLst();

    Boolean existsById(ID id);

    Page<E> findAll(@Nullable Specification<E> spec, Pageable page);

    Page<E> findAllDeletedFalse(Pageable page);
}