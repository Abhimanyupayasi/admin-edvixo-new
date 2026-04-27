package com.example.edadmin.controller;

import com.example.edadmin.dto.InstitutionDTO;
import com.example.edadmin.service.InstitutionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/institutions")
public class InstitutionController {

    private final InstitutionService service;

    public InstitutionController(InstitutionService service) {
        this.service = service;
    }

    @PostMapping
    public InstitutionDTO create(@RequestBody InstitutionDTO dto) {
        return service.create(dto);
    }

    @GetMapping
    public List<InstitutionDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public InstitutionDTO getById(@PathVariable UUID id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public InstitutionDTO update(@PathVariable UUID id, @RequestBody InstitutionDTO dto) {
        return service.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}