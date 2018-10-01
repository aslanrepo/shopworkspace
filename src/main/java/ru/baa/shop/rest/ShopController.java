package ru.baa.shop.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.baa.shop.config.ShopConfig;
import ru.baa.shop.model.Shop;
import ru.baa.shop.root.rest.AbstractPageableController;
import ru.baa.shop.root.service.AbstractPageableService;

import java.util.List;

@RestController
public class ShopController extends AbstractPageableController<Shop> {

	private final ShopConfig shopConfig;

	@Autowired
	protected ShopController(@Qualifier("shopService") AbstractPageableService<Shop> service, ShopConfig shopConfig) {
		super(service);
		this.shopConfig = shopConfig;
	}

	@GetMapping("/shop/{id}")
	@Override
	public ResponseEntity<Shop> get(@PathVariable("id") Long id) {
		return super.get(id);
	}

	@PostMapping("/shop")
	@Override
	public ResponseEntity<Shop> post(@RequestBody Shop shop) {
		return super.post(shop);
	}

	@PutMapping("/shop")
	@Override
	public ResponseEntity<Shop> put(@RequestBody Shop shop) {
		return super.put(shop);
	}

	@DeleteMapping("/shop/{id}")
	@Override
	public ResponseEntity<Shop> delete(@PathVariable("id") Long id) {
		return super.delete(id);
	}

	@GetMapping("/shop/page/{page}")
	@Override
	public ResponseEntity<List<Shop>> findAllByPage(@PathVariable("page") int page) {
		List<Shop> shops = service.getAllByPage(shopConfig.getShopsWithCustomConfig(page));
		if (shops.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(shops);
	}
}
