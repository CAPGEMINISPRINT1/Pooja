package com.fashion.gtest.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fashion.gtest.entity.Review;
import com.fashion.gtest.repository.ReviewRepository;
@Service
public class ReviewServiceImpl implements ReviewService {

	
@Autowired
ReviewRepository reviewRepository;

@Override
@Transactional
public List<Review> getAllReviews() {
	// TODO Auto-generated method stub
	return reviewRepository.findAll();
}



@Override
public Review addReview(Review user) {
	// TODO Auto-generated method stub
	return  reviewRepository.save(user);
}

@Override
public Review updateReview(Review user) {
	// TODO Auto-generated method stub
	Review update = reviewRepository.save(user);
	return update;
}

@Override
public List<Review> getReviewsConnections(String userName) throws Exception {
	// TODO Auto-generated method stub
	return null;
}

@Override
public void deleteReviewByUserId(int userId) {
	// TODO Auto-generated method stub
	reviewRepository.deleteById(userId);
}


}
