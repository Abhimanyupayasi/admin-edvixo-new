package com.example.edadmin.service;

import com.example.edadmin.dto.InstitutionDTO;
import com.example.edadmin.entity.Institution;
import com.example.edadmin.repository.InstitutionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public interface InstitutionService {

    InstitutionDTO create(InstitutionDTO dto);
    List<InstitutionDTO> getAll();
    InstitutionDTO getById(UUID id);
    InstitutionDTO update(UUID id, InstitutionDTO dto);
    void delete(UUID id);

    // 🔥 Implementation inside same file
    @Service
    class Impl implements InstitutionService {

        private final InstitutionRepository repo;

        public Impl(InstitutionRepository repo) {
            this.repo = repo;
        }

        // ✅ Entity → DTO
        private InstitutionDTO mapToDTO(Institution entity) {
            InstitutionDTO dto = new InstitutionDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setEmail(entity.getEmail());
            dto.setPhone(entity.getPhone());
            dto.setStatus(entity.getStatus());
            dto.setTrialEndsAt(entity.getTrialEndsAt());
            dto.setCreatedAt(entity.getCreatedAt()); // 🔥 important
            return dto;
        }

        // ✅ DTO → Entity
        private Institution mapToEntity(InstitutionDTO dto) {
            Institution entity = new Institution();
            entity.setName(dto.getName());
            entity.setEmail(dto.getEmail());
            entity.setPhone(dto.getPhone());
            entity.setStatus(dto.getStatus());
            entity.setTrialEndsAt(dto.getTrialEndsAt());
            return entity;
        }

        @Override
        public InstitutionDTO create(InstitutionDTO dto) {
            return mapToDTO(repo.save(mapToEntity(dto)));
        }

        @Override
        public List<InstitutionDTO> getAll() {
            return repo.findAll()
                    .stream()
                    .map(this::mapToDTO)
                    .collect(Collectors.toList());
        }

        @Override
        public InstitutionDTO getById(UUID id) {
            return mapToDTO(repo.findById(id)
                    .orElseThrow(() -> new RuntimeException("Institution not found")));
        }

        @Override
        public InstitutionDTO update(UUID id, InstitutionDTO dto) {
            Institution existing = repo.findById(id)
                    .orElseThrow(() -> new RuntimeException("Institution not found"));

            existing.setName(dto.getName());
            existing.setEmail(dto.getEmail());
            existing.setPhone(dto.getPhone());
            existing.setStatus(dto.getStatus());
            existing.setTrialEndsAt(dto.getTrialEndsAt());

            return mapToDTO(repo.save(existing));
        }

        @Override
        public void delete(UUID id) {
            repo.deleteById(id);
        }
    }
}