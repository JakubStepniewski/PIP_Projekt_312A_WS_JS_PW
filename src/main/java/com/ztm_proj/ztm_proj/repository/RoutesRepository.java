package com.ztm_proj.ztm_proj.repository;

import com.ztm_proj.ztm_proj.entity.Routes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoutesRepository extends JpaRepository<Routes, Integer> {
    List<Routes> findByRouteId(String routeId);
}
