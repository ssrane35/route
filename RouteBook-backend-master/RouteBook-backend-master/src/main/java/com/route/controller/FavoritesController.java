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

import com.route.entities.Favourites;
import com.route.service.FavouritesService;

@RestController
@RequestMapping("/favorites")
public class FavoritesController {
	 private final FavouritesService favoritesService;
	 
	 @Autowired
	    public FavoritesController(FavouritesService favoritesService) {
	        this.favoritesService = favoritesService;
	    }
	 @GetMapping("/all")
	    public ResponseEntity<List<Favourites>> getAllFavorites() {
	        List<Favourites> favorites = favoritesService.getAllFavorites();
	        return new ResponseEntity<>(favorites, HttpStatus.OK);
	    }
	 @GetMapping("/getbyid/{favId}")
	    public ResponseEntity<Favourites> getFavoritesById(@PathVariable int id) {
	        Favourites favorites = favoritesService.getFavoritesById(id);
	        if (favorites != null) {
	            return new ResponseEntity<>(favorites, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	 @PostMapping("/create")
	    public ResponseEntity<Favourites> createFavorites(@RequestBody Favourites favorites) {
	        Favourites createdFavorites = favoritesService.createFavorites(favorites);
	        return new ResponseEntity<>(createdFavorites, HttpStatus.CREATED);
	    }
	 @PutMapping("/{id}")
	    public ResponseEntity<Favourites> updateFavorites(@PathVariable int id, @RequestBody Favourites favorites) {
	        Favourites updatedFavorites = favoritesService.updateFavorites(id, favorites);
	        if (updatedFavorites != null) {
	            return new ResponseEntity<>(updatedFavorites, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	 @DeleteMapping("/delete/{favId}")
	    public ResponseEntity<Void> deleteFavorites(@PathVariable int id) {
	        favoritesService.deleteFavorites(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	 

}
