package com.fashion.gtest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fashion.gtest.entity.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer>,IReviewCustomRepository{

	

}
