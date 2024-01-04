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

import com.route.entities.Review;
import com.route.service.ReviewService;
import com.route.service.RouteService;


@RestController
@RequestMapping("/reviews")
public class ReviewController {
	 @Autowired
	 private ReviewService reviewService;

	 @PostMapping("/create")
	 public Review createReview(@RequestBody Review review) {
	     return reviewService.createReview(review);
	 }

	 @GetMapping("/getbyid/{reviewId}")
	 public Review getReviewById(@PathVariable int reviewId) {
	     return reviewService.getReviewById(reviewId);
	 }

	 @GetMapping("/all")
	 public List<Review> getAllReviews() {
	     return reviewService.getAllReviews();
	 }

	 @DeleteMapping("/delete/{reviewId}")
	 public void deleteReview(@PathVariable int reviewId) {
	     ReviewService.deleteReview(reviewId);
	 }
	
	
}
