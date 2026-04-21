package com.example.edadmin.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.edadmin.entity.PlanFeature;

public interface PlanFeatureRepository extends JpaRepository<PlanFeature, UUID> {

    @Query("SELECT pf FROM PlanFeature pf WHERE pf.plan.id = :planId")
    List<PlanFeature> findByPlanId(@Param("planId") UUID planId);

    @Query("SELECT pf FROM PlanFeature pf WHERE pf.feature.id = :featureId")
    List<PlanFeature> findByFeatureId(@Param("featureId") UUID featureId);

}