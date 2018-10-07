package ru.baa.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.baa.shop.model.Shop;
import ru.baa.shop.repository.ShopRepository;
import ru.baa.shop.root.service.AbstractPageableService;

@Service
public class ShopService extends AbstractPageableService<Shop, Long> {

	private final ShopRepository shopRepository;

	@Autowired
	protected ShopService(ShopRepository jpaRepository) {
		super(jpaRepository);
		shopRepository = jpaRepository;
	}

	@Override
	public void delete(Long key) {
		throw new UnsupportedOperationException("Delete operation not supported");
	}

}
