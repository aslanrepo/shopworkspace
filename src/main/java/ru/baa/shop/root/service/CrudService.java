package ru.baa.shop.root.service;

public interface CrudService<E, K> {
	E create(E e);
	E read(K key);
	E update(E e);
	void delete(K key);

	boolean existsById(K key);
}
