package com.example.edadmin.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.edadmin.entity.Feature;
import com.example.edadmin.service.FeatureService;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/features")
public class FeatureController {

    private final FeatureService service;

    public FeatureController(FeatureService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    public Feature create(@RequestBody Feature feature) {
        return service.createFeature(feature);
    }

    // GET ALL
    @GetMapping
    public List<Feature> getAll() {
        return service.getAllFeatures();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public Feature getById(@PathVariable UUID id) {
        return service.getFeatureById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Feature update(@PathVariable UUID id, @RequestBody Feature feature) {
        return service.updateFeature(id, feature);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String delete(@PathVariable UUID id) {
        service.deleteFeature(id);
        return "Feature deleted successfully";
    }
}