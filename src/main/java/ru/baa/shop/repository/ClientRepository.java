package ru.baa.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.baa.shop.model.Client;

public interface ClientRepository extends JpaRepository<Client, String> {
}
