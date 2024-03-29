package com.ztm_proj.ztm_proj.controller;


import com.ztm_proj.ztm_proj.entity.Drivers;
import com.ztm_proj.ztm_proj.entity.Stops;
import com.ztm_proj.ztm_proj.service.StopsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/stops")
public class StopsController {
    @Autowired
    StopsService stopsService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Stops> getAllStops() {
        return this.stopsService.getAllStops();
    }


    @RequestMapping(value = "/addstop", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Stops addTrip(@RequestBody Stops stop) {
        return this.stopsService.addStops(stop);
    }


    @RequestMapping(value = "/updatestop", method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Stops updateTrip(@RequestBody Stops stopToUpdate) {
        if(this.stopsService.getStopsById(stopToUpdate.getId()).isPresent()){
            Stops stop = this.stopsService.getStopsById(stopToUpdate.getId()).get();
            stop.setStopCode(stopToUpdate.getStopCode());
            stop.setStopLat(stopToUpdate.getStopLat());
            stop.setStopLon(stopToUpdate.getStopLon());
            stop.setStopName(stopToUpdate.getStopName());
            stop.setZoneId(stopToUpdate.getZoneId());
            return this.stopsService.updateStops(stop);
        } else {
            return null;
        }

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Stops> getStop(@PathVariable int id) {
        return this.stopsService.getStopsById(id);
    }



    @RequestMapping(value = "/all", method = RequestMethod.DELETE)
    public void deleteAllTrips() {
        this.stopsService.deleteAllStops();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteTrip(@PathVariable int id) {
        this.stopsService.deleteStopsById(id);
    }

}
