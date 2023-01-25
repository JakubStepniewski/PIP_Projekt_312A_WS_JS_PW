package com.ztm_proj.ztm_proj.service;


import com.ztm_proj.ztm_proj.dao.StopsDao;
import com.ztm_proj.ztm_proj.dao.TripDao;
import com.ztm_proj.ztm_proj.entity.Stops;
import com.ztm_proj.ztm_proj.entity.Trips;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StopsService {

    @Autowired
    StopsDao stopsDao;

    public List<Stops> getAllStops() {
        return this.stopsDao.findAll();
    }



    public Stops addStops(Stops stop) {
        return this.stopsDao.save(stop);
    }

    public Optional<Stops> getStopsById(int id) {
        return this.stopsDao.findById(id);
    }

    public Stops updateStops(Stops trip) {
        return this.stopsDao.save(trip);
    }

    public void deleteStopsById(int id) {
        this.stopsDao.deleteById(id);
    }

    public void deleteAllStops() {
        this.stopsDao.deleteAll();
    }
}
