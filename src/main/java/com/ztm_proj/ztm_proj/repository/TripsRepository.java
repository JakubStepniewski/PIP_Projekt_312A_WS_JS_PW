package com.ztm_proj.ztm_proj.repository;

import com.ztm_proj.ztm_proj.entity.Trips;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("TripsRepository")
public interface TripsRepository extends JpaRepository<Trips, Integer>{
}