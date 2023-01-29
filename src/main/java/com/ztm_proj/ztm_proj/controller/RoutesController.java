package com.ztm_proj.ztm_proj.controller;


import com.ztm_proj.ztm_proj.entity.Drivers;
import com.ztm_proj.ztm_proj.entity.Routes;
import com.ztm_proj.ztm_proj.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/routes")
public class RoutesController {
    @Autowired
    RouteService routeService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Routes> getAllRoute() {
        return this.routeService.getAllRoutes();
    }


    @RequestMapping(value = "/addroute", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Routes addRoute(@RequestBody Routes routes) {
        return this.routeService.addTrip(routes);
    }

    @RequestMapping(value = "/updateroute", method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Routes updateRoute(@RequestBody Routes routesToUpdate) {
        Routes routes = this.routeService.getRouteById(routesToUpdate.getId()).get();
        routes.setRouteId(routesToUpdate.getRouteId());
        routes.setRouteColor(routesToUpdate.getRouteColor());
        routes.setRouteLongName(routesToUpdate.getRouteLongName());
        routes.setRouteType(routesToUpdate.getRouteType());
        routes.setRouteShortName(routesToUpdate.getRouteShortName());
        routes.setAgencyId(routesToUpdate.getAgencyId());
        routes.setRouteTextColor(routesToUpdate.getRouteTextColor());
        return this.routeService.save(routes);
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
