package ru.baa.shop.root.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class AbstractPageableService<E, K> extends AbstractCrudService<E, K> {

	protected AbstractPageableService(JpaRepository<E, K> jpaRepository) {
		super(jpaRepository);
	}

	public List<E> findAll(Pageable pageable) {
		Page<E> page = jpaRepository.findAll(pageable);
		return page.getContent();
	}


}
