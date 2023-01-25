package com.ztm_proj.ztm_proj.dao;

import com.ztm_proj.ztm_proj.dto.StopAndStopTimes;
import com.ztm_proj.ztm_proj.entity.Routes;
import com.ztm_proj.ztm_proj.entity.Stops;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StopsDao extends JpaRepository<Stops, Integer>  {

}
