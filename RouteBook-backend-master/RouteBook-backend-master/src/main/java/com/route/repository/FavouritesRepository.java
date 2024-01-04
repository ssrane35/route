package com.route.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.route.entities.Favourites;

public interface FavouritesRepository extends JpaRepository<Favourites, Integer>  {

}
