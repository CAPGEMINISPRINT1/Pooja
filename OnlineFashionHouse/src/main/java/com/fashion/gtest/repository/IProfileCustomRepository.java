package com.fashion.gtest.repository;

import org.springframework.stereotype.Repository;

import com.fashion.gtest.entity.Profile;


@Repository
public interface IProfileCustomRepository {

	public Profile getAllProfilesByPhoneNumber(long phoneNumber)throws Exception;
	
}
