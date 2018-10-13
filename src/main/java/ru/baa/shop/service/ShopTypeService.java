package ru.baa.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.baa.shop.model.ShopType;
import ru.baa.shop.repository.ShopTypeRepository;
import ru.baa.shop.root.service.AbstractCrudService;

import java.util.List;

@Service
public class ShopTypeService extends AbstractCrudService<ShopType, Long> {

	private final ShopTypeRepository shopTypeRepository;

	@Autowired
	public ShopTypeService(ShopTypeRepository jpaRepository) {
		super(jpaRepository);
		this.shopTypeRepository = jpaRepository;
	}

	public List<ShopType> findAll() {
		return shopTypeRepository.findAll();
	}
}
