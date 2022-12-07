package com.ztm_proj.ztm_proj.controller;

import com.ztm_proj.ztm_proj.entity.Trips;
import com.ztm_proj.ztm_proj.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/trips")
public class TripsController {
    @Autowired
    TripService tripService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Trips> getAllUsers() {
        return this.tripService.getAllTrips();
    }


    @RequestMapping(value = "/adduser", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Trips addTrip(@RequestBody Trips trip) {
        return this.tripService.addTrip(trip);
    }


    @RequestMapping(value = "/updateuser", method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Trips updateTrip(@RequestBody Trips trip) {
        return this.tripService.updateTrip(trip);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Trips> getTrip(@PathVariable int id) {
        return this.tripService.getUserById(id);
    }

    @RequestMapping(value = "/all", method = RequestMethod.DELETE)
    public void deleteAllTrips() {
        this.tripService.deleteAllTrips();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteTrip(@PathVariable int id) {
        this.tripService.deleteTripsById(id);
    }

    @Autowired
    MessageSource messageSource;

    @RequestMapping(value = "/get-greeting", method = RequestMethod.GET)
    public String greeting() {
        /**
         *   @LocaleContextHolder.getLocale()
         *  Return the Locale associated with the given user context,if any, or the system default Locale otherwise.
         *  This is effectively a replacement for Locale.getDefault(), able to optionally respect a user-level Locale setting.
         */

        return messageSource.getMessage("good.morning", null, LocaleContextHolder.getLocale());
    }


    @RequestMapping(value = "/get-greeting-name", method = RequestMethod.GET)
    public String greetingWithName() {
        String[] params = new String[]{"Ikhiloya", "today"};
        return messageSource.getMessage("good.morning.name", params, LocaleContextHolder.getLocale());
    }


}