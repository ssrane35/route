package com.route.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.route.entities.Route;

@Repository
public interface RouteRepository extends JpaRepository<Route, Integer>{

}
