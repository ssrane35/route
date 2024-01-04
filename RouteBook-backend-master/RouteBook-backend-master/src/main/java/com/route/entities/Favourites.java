package com.route.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Favourites {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int favid;
	@ManyToOne // Assuming many favorites can belong to one user
	private User user;

	@ManyToOne // Assuming many favorites can be associated with one route
	private Route route;

	public Favourites() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getFavid() {
		return favid;
	}

	public void setFavid(int favid) {
		this.favid = favid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	public Favourites(int favid, User user, Route route) {
		super();
		this.favid = favid;
		this.user = user;
		this.route = route;
	}

	@Override
	public String toString() {
		return "Favourites [favid=" + favid + ", user=" + user + ", route=" + route + "]";
	}
      
	

}
