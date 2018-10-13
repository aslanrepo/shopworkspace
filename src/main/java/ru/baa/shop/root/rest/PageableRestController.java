package ru.baa.shop.root.rest;

import org.springframework.http.ResponseEntity;
import ru.baa.shop.root.config.EntityConfig;
import ru.baa.shop.root.service.AbstractPageableService;

import java.util.List;

public abstract class PageableRestController<E, K> extends AbstractRestController<E, K> {

	private final AbstractPageableService<E, K> abstractPageableService;
	protected final EntityConfig entityConfig;

	protected PageableRestController(AbstractPageableService<E, K> abstractPageableService, EntityConfig entityConfig) {
		super(abstractPageableService);
		this.abstractPageableService = abstractPageableService;
		this.entityConfig = entityConfig;
	}

	public ResponseEntity getByPage(int page) {
		 List<E> listOfEntity = abstractPageableService.findAll(entityConfig.getPageConfig(page));
		 if (listOfEntity.isEmpty()) {
		 	return ResponseEntity.notFound().build();
		 }
		 return ResponseEntity.ok(listOfEntity);
	}
}