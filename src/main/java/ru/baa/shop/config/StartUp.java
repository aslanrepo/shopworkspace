package ru.baa.shop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.baa.shop.model.Shop;
import ru.baa.shop.root.service.CrudService;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;

@Component
public class StartUp {

	private final CrudService<Shop> shopService;

	@Autowired
	public StartUp(CrudService<Shop> shopService) {
		this.shopService = shopService;
	}

	@PostConstruct
	public void init() {
		for (int i = 0; i < 100; i++) {
			Shop shop = new Shop("Магазин тест " + i, "address", 3);
			shop.setCreationDate(LocalDateTime.now());
			shopService.create(shop);
		}
	}
}
