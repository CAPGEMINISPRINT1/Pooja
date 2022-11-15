package com.fashion.gtest.util;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.fashion.gtest.entity.AppUser;
import com.fashion.gtest.mydto.UserDefaultResponseDTO;

@Component
@Scope("singleton")
public class UserDTOConverter {

	public static UserDefaultResponseDTO  getUserDefaultDTO(AppUser user)
	{
		UserDefaultResponseDTO dto = new UserDefaultResponseDTO(
				                 user.getUserName(), 
				                 user.getUserId(), 
				                
				                 "User Profile Created , Profile Id : "+user.getUserProfile().getProfileId());
		
		return dto;
	}

	
}
