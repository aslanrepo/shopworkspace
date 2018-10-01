package ru.baa.shop.root.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.baa.shop.root.repository.AbstractRepository;

import java.util.List;

public abstract class AbstractPageableService<E> extends AbstractService<E> implements PageableService<E>{

	protected AbstractPageableService(AbstractRepository<E> abstractRepository) {
		super(abstractRepository);
	}

	@Override
	public List<E> getAllByPage(Pageable pageable) {
		Page<E> page = abstractRepository.findAll(pageable);
		return page.getContent();
	}
}
