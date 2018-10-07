package ru.baa.shop.root.service;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.NoSuchElementException;
import java.util.Optional;

public abstract class AbstractCrudService<E, K> implements CrudService<E, K> {

	final JpaRepository<E, K> jpaRepository;

	AbstractCrudService(JpaRepository<E, K> jpaRepository) {
		this.jpaRepository = jpaRepository;
	}

	@Override
	public E create(E e) {
		return jpaRepository.save(e);
	}

	@Override
	public E read(K key) {
		Optional<E> optEntity = jpaRepository.findById(key);
		if (optEntity.isPresent()) {
			return optEntity.get();
		}
		throw new NoSuchElementException("Cant't find entity with key: " + key);
	}

	@Override
	public E update(E e) {
		return jpaRepository.save(e);
	}

	@Override
	public void delete(K key) {
		jpaRepository.deleteById(key);
	}

	@Override
	public boolean existsById(K key) {
		return jpaRepository.existsById(key);
	}
}
