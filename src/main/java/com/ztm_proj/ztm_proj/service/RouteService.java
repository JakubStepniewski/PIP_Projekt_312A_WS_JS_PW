package com.ztm_proj.ztm_proj.service;
import com.ztm_proj.ztm_proj.entity.Drivers;
import com.ztm_proj.ztm_proj.repository.RoutesRepository;
import com.ztm_proj.ztm_proj.entity.Routes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RouteService {
    @Autowired
    RoutesRepository routesRepository;

    public List<Routes> getAllRoutes() {
        return this.routesRepository.findAll();
    }

    public Routes addTrip(Routes route) {
        return this.routesRepository.save(route);
    }

    public Optional<Routes> getRouteById(int id) {
        return this.routesRepository.findById(id);
    }

    public Routes updateRoute(Routes trip) {
        return this.routesRepository.save(trip);
    }

    public void deleteTripsById(int id) {
        this.routesRepository.deleteById(id);
    }

    public void deleteAllRoutes() {
        this.routesRepository.deleteAll();
    }

    public Routes save(Routes routes) {
        return this.routesRepository.save(routes);
    }
}
