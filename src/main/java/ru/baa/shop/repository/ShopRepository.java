package ru.baa.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.baa.shop.model.Shop;

public interface ShopRepository extends JpaRepository<Shop, Long> {
}
