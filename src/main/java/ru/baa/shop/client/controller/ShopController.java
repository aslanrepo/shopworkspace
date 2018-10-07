package ru.baa.shop.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.baa.shop.config.ShopConfig;
import ru.baa.shop.model.Shop;
import ru.baa.shop.root.client.controller.ViewController;
import ru.baa.shop.service.ShopService;

@Controller
public class ShopController implements ViewController {
	private final ShopService shopService;
	private final ShopConfig shopConfig;

	@Autowired
	public ShopController(ShopService shopService, ShopConfig shopConfig) {
		this.shopService = shopService;
		this.shopConfig = shopConfig;
	}

	@Override
	@GetMapping("/shop")
	public String main(Model model) {
		model.addAttribute("shops", shopService.findAll(shopConfig.getPageConfig(0)));
		return "shops";
	}

	@GetMapping("/shop/update/{id}")
	public String update(@PathVariable Long id, Model model) {
		Shop shop = shopService.read(id);
		model.addAttribute("shop", shop);
		model.addAttribute("shopType", Shop.Type.values());
		return "shop-operations";
	}

	@GetMapping("/shop/add")
	public String add(Model model) {
		model.addAttribute("shopType", Shop.Type.values());
		return "shop-operations";
	}
}
