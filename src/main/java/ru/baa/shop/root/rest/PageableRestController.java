package ru.baa.shop.root.rest;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import ru.baa.shop.root.config.EntityConfig;
import ru.baa.shop.root.model.BaseEntity;
import ru.baa.shop.root.service.AbstractPageableService;

import java.util.List;
import java.util.stream.Collectors;

public abstract class PageableRestController<E extends BaseEntity, D, K> extends AbstractRestController<E, D, K> {

	private final AbstractPageableService<E, K> abstractPageableService;
	protected final EntityConfig entityConfig;

	protected PageableRestController(AbstractPageableService<E, K> abstractPageableService, EntityConfig entityConfig, ModelMapper modelMapper) {
		super(abstractPageableService, modelMapper);
		this.abstractPageableService = abstractPageableService;
		this.entityConfig = entityConfig;
	}

	public ResponseEntity<List<D>> getByPage(int page) {
		List<E> listOfEntity = abstractPageableService.findAll(entityConfig.getPageConfig(page));
		if (listOfEntity.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		List<D> listOfDto = listOfEntity.stream().map(n -> modelMapper.map(n, dtoClass)).collect(Collectors.toList());
		return ResponseEntity.ok(listOfDto);
	}
}