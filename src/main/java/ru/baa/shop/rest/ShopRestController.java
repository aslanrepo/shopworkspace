package ru.baa.shop.rest;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.baa.shop.model.Shop;
import ru.baa.shop.model.dto.ShopDTO;
import ru.baa.shop.root.config.EntityConfig;
import ru.baa.shop.root.rest.PageableRestController;
import ru.baa.shop.service.ShopService;

import java.util.List;

@RestController
public class ShopRestController extends PageableRestController<Shop, ShopDTO, Long> {

	@Autowired
	protected ShopRestController(ShopService shopService, EntityConfig entityConfig, ModelMapper modelMapper) {
		super(shopService, entityConfig, modelMapper);
	}

	@Override
	@GetMapping("/shop/{id}")
	public ResponseEntity<ShopDTO> get(@PathVariable Long id) {
		return super.get(id);
	}

	@Override
	@PostMapping("/shop")
	public ResponseEntity<ShopDTO> post(@RequestBody ShopDTO shop) {
		return super.post(shop);
	}

	@Override
	@PutMapping("/shop/{id}")
	public ResponseEntity<ShopDTO> put(@PathVariable Long id, @RequestBody ShopDTO shop) {
		return super.put(id, shop);
	}

	@Override
	@DeleteMapping("/shop/{id}")
	public ResponseEntity<ShopDTO> delete(@PathVariable Long id) {
		return super.delete(id);
	}

	@Override
	@PatchMapping("/shop/{id}")
	public ResponseEntity<ShopDTO> patch(@PathVariable Long id, @RequestBody ShopDTO shop) {
		return super.patch(id, shop);
	}

	@Override
	@GetMapping("/shop/page/{page}")
	public ResponseEntity<List<ShopDTO>> getByPage(@PathVariable int page) {
		return super.getByPage(page);
	}
}
