package ru.baa.shop.root.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;
import ru.baa.shop.model.Shop;

@NoRepositoryBean
public interface AbstractRepository<E> extends JpaRepository<E, Long> {
}
