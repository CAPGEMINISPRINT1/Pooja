package com.fashion.gtest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fashion.gtest.entity.AppUser;
import com.fashion.gtest.entity.Profile;
import com.fashion.gtest.entity.Review;

@Service
public interface AppUserService {

	public List<AppUser> getAllUsers()throws Exception;
	
	public List<AppUser> getUsersConnections(String username)throws Exception;
	public void deleteUserById(int UserId);
	public AppUser addUser(AppUser user);
	public AppUser updateUser(AppUser user);
	
	
	
	public AppUser linkProfile(Profile profile,AppUser appUser);
	
	
	
	public AppUser getAllUsersByUserName(String userName)throws Exception;
	
	
	public AppUser getAllUserByUserId(int userId)throws Exception;
	
	
}
