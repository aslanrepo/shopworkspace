package ru.baa.shop.root.client.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/home")
public interface ViewController {
	String main(Model model);
}
