package com.example.edadmin.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.*;

@Entity
@Table(name = "plans")
public class Plan {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(name = "is_free")
    private boolean isFree;

    @Column(name = "duration_value")
    private Integer durationValue;

    @Column(name = "duration_unit", length = 10)
    private String durationUnit;

    @Column(name = "is_active")
    private boolean isActive = true;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    public void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    // getters & setters
    // getters & setters

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

public String getDescription() {
    return description;
}

public void setDescription(String description) {
    this.description = description;
}

public BigDecimal getPrice() {
    return price;
}

public void setPrice(BigDecimal price) {
    this.price = price;
}

public boolean isFree() {
    return isFree;
}

public void setFree(boolean isFree) {
    this.isFree = isFree;
}

public Integer getDurationValue() {
    return durationValue;
}

public void setDurationValue(Integer durationValue) {
    this.durationValue = durationValue;
}

public String getDurationUnit() {
    return durationUnit;
}

public void setDurationUnit(String durationUnit) {
    this.durationUnit = durationUnit;
}

public boolean isActive() {
    return isActive;
}

public void setActive(boolean isActive) {
    this.isActive = isActive;
}
}