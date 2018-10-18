package ru.baa.shop.root.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.baa.shop.root.model.BaseEntity;

/**
 * Common Rest Controller
 * @param <E> Entity
 * @param <D> DTO
 * @param <K> Entity Key
 */
@RequestMapping("/api")
public interface RestController<E extends BaseEntity, D, K> {
	ResponseEntity<D> get(K id);

	ResponseEntity<D> post(D d);

	ResponseEntity<D> put(K id, D d);

	ResponseEntity<D> delete(K id);

	ResponseEntity<D> patch(K id, D d);
}
