package ru.baa.shop.root.rest;

import org.springframework.http.ResponseEntity;
import ru.baa.shop.root.service.AbstractCrudService;

public abstract class AbstractRestController<E, K> implements RestController<E, K> {

	private final AbstractCrudService<E, K> abstractCrudService;

	protected AbstractRestController(AbstractCrudService<E, K> abstractCrudService) {
		this.abstractCrudService = abstractCrudService;
	}

	@Override
	public ResponseEntity get(K id) {
		E entity = abstractCrudService.read(id);
		if (entity != null) {
			return ResponseEntity.ok(entity);
		}
		return ResponseEntity.notFound().build();
	}

	@Override
	public ResponseEntity post(E e) {
		E entity = abstractCrudService.create(e);
		return ResponseEntity.ok(entity);
	}

	@Override
	public ResponseEntity put(K id, E e) {
		E entity = abstractCrudService.update(e);
		return ResponseEntity.ok(entity);
	}

	@Override
	public ResponseEntity delete(K id) {
		if(abstractCrudService.existsById(id)) {
			abstractCrudService.delete(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

	//TODO продумать
	@Override
	public ResponseEntity patch(K id, E e) {
		return null;
	}


}
