package com.example.edadmin.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.edadmin.entity.Plan;
import com.example.edadmin.entity.PlanFeature;
import com.example.edadmin.repository.PlanRepository;
import com.example.edadmin.repository.PlanFeatureRepository;


import java.util.stream.Collectors;
import com.example.edadmin.dto.FeatureDTO;
import com.example.edadmin.dto.PlanResponse;

@Service
public class PlanService {
    private final PlanFeatureRepository planFeatureRepository;



public List<PlanResponse> getAllPlansWithFeatures() {

    return repo.findAll().stream().map(plan -> {

        PlanResponse res = new PlanResponse();
        res.setId(plan.getId());
        res.setName(plan.getName());
        res.setPrice(plan.getPrice());
        res.setFree(plan.isFree());

        if (plan.getPlanFeatures() != null) {
            res.setFeatures(
                plan.getPlanFeatures().stream().map(pf -> {
                    FeatureDTO dto = new FeatureDTO();
                    dto.setFeatureId(pf.getFeature().getId());
                    dto.setName(pf.getFeature().getName());
                    dto.setValue(pf.getValue());
                    return dto;
                }).collect(Collectors.toList())
            );
        }

        return res;

    }).collect(Collectors.toList());
}

    private final PlanRepository repo;
public PlanService(PlanRepository repo, PlanFeatureRepository planFeatureRepository) {
    this.repo = repo;
    this.planFeatureRepository = planFeatureRepository;
}

    // CREATE
    public Plan create(Plan plan) {
        return repo.save(plan);
    }

    // GET ALL
    public List<Plan> getAll() {
        return repo.findAll();
    }

    // GET BY ID
    public Plan getById(UUID id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Plan not found"));
    }

    // UPDATE
    public Plan update(UUID id, Plan updated) {
        Plan plan = getById(id);

        plan.setName(updated.getName());
        plan.setDescription(updated.getDescription());
        plan.setPrice(updated.getPrice());
        plan.setFree(updated.isFree());
        plan.setDurationValue(updated.getDurationValue());
        plan.setDurationUnit(updated.getDurationUnit());
        plan.setActive(updated.isActive());

        return repo.save(plan);
    }

    // DELETE
    public void delete(UUID id) {
        Plan plan = getById(id);
        repo.delete(plan);
    }

    public List<PlanFeature> getPlanFeaturesByPlanId(UUID planId) {
        return planFeatureRepository.findByPlanId(planId);
    }

    public List<PlanFeature> getPlanFeaturesByFeatureId(UUID featureId) {
        return planFeatureRepository.findByFeatureId(featureId);
    }
}