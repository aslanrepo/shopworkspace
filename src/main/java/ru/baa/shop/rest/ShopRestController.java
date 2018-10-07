package ru.baa.shop.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.baa.shop.root.config.EntityConfig;
import ru.baa.shop.model.Shop;
import ru.baa.shop.root.rest.PageableRestController;
import ru.baa.shop.service.ShopService;

@RestController
public class ShopRestController extends PageableRestController<Shop, Long> {

	@Autowired
	protected ShopRestController(ShopService shopService, EntityConfig entityConfig) {
		super(shopService, entityConfig);
	}

	@Override
	@GetMapping("/shop/{id}")
	public ResponseEntity get(@PathVariable Long id) {
		return super.get(id);
	}

	@Override
	@PostMapping("/shop")
	public ResponseEntity post(@RequestBody Shop shop) {
		return super.post(shop);
	}

	@Override
	@PutMapping("/shop/{id}")
	public ResponseEntity put(@PathVariable Long id, @RequestBody Shop shop) {
		return super.put(id, shop);
	}

	@Override
	@DeleteMapping("/shop/{id}")
	public ResponseEntity delete(@PathVariable Long id) {
		return super.delete(id);
	}

	@Override
	@PatchMapping("/shop/{id}")
	public ResponseEntity patch(@PathVariable Long id, @RequestBody Shop shop) {
		return super.patch(id, shop);
	}

	@Override
	@GetMapping("/shop/page/{page}")
	public ResponseEntity get(@PathVariable int page) {
		return super.get(page);
	}
}
