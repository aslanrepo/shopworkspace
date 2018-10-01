package ru.baa.shop.root.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.baa.shop.root.service.PageableService;

@RequestMapping("/api")
public abstract class AbstractController<E> implements ControllerI<E> {

	protected final PageableService<E> service;

	protected AbstractController(PageableService<E> service) {
		this.service = service;
	}

	@Override
	public ResponseEntity<E> get(Long id) {
		E entity = service.read(id);
		return ResponseEntity.ok(entity);
	}

	@Override
	public ResponseEntity<E> post(E e) {
		E entity = service.create(e);
		return ResponseEntity.ok(entity);
	}

	@Override
	public ResponseEntity<E> put(E e) {
		E entity = service.update(e);
		return ResponseEntity.ok(entity);
	}

	@Override
	public ResponseEntity<E> delete(Long id) {
		service.delete(id);
		return ResponseEntity.ok().build();
	}
}
