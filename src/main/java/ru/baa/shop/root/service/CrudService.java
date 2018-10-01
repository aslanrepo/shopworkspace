package ru.baa.shop.root.service;

public interface CrudService<E> {
	E create(E e);
	E read(Long id);
	E update(E e);
	void delete(Long id);
}
