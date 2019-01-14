package ru.baa.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.baa.shop.model.Feature;

public interface FeatureRepository extends JpaRepository<Feature, String> {
}
