package com.example.edadmin.service;

import org.springframework.stereotype.Service;

import com.example.edadmin.entity.Feature;
import com.example.edadmin.repository.FeatureRepository;

import java.util.List;
import java.util.UUID;

@Service
public class FeatureService {

    private final FeatureRepository repo;

    public FeatureService(FeatureRepository repo) {
        this.repo = repo;
    }

    // CREATE (already done)
    public Feature createFeature(Feature feature) {
        if (repo.findByFeatureKey(feature.getFeatureKey()).isPresent()) {
            throw new RuntimeException("Feature key exists");
        }
        return repo.save(feature);
    }

    // GET ALL
    public List<Feature> getAllFeatures() {
        return repo.findAll();
    }

    // GET BY ID
    public Feature getFeatureById(UUID id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Feature not found"));
    }

    // UPDATE
    public Feature updateFeature(UUID id, Feature updatedFeature) {
        Feature existing = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Feature not found"));

        // check duplicate key (if changed)
        if (!existing.getFeatureKey().equals(updatedFeature.getFeatureKey())
                && repo.existsByFeatureKey(updatedFeature.getFeatureKey())) {
            throw new RuntimeException("Feature key already exists");
        }

        existing.setName(updatedFeature.getName());
        existing.setFeatureKey(updatedFeature.getFeatureKey());
        existing.setDescription(updatedFeature.getDescription());

        return repo.save(existing);
    }

    // DELETE
    public void deleteFeature(UUID id) {
        Feature existing = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Feature not found"));

        repo.delete(existing);
    }
}