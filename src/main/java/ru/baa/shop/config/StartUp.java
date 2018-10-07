package ru.baa.shop.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.baa.shop.model.Shop;
import ru.baa.shop.root.repository.batch.BatchRepository;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class StartUp {

	private final BatchRepository<Shop> batchRepository;

	@Autowired
	public StartUp(BatchRepository<Shop> batchRepository) {
		this.batchRepository = batchRepository;
	}

	@PostConstruct
	public void init() {
		List<Shop> shops = new ArrayList<>();
		for (int i = 1; i <= 1000; i++) {
			Shop shop = new Shop("Магазин тест " + i, "address", 3);
			shop.setCreationDate(LocalDateTime.now());
			shops.add(shop);
		}
		batchRepository.batchCreate(shops);
	}
}
