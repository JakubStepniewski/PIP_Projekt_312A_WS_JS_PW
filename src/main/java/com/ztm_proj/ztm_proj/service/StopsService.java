package com.ztm_proj.ztm_proj.service;


import com.ztm_proj.ztm_proj.repository.StopsRepository;
import com.ztm_proj.ztm_proj.entity.Stops;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StopsService {

    @Autowired
    StopsRepository stopsRepository;

    public List<Stops> getAllStops() {
        return this.stopsRepository.findAll();
    }



    public Stops addStops(Stops stop) {
        return this.stopsRepository.save(stop);
    }

    public Optional<Stops> getStopsById(int id) {
        return this.stopsRepository.findById(id);
    }

    public Stops updateStops(Stops stop) {
        return this.stopsRepository.save(stop);
    }

    public void deleteStopsById(int id) {
        this.stopsRepository.deleteById(id);
    }

    public void deleteAllStops() {
        this.stopsRepository.deleteAll();
    }

}
