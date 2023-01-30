package com.ztm_proj.ztm_proj.service;

import com.ztm_proj.ztm_proj.entity.Drivers;
import com.ztm_proj.ztm_proj.repository.DriversRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriversService {
    @Autowired
    DriversRepository driversRepository;

    public List<Drivers> getAllDrivers() {
        return this.driversRepository.findAll();
    }

    public Drivers addDrivers(Drivers drivers) {
        return this.driversRepository.save(drivers);
    }

    public Optional<Drivers> getDriversById(int id) {
        return this.driversRepository.findById(id);
    }

    public Drivers updateDrivers(Drivers drivers) {
        return this.driversRepository.save(drivers);
    }

    public void deleteDriversById(int id) {
        this.driversRepository.deleteById(id);
    }

    public void deleteAllDrivers() {
        this.driversRepository.deleteAll();
    }

    public Drivers save(Drivers drivers) {
        return this.driversRepository.save(drivers);
    }
}
