package ru.baa.shop.root.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api")
public interface RestController<E, K> {
	ResponseEntity get(K id);
	ResponseEntity post(E e);
	ResponseEntity put(K id, E e);
	ResponseEntity delete(K id);
	ResponseEntity patch(K id, E e);
}
