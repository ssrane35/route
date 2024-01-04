package com.route.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.route.entities.Favourites;
import com.route.repository.FavouritesRepository;

@Service
public class FavouritesService {
	@Autowired
	private  FavouritesRepository favoritesRepository;

    
    public FavouritesService(FavouritesRepository favoritesRepository) {
        this.favoritesRepository = favoritesRepository;
    }
    public List<Favourites> getAllFavorites() {
        return favoritesRepository.findAll();
    }

    public Favourites getFavoritesById(int id) {
        Optional<Favourites> favorites = favoritesRepository.findById(id);
        return favorites.orElse(null);
    }
    public Favourites createFavorites(Favourites favorites) {
        // Add any validation or business logic before saving the favorites
        return favoritesRepository.save(favorites);
    }

    public Favourites updateFavorites(int id, Favourites updatedFavorites) {
        Optional<Favourites> existingFavorites = favoritesRepository.findById(id);
        if (existingFavorites.isPresent()) {
            updatedFavorites.setFavid(id);
            return favoritesRepository.save(updatedFavorites);
        }
        return null; // Favorites not found
    }

    public void deleteFavorites(int id) {
        favoritesRepository.deleteById(id);
    }
	
	public FavouritesRepository getFavoritesRepository() {
		return favoritesRepository;
	}
	@Override
	public String toString() {
		return "FavouritesService [favoritesRepository=" + favoritesRepository + "]";
	}
    

	

}
