package com.ztm_proj.ztm_proj.controller;

import com.ztm_proj.ztm_proj.entity.Drivers;
import com.ztm_proj.ztm_proj.entity.Stops;
import com.ztm_proj.ztm_proj.service.DriversService;
import com.ztm_proj.ztm_proj.service.StopsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/drivers")
public class DriversController {
    @Autowired
    DriversService driversService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Drivers> getAllDrivers() {
        return this.driversService.getAllDrivers();
    }


    @RequestMapping(value = "/adddriver", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Drivers addDrivers(@RequestBody Drivers drivers) {
        return this.driversService.addDrivers(drivers);
    }


    @RequestMapping(value = "/updatedriver", method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Drivers updateDrivers(@RequestBody Drivers driversToUpdate) {
        if(this.driversService.getDriversById(driversToUpdate.getId()).isPresent()){
            Drivers drivers = this.driversService.getDriversById(driversToUpdate.getId()).get();
            drivers.setDriverName(driversToUpdate.getDriverName());
            drivers.setLineId(driversToUpdate.getLineId());
            return this.driversService.save(drivers);
        } else {
            return null;
        }

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Drivers> getDrivers(@PathVariable int id) {
        return this.driversService.getDriversById(id);
    }



    @RequestMapping(value = "/all", method = RequestMethod.DELETE)
    public void deleteAllDrivers() {
        this.driversService.deleteAllDrivers();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteDrivers(@PathVariable int id) {
        this.driversService.deleteDriversById(id);
    }
}
