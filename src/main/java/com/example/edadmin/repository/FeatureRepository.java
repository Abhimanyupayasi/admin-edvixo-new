package com.example.edadmin.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.edadmin.entity.Feature;

@Repository
public interface FeatureRepository extends JpaRepository<Feature, UUID> {

    Optional<Feature> findByFeatureKey(String featureKey);
     boolean existsByFeatureKey(String featureKey);
}