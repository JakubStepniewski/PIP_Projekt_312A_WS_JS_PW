package com.ztm_proj.ztm_proj.service;

import com.ztm_proj.ztm_proj.dao.TripDao;
import com.ztm_proj.ztm_proj.entity.Trips;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TripService {
    @Autowired
    TripDao tripDao;

    public List<Trips> getAllTrips() {
        return this.tripDao.findAll();
    }

    public Trips addTrip(Trips user) {
        return this.tripDao.save(user);
    }

    public Optional<Trips> getUserById(int id) {
        return this.tripDao.findById(id);
    }

    public Trips updateTrip(Trips trip) {
        return this.tripDao.save(trip);
    }

    public void deleteTripsById(int id) {
        this.tripDao.deleteById(id);
    }

    public void deleteAllTrips() {
        this.tripDao.deleteAll();
    }
}
