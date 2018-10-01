package ru.baa.shop.repository;

import org.springframework.stereotype.Repository;
import ru.baa.shop.model.Shop;
import ru.baa.shop.root.repository.AbstractRepository;

@Repository
public interface ShopRepository extends AbstractRepository<Shop> {
}
