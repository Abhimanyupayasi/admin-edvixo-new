package com.example.edadmin.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.*;

import com.example.edadmin.dto.PlanResponse;
import com.example.edadmin.entity.Plan;
import com.example.edadmin.service.PlanService;

@RestController
@RequestMapping("/plans")
public class PlanController {

    private final PlanService service;

    public PlanController(PlanService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    public Plan create(@RequestBody Plan plan) {
        return service.create(plan);
    }

    // GET ALL

    @GetMapping
   public List<PlanResponse> getAllPlans() {
    return service.getAllPlansWithFeatures();
}

    // GET BY ID
    @GetMapping("/{id}")
    public Plan getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Plan update(@PathVariable UUID id, @RequestBody Plan plan) {
        return service.update(id, plan);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable UUID id) {
        service.delete(id);
        return "Plan deleted successfully";
    }

    // PRICING API
    @GetMapping("/pricing")
    public List<PlanResponse> getPricing() {
        return service.getAllPlansWithFeatures();
    }
}