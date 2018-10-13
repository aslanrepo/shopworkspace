package ru.baa.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.baa.shop.model.ShopType;

public interface ShopTypeRepository extends JpaRepository<ShopType, Long> {
}
