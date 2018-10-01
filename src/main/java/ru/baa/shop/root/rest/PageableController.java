package ru.baa.shop.root.rest;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PageableController<E> extends ControllerI<E>{
	ResponseEntity<List<E>> findAllByPage(int page);
}
