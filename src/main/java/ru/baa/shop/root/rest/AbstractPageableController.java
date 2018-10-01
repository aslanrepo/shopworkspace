package ru.baa.shop.root.rest;

import ru.baa.shop.root.service.PageableService;

public abstract class AbstractPageableController<E> extends AbstractController<E> implements PageableController<E>{

	protected AbstractPageableController(PageableService<E> service) {
		super(service);
	}
}
