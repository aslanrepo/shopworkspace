package ru.baa.shop.root.rest;

import org.springframework.http.ResponseEntity;

public interface ControllerI<E> {
	ResponseEntity<E> get(Long id);
	ResponseEntity<E> post(E e);
	ResponseEntity<E> put(E e);
	ResponseEntity<E> delete(Long id);
}
