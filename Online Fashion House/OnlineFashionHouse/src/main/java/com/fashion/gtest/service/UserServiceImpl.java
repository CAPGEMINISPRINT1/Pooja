package com.fashion.gtest.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fashion.gtest.entity.AppUser;
import com.fashion.gtest.entity.Profile;
import com.fashion.gtest.entity.Review;
import com.fashion.gtest.repository.UserRepository;

@Service
public class UserServiceImpl implements AppUserService{

	@Autowired
	UserRepository userRepository;

	@Override
	@Transactional
	
	public List<AppUser> getAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	

	@Override
	public AppUser addUser(AppUser user) {
		// TODO Auto-generated method stub
		return userRepository.save(user);
	}

	@Override
	public AppUser updateUser(AppUser user) {
		// TODO Auto-generated method stub
		AppUser update = userRepository.save(user);
		return update;
	}

	

	

	@Override
	@Transactional
	public AppUser linkProfile(Profile profile, AppUser appUser) {
		// TODO Auto-generated method stub
		appUser.setUserProfile(profile);
		return appUser;
	}
	
	@Override
	public List<AppUser> getUsersConnections(String username) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public AppUser getAllUsersByUserName(String userName) throws Exception {
		// TODO Auto-generated method stub
		
		 System.out.println("------>>Inside service Impl userName"+userName);
		return userRepository.getAllUsersByUserName(userName) ;
	}
	@Override
	public AppUser getAllUserByUserId(int userId)throws Exception {
		// TODO Auto-generated method stub
		System.out.println("------>>Inside service Impl id"+userId);
		return userRepository.getAllUserByUserId(userId);
	}
	
	@Override
	public void deleteUserById(int userId){
		// TODO Auto-generated method stub
		userRepository.deleteById( userId);
	}



	
	
	
	
	
	
}
