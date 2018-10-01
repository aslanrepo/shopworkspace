package ru.baa.shop.root.service;

import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PageableService<E> extends CrudService<E> {
	List<E> getAllByPage(Pageable pageable);
}
