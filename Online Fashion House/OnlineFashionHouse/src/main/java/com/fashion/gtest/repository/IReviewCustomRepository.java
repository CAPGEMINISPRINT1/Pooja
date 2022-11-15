package com.fashion.gtest.repository;

import org.springframework.stereotype.Repository;


import com.fashion.gtest.entity.Review;

@Repository
public interface IReviewCustomRepository {

	public Review getAllReviewsByUserName(String userName)throws Exception;
	public  Review deleteReviewByUserId(int userId)throws Exception;
}
