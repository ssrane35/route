package com.route.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.route.entities.Route;
import com.route.service.RouteService;

@RestController
@RequestMapping("/routes")
public class RouteController {
	 private final RouteService routeService;

	    @Autowired
	    public RouteController(RouteService routeService) {
	        this.routeService = routeService;
	    }

	    @GetMapping("/all routes")
	    public ResponseEntity<List<Route>> getAllRoutes() {
	        List<Route> routes = routeService.getAllRoutes();
	        return new ResponseEntity<>(routes, HttpStatus.OK);
	    }
	    @GetMapping("routesbyid/{id}")
	    public ResponseEntity<Route> getRouteById(@PathVariable int id) {
	        Route route = routeService.getRouteById(id);
	        if (route != null) {
	            return new ResponseEntity<>(route, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	    @PostMapping("/createroute")
	    public ResponseEntity<Route> createRoute(@RequestBody Route route) {
	        Route createdRoute = routeService.createRoute(route);
	        return new ResponseEntity<>(createdRoute, HttpStatus.CREATED);
	    }

	    @PutMapping("updateroute/{id}")
	    public ResponseEntity<Route> updateRoute(@PathVariable int id, @RequestBody Route route) {
	        Route updatedRoute = routeService.updateRoute(id, route);
	        if (updatedRoute != null) {
	            return new ResponseEntity<>(updatedRoute, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	    @DeleteMapping("deleteroute/{id}")
	    public ResponseEntity<Void> deleteRoute(@PathVariable int id) {
	        routeService.deleteRoute(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	    


}
