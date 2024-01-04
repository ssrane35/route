package com.route.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.route.entities.Route;
import com.route.repository.RouteRepository;

@Service
public class RouteService {
	private final RouteRepository routeRepository;

    @Autowired
    public RouteService(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    public List<Route> getAllRoutes() {
        return routeRepository.findAll();
    }
    public Route getRouteById(int id) {
        Optional<Route> route = routeRepository.findById(id);
        return route.orElse(null);
    }

    public Route createRoute(Route route) {
        // Add any validation or business logic before saving the route
        return routeRepository.save(route);
    }

    public Route updateRoute(int id, Route updatedRoute) {
        Optional<Route> existingRoute = routeRepository.findById(id);
        if (existingRoute.isPresent()) {
            updatedRoute.setRouteId(id);
            return routeRepository.save(updatedRoute);
        }
        return null; // Route not found
    }

    public void deleteRoute(int id) {
        routeRepository.deleteById(id);
    }


}
