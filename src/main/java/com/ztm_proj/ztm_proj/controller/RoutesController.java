package com.ztm_proj.ztm_proj.controller;


import com.ztm_proj.ztm_proj.entity.Routes;
import com.ztm_proj.ztm_proj.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ ")
public class RoutesController {
    @Autowired
    RouteService routeService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Routes> getAllRoute() {
        return this.routeService.getAllRoutes();
    }


    @RequestMapping(value = "/adduser", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Routes addRoute(@RequestBody Routes routes) {
        return this.routeService.addTrip(routes);
    }


    @RequestMapping(value = "/updateuser", method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Routes updateRoute(@RequestBody Routes routes) {
        return this.routeService.updateRoute(routes);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Routes> getTrip(@PathVariable int id) {
        return this.routeService.getRouteById(id);
    }

    @RequestMapping(value = "/all", method = RequestMethod.DELETE)
    public void deleteAllRoutes() {
        this.routeService.deleteAllRoutes();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteRoute(@PathVariable int id) {
        this.routeService.deleteTripsById(id);
    }

}
