package com.ztm_proj.ztm_proj.dao;

import com.ztm_proj.ztm_proj.entity.Trips;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripDao extends JpaRepository<Trips, Integer> {
}
