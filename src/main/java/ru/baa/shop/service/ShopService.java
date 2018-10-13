package ru.baa.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.baa.shop.model.Shop;
import ru.baa.shop.repository.ShopRepository;
import ru.baa.shop.root.service.AbstractPageableService;

@Service
public class ShopService extends AbstractPageableService<Shop, Long> {

	private final ShopRepository shopRepository;
	private final ShopTypeService shopTypeService;

	@Autowired
	protected ShopService(ShopRepository jpaRepository, ShopTypeService shopTypeService) {
		super(jpaRepository);
		shopRepository = jpaRepository;
		this.shopTypeService = shopTypeService;
	}

	@Override
	public void delete(Long key) {
		throw new UnsupportedOperationException("Delete operation not supported");
	}

	@Override
	public Shop update(Shop shop) {
		return super.update(shop);
	}

	@Override
	public Shop create(Shop shop) {
		return super.create(shop);
	}
}
