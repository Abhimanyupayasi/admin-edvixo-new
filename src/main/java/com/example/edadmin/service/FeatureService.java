package com.example.edadmin.service;

import org.springframework.stereotype.Service;

import com.example.edadmin.entity.Feature;
import com.example.edadmin.repository.FeatureRepository;

@Service
public class FeatureService {

    private final FeatureRepository repo;

    public FeatureService(FeatureRepository repo) {
        this.repo = repo;
    }

    public Feature createFeature(Feature feature) {

        if (repo.findByFeatureKey(feature.getFeatureKey()).isPresent()) {
            throw new RuntimeException("Feature key exists");
        }

        return repo.save(feature);
    }
}
