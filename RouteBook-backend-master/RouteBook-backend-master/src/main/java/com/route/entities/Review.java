package com.route.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Review {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reviewid;
	 @ManyToOne // Assuming many reviews can belong to one user
	    private User user;
	 @ManyToOne // Assuming many reviews can be associated with one route
	    private Route route;

	    private int rating;
	    private String comment;
	    
	    public Review() {
	    }

		public int getReviewid() {
			return reviewid;
		}

		public void setReviewid(int reviewid) {
			this.reviewid = reviewid;
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

		public int getRating() {
			return rating;
		}

		public void setRating(int rating) {
			this.rating = rating;
		}

		public String getComment() {
			return comment;
		}

		public void setComment(String comment) {
			this.comment = comment;
		}

		public Review(int reviewid, User user, Route route, int rating, String comment) {
			super();
			this.reviewid = reviewid;
			this.user = user;
			this.route = route;
			this.rating = rating;
			this.comment = comment;
		}

		@Override
		public String toString() {
			return "Review [reviewid=" + reviewid + ", user=" + user + ", route=" + route + ", rating=" + rating
					+ ", comment=" + comment + "]";
		}
	    
	    



}
