package com.example.edadmin.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.example.edadmin.entity.Plan;
import com.example.edadmin.repository.PlanRepository;

@Service
public class PlanService {

    private final PlanRepository repo;

    public PlanService(PlanRepository repo) {
        this.repo = repo;
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
}