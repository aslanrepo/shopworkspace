package ru.baa.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.baa.shop.model.Shop;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long> {

}
