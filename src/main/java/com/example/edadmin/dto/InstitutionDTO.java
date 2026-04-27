package com.example.edadmin.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public class InstitutionDTO {

    private UUID id;
    private String name;
    private String email;
    private String phone;
    private String status;
    private LocalDateTime trialEndsAt;
    private LocalDateTime createdAt;

    // getters & setters
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDateTime getTrialEndsAt() { return trialEndsAt; }
    public void setTrialEndsAt(LocalDateTime trialEndsAt) { this.trialEndsAt = trialEndsAt; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}