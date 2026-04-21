package com.example.edadmin.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.*;

import com.example.edadmin.entity.PlanFeature;
import com.example.edadmin.service.PlanFeatureService;

@RestController
@RequestMapping("/plan-features")
public class PlanFeatureController {

    private final PlanFeatureService service;

    public PlanFeatureController(PlanFeatureService service) {
        this.service = service;
    }

    @PostMapping
    public PlanFeature attach(@RequestParam UUID planId,
                              @RequestParam UUID featureId,
                              @RequestParam String value) {

        return service.attach(planId, featureId, value);
    }
}