package ru.baa.shop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.baa.shop.model.Shop;
import ru.baa.shop.model.ShopType;
import ru.baa.shop.root.repository.batch.BatchRepository;
import ru.baa.shop.service.ShopTypeService;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class StartUp {

	private final BatchRepository batchRepository;
	private final ShopTypeService shopTypeService;

	@Autowired
	public StartUp(BatchRepository<Shop> batchRepository, ShopTypeService shopTypeService) {
		this.batchRepository = batchRepository;
		this.shopTypeService = shopTypeService;
	}

	@PostConstruct
	public void init() {
		List<Shop> shops = new ArrayList<>();
		for (int i = 1; i <= 150; i++) {
			Shop shop = new Shop("Магазин тест " + i, "address", 3);
			shop.setCreationDate(LocalDateTime.of(2017, (int)(Math.random() * 10 + 1), (int)(Math.random() * 25 + 1),(int)(Math.random() * 23 + 1),(int)(Math.random() * 59 + 1)));
			shops.add(shop);
		}
		List<ShopType> shopTypes = new ArrayList<>();
		shopTypes.add(new ShopType("Продуктовый"));
		shopTypes.add(new ShopType("Супермаркет"));
		shopTypes.add(new ShopType("Электроника"));
		batchRepository.batchCreate(shopTypes);
		batchRepository.batchCreate(shops);
	}
}
