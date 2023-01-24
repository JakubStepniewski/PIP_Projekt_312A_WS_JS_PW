package com.ztm_proj.ztm_proj.repository;

import com.ztm_proj.ztm_proj.entity.StopTimes;
import com.ztm_proj.ztm_proj.entity.Trips;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StopTimesRepository extends JpaRepository<StopTimes, Integer> {

    @Query(value = "SELECT s FROM StopTimes s WHERE s.stopId=?1")
    List<StopTimes> findAllByStopId(int StopId);


    List<StopTimes> findByStopSequence(int StopSequence);
}
