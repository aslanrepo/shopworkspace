package ru.baa.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ru.baa.shop.model.Shop;
import ru.baa.shop.root.repository.AbstractRepository;
import ru.baa.shop.root.service.AbstractPageableService;
import ru.baa.shop.root.service.PageableService;

import java.time.LocalDateTime;
import java.util.List;

@Service("shopService")
public class ShopService extends AbstractPageableService<Shop> implements PageableService<Shop> {

	@Autowired
	protected ShopService(AbstractRepository<Shop> abstractRepository) {
		super(abstractRepository);
	}

	@Override
	public List<Shop> getAllByPage(Pageable pageable) {
		return abstractRepository.findAll(pageable).getContent();
	}

	@Override
	public Shop create(Shop shop) {
		shop.setCreationDate(LocalDateTime.now());
		return super.create(shop);
	}
}
