package com.example.edadmin.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.edadmin.entity.Feature;
import com.example.edadmin.service.FeatureService;

@RestController
@RequestMapping("/features")
public class FeatureController {

    private final FeatureService service;

    public FeatureController(FeatureService service) {
        this.service = service;
    }

    @PostMapping
    public Feature create(@RequestBody Feature feature) {
        return service.createFeature(feature);
    }
}
