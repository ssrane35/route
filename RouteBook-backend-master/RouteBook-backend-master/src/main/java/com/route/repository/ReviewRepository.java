package com.route.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.route.entities.Review;

@Repository

public interface ReviewRepository extends JpaRepository<Review, Integer> {

}
