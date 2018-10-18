package ru.baa.shop.client.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.baa.shop.client.config.ShopConfig;
import ru.baa.shop.model.Shop;
import ru.baa.shop.model.dto.ShopDTO;
import ru.baa.shop.root.client.controller.RootController;
import ru.baa.shop.service.ShopService;
import ru.baa.shop.service.ShopTypeService;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ShopController implements RootController {
	private final ShopService shopService;
	private final ShopConfig shopConfig;
	private final ShopTypeService shopTypeService;
	private final ModelMapper modelMapper;

	@Autowired
	public ShopController(ShopService shopService, ShopConfig shopConfig, ShopTypeService shopTypeService, ModelMapper modelMapper) {
		this.shopService = shopService;
		this.shopConfig = shopConfig;
		this.shopTypeService = shopTypeService;
		this.modelMapper = modelMapper;
	}

	@Override
	@GetMapping("/shop")
	public String main(Model model) {
		List<Shop> shops = shopService.findAll(shopConfig.getPageConfig(0));
		List<ShopDTO> shopDTOs = shops.stream().map(n-> modelMapper.map(n, ShopDTO.class)).collect(Collectors.toList());
		model.addAttribute("shops", shopDTOs);
		return "shops";
	}

	@GetMapping("/shop/update/{id}")
	public String update(@PathVariable Long id, Model model) {
		Shop shop = shopService.read(id);
		ShopDTO shopDTO = modelMapper.map(shop, ShopDTO.class);
		model.addAttribute("shop", shopDTO);
		model.addAttribute("shopTypes", shopTypeService.findAll());
		return "shop-operations";
	}

	@GetMapping("/shop/add")
	public String add(Model model) {
		model.addAttribute("shopTypes", shopTypeService.findAll());
		return "shop-operations";
	}
}
