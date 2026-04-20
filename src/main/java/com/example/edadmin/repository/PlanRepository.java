package com.example.edadmin.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.edadmin.entity.Plan;

public interface PlanRepository extends JpaRepository<Plan, UUID> {

}