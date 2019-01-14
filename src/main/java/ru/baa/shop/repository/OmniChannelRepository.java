package ru.baa.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.baa.shop.model.OmniChannel;

public interface OmniChannelRepository extends JpaRepository<OmniChannel, String> {
}
