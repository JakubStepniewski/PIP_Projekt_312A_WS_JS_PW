package com.ztm_proj.ztm_proj.controller;

import com.ztm_proj.ztm_proj.entity.Routes;
import com.ztm_proj.ztm_proj.entity.StopTimes;
import com.ztm_proj.ztm_proj.service.StopTimesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/stoptime")
public class StopTimesController {
    @Autowired
    StopTimesService stopTimesService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<StopTimes> getAllStops() {
        return this.stopTimesService.getAllStopTimes();
    }

    @RequestMapping(value = "/stopid/{stopid}", method = RequestMethod.GET)
    public List<StopTimes> getStopTimesByStopId(@PathVariable int stopid) {
        return this.stopTimesService.getStopTimesByStopSequence(stopid);
    }

    @RequestMapping(value = "/serviceid/{id}", method = RequestMethod.GET)
    public List<StopTimes> getStopTimesByTripId(@PathVariable String id) {
        return this.stopTimesService.getStopTimesByTripId(id);
    }

    @RequestMapping(value = "/addstoptime", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public StopTimes add(@RequestBody StopTimes stopTimes) {

        return this.stopTimesService.addStopsTime(stopTimes);
    }
    @RequestMapping(value = "/updatestoptime", method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public StopTimes updateRoute(@RequestBody StopTimes stopTimesToUpdate) {
        StopTimes stoptime = this.stopTimesService.getStopTimesById(stopTimesToUpdate.getId()).get();
        stoptime.setArrivalTime(stopTimesToUpdate.getArrivalTime());
        stoptime.setStopId(stopTimesToUpdate.getStopId());
        return this.stopTimesService.addStopsTime(stoptime);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<StopTimes> getStop(@PathVariable int id) {
        return this.stopTimesService.getStopTimesById(id);
    }


    @RequestMapping(value = "/all", method = RequestMethod.DELETE)
    public void deleteAllTrips() {
        this.stopTimesService.deleteAllStopTimes();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteTrip(@PathVariable int id) {
        this.stopTimesService.deleteStopTimesById(id);
    }
}
