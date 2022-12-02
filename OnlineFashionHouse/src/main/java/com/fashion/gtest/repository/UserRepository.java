package com.fashion.gtest.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fashion.gtest.entity.AppUser;


@Repository
public interface UserRepository extends JpaRepository<AppUser,Integer> ,IUserCustomRepository{

	

	
	
}
