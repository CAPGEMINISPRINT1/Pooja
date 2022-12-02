package com.fashion.gtest.repository;


import org.springframework.stereotype.Repository;

import com.fashion.gtest.entity.AppUser;
import com.fashion.gtest.entity.Profile;

@Repository
public interface IUserCustomRepository {

public AppUser getAllUsersByUserName(String userName)throws Exception;
	
	
	public AppUser getAllUserByUserId(int userId)throws Exception;
	
			
}
