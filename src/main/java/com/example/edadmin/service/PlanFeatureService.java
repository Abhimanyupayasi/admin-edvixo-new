package com.example.edadmin.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.edadmin.entity.Feature;
import com.example.edadmin.entity.Plan;
import com.example.edadmin.entity.PlanFeature;
import com.example.edadmin.repository.FeatureRepository;
import com.example.edadmin.repository.PlanFeatureRepository;
import com.example.edadmin.repository.PlanRepository;

@Service
public class PlanFeatureService {

    private final PlanRepository planRepo;
    private final FeatureRepository featureRepo;
    private final PlanFeatureRepository repo;

    public PlanFeatureService(PlanRepository planRepo,
                              FeatureRepository featureRepo,
                              PlanFeatureRepository repo) {
        this.planRepo = planRepo;
        this.featureRepo = featureRepo;
        this.repo = repo;
    }

    public PlanFeature attach(UUID planId, UUID featureId, String value) {

        Plan plan = planRepo.findById(planId)
                .orElseThrow(() -> new RuntimeException("Plan not found"));

        Feature feature = featureRepo.findById(featureId)
                .orElseThrow(() -> new RuntimeException("Feature not found"));

        PlanFeature pf = new PlanFeature();
        pf.setPlan(plan);
        pf.setFeature(feature);
        pf.setValue(value);

        return repo.save(pf);
    }
}