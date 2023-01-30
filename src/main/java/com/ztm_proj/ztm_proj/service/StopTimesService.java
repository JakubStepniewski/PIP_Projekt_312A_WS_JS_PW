package com.ztm_proj.ztm_proj.service;


import com.ztm_proj.ztm_proj.entity.StopTimes;
import com.ztm_proj.ztm_proj.repository.StopTimesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StopTimesService {
    @Autowired
    StopTimesRepository stopTimesRepository;

    public List<StopTimes> getAllStopTimes() {
        return this.stopTimesRepository.findAll();
    }

    public List<StopTimes> getByStopId(int stopId) {
        return this.stopTimesRepository.findAllByStopId(stopId);
    }

    public List<StopTimes> getStopTimesByStopSequence(int StopSequence) {
        return this.stopTimesRepository.findByStopSequence(StopSequence);
    }

    public Optional<StopTimes> getStopTimesByTripId(String id) {
        return this.stopTimesRepository.findByTripId(id);
    }

    public StopTimes addStopsTime(StopTimes stopTimes) {
        return this.stopTimesRepository.save(stopTimes);
    }

    public Optional<StopTimes> getStopTimesById(int id) {
        return this.stopTimesRepository.findById(id);
    }

    public StopTimes updateStopTimes(StopTimes stopTimes) {
        return this.stopTimesRepository.save(stopTimes);
    }

    public void deleteStopTimesById(int id) {
        this.stopTimesRepository.deleteById(id);
    }

    public void deleteAllStopTimes() {
        this.stopTimesRepository.deleteAll();
    }
}
