package ru.baa.shop.root.client.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/home")
public interface RootController {
	String main(Model model);
}
