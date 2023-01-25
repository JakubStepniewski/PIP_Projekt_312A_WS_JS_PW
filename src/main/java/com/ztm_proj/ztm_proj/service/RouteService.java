package com.ztm_proj.ztm_proj.service;
import com.ztm_proj.ztm_proj.repository.RoutesRepository;
import com.ztm_proj.ztm_proj.entity.Routes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RouteService {
    @Autowired
    RoutesRepository routesDao;

    public List<Routes> getAllRoutes() {
        return this.routesDao.findAll();
    }

    public Routes addTrip(Routes route) {
        return this.routesDao.save(route);
    }

    public Optional<Routes> getRouteById(int id) {
        return this.routesDao.findById(id);
    }

    public Routes updateRoute(Routes trip) {
        return this.routesDao.save(trip);
    }

    public void deleteTripsById(int id) {
        this.routesDao.deleteById(id);
    }

    public void deleteAllRoutes() {
        this.routesDao.deleteAll();
    }
}
