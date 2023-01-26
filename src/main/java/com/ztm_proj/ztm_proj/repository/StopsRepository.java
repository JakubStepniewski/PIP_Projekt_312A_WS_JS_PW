package com.ztm_proj.ztm_proj.repository;

import com.ztm_proj.ztm_proj.entity.Stops;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StopsRepository extends JpaRepository<Stops, Integer>  {

}
