package ru.baa.shop.root.service;

import ru.baa.shop.root.repository.AbstractRepository;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

public abstract class AbstractService<E> implements CrudService<E> {
	protected final AbstractRepository<E> abstractRepository;

	protected AbstractService(AbstractRepository<E> abstractRepository) {
		this.abstractRepository = abstractRepository;
	}

	@Override
	public E create(E e) {
		return abstractRepository.save(e);
	}

	@Override
	public E read(Long id) {
		Optional<E> optionalEntity = abstractRepository.findById(id);
		if (optionalEntity.isPresent()) {
			return optionalEntity.get();
		}
		throw new EntityNotFoundException();
	}

	@Override
	public E update(E e) {
		return abstractRepository.save(e);
	}

	@Override
	public void delete(Long id) {
		abstractRepository.deleteById(id);
	}
}
