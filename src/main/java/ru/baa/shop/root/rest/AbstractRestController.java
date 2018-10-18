package ru.baa.shop.root.rest;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import ru.baa.shop.root.model.BaseEntity;
import ru.baa.shop.root.service.AbstractCrudService;
import ru.baa.shop.root.util.ReflectionUtil;

public abstract class AbstractRestController<E extends BaseEntity, D, K> implements RestController<E, D, K> {

	private final AbstractCrudService<E, K> abstractCrudService;
	protected final ModelMapper modelMapper;

	Class<D> dtoClass;
	Class<E> entityClass;

	protected AbstractRestController(AbstractCrudService<E, K> abstractCrudService, ModelMapper modelMapper) {
		this.abstractCrudService = abstractCrudService;
		this.modelMapper = modelMapper;
		this.dtoClass = (Class<D>) ReflectionUtil.getDtoClass(this);
		this.entityClass = (Class<E>) ReflectionUtil.getEntityClass(this);
	}

	@Override
	public ResponseEntity<D> get(K id) {
		E entity = abstractCrudService.read(id);
		if (entity == null) {
			return ResponseEntity.notFound().build();
		}
		D dto = modelMapper.map(entity, dtoClass);
		return ResponseEntity.ok(dto);
	}

	@Override
	public ResponseEntity<D> post(D d) {
		E entity = modelMapper.map(d, entityClass);
		E persist = abstractCrudService.create(entity);
		return ResponseEntity.ok(d);
	}

	@Override
	public ResponseEntity<D> put(K id, D d) {
		E entity = modelMapper.map(d, entityClass);
		E persist = abstractCrudService.update(entity);
		return ResponseEntity.ok(d);
	}

	@Override
	public ResponseEntity<D> delete(K id) {
		if (abstractCrudService.existsById(id)) {
			abstractCrudService.delete(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

	//TODO продумать
	@Override
	public ResponseEntity<D> patch(K id, D d) {
		return null;
	}

}
