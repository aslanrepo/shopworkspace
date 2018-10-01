package ru.baa.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.baa.shop.config.ShopConfig;
import ru.baa.shop.model.Shop;
import ru.baa.shop.root.service.PageableService;

@Controller
@RequestMapping("/home")
public class ShopViewController {
	private static final String SHOP_URL = "/shop";

	private final PageableService<Shop> shopService;
	private final ShopConfig shopConfig;

	@Autowired
	public ShopViewController(PageableService<Shop> shopService, ShopConfig shopConfig) {
		this.shopService = shopService;
		this.shopConfig = shopConfig;
	}

	@GetMapping(SHOP_URL)
	public String shops(Model model) {
		model.addAttribute("shops", shopService.getAllByPage(shopConfig.getShopsWithCustomConfig(0)));
		return "shops";
	}

	@GetMapping(SHOP_URL + "/add")
	public String addShop(Model model) {
		model.addAttribute("shopType", Shop.Type.values());
		return "shop-operations";
	}

	@GetMapping(SHOP_URL + "/update/{id}")
	public String updateShop(@PathVariable("id") Long id, Model model) {
		Shop shop = shopService.read(id);
		model.addAttribute("shopType", Shop.Type.values());
		model.addAttribute("shop", shop);
		return "shop-operations";
	}
}
