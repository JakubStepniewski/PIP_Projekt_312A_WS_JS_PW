package com.ztm_proj.ztm_proj.repository;

import com.ztm_proj.ztm_proj.entity.Drivers;
import com.ztm_proj.ztm_proj.entity.Routes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriversRepository  extends JpaRepository<Drivers, Integer> {

}
