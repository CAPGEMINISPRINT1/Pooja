package com.fashion.gtest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fashion.gtest.entity.Review;

@Service
public interface ReviewService {

public List<Review>	getAllReviews();

public void deleteReviewByUserId(int userId);
public Review addReview(Review user);
public Review updateReview(Review user);

public List<Review> getReviewsConnections(String userName)throws Exception;




}
