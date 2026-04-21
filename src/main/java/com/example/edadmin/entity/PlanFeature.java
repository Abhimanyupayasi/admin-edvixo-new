package com.example.edadmin.entity;

import java.util.UUID;

import jakarta.persistence.*;

@Entity
@Table(name = "plan_feature")
public class PlanFeature {

    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "plan_id", nullable = false)
    private Plan plan;

    @ManyToOne
    @JoinColumn(name = "feature_id", nullable = false)
    private Feature feature;
    

    @Column(length = 50)
    private String value;

    // getters & setters
    public UUID getId() {
    return id;
}

public void setId(UUID id) {
    this.id = id;
}

public Plan getPlan() {
    return plan;
}

public void setPlan(Plan plan) {
    this.plan = plan;
}

public Feature getFeature() {
    return feature;
}

public void setFeature(Feature feature) {
    this.feature = feature;
}

public String getValue() {
    return value;
}

public void setValue(String value) {
    this.value = value;
}

}