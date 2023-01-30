package com.ztm_proj.ztm_proj.service;

import com.ztm_proj.ztm_proj.repository.TripsRepository;
import com.ztm_proj.ztm_proj.entity.Trips;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TripService {
    @Autowired
    TripsRepository tripsRepository;

    public List<Trips> getAllTrips() {
        return this.tripsRepository.findAll();
    }

    public List<Trips> getTripsByRouteId(String routeId) {
        return this.tripsRepository.findByRouteId(routeId);
    }

    public Trips addTrip(Trips user) {
        return this.tripsRepository.save(user);
    }

    public Optional<Trips> getUserById(int id) {
        return this.tripsRepository.findById(id);
    }

    public Trips updateTrip(Trips trip) {
        return this.tripsRepository.save(trip);
    }

    public void deleteTripsById(int id) {
        this.tripsRepository.deleteById(id);
    }

    public void deleteAllTrips() {
        this.tripsRepository.deleteAll();
    }
}
