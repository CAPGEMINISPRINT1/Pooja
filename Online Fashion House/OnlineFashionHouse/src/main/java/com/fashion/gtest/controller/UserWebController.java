package com.fashion.gtest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fashion.gtest.entity.AppUser;

import com.fashion.gtest.service.AppUserService;
@Controller
@RequestMapping("/mynthra")


public class UserWebController {

@Autowired
AppUserService userService;



public UserWebController() {
	
	System.out.println("/n/n/n=====>>Inside Constructor" +this);
}

@PostMapping("/add")

public ResponseEntity<String> addUser(@RequestBody AppUser user) 
{
	
	try {
		AppUser savedUser =  userService.addUser(user);
		String responseMsg = savedUser.getUserName()+" save with Id "+savedUser.getUserId();
		return new ResponseEntity<String>(responseMsg,HttpStatus.OK);
	} catch (Exception e) {
		String errorMsg =  "Contact to customer care 1800-250-960 or mail us :- care@capg.com";
		return new ResponseEntity<String>(errorMsg,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}

@PutMapping("/update")
public ResponseEntity<AppUser> updateUser(@RequestBody AppUser user) throws Exception
{
	AppUser savedUser =  userService.addUser(user);
	return new ResponseEntity<AppUser>(savedUser,HttpStatus.CREATED);
	
}
@DeleteMapping("/userId/{searchUserid}")
public void deleteUserById(@PathVariable int searchUserid) 
{
	try {
		userService.deleteUserById(searchUserid);
		
	  }catch(Exception e){
		  e.printStackTrace();
	  }

}




@GetMapping("/userName/{searchUsername}")
public AppUser getAllUsersByUserName(@PathVariable String searchUsername)throws Exception
{
	return userService.getAllUsersByUserName(searchUsername);
}

@GetMapping("/userId/{searchUserid}")
public AppUser getUserById(@PathVariable int searchUserid)throws Exception
{
	
	return userService.getAllUserByUserId(searchUserid);
	
}


@GetMapping("/allusers")
public List<AppUser> getAllUsers()
{
	
	try {
		List<AppUser>  allExtractedUsers = userService.getAllUsers();
		
		return allExtractedUsers;
		
	} catch (Exception e) {
		
		System.out.println(e);
		
	}
	
	return null;
}




}


