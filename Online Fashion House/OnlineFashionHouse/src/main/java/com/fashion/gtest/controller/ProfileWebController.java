package com.fashion.gtest.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fashion.gtest.entity.AppUser;
import com.fashion.gtest.entity.Profile;
import com.fashion.gtest.mydto.ErrorDTO;
import com.fashion.gtest.mydto.MyDTO;
import com.fashion.gtest.mydto.UserDefaultResponseDTO;
import com.fashion.gtest.service.AppUserService;
import com.fashion.gtest.service.ProfileService;
import com.fashion.gtest.util.UserDTOConverter;

@RestController
@RequestMapping("/profile")

public class ProfileWebController {

	@Autowired
	ProfileService profileService;
	
	@Autowired
	AppUserService userservice;
	
	@Autowired
	UserDTOConverter dtoConvertor;
	
	private final Logger mylogs = LoggerFactory.getLogger(this.getClass());
	
	
	/**@PostMapping("/add/{userName}")  // ....../fbusers/profile/add?username=mike
	public ResponseEntity<MyDTO> doProfileThings(@RequestBody  Profile profile,@RequestParam String userName)
	{
		AppUser alreadySavedUser = null;
		try
		{
			System.out.println(" --- > "+mylogs);
			mylogs.info("---->>>Inside try of doprofile things");
			Profile savedProfile = profileService.addProfile(profile);
			if(savedProfile.getProfileId() != 0)
			{
				
				if(alreadySavedUser != null);
		
			}
		}
		catch (Exception e) {
			System.out.println(e);
			ErrorDTO errorDTo = new ErrorDTO(e.getMessage());
			return new ResponseEntity<>(errorDTo, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return null;
		
		// code to add the profile
	} */
	
	
	@PostMapping("/add")  // ....../fbusers/profile/add?username=mike
	public ResponseEntity<MyDTO> doProfileThings(@RequestBody Profile profile,@RequestParam String username)
	{
		AppUser alreadySavedProfile = null;
		try
		{
			Profile savedProfile = profileService.addProfile(profile);
			if(savedProfile.getProfileId() != 0)
			{
				alreadySavedProfile = userservice.getAllUsersByUserName(username);
				if(alreadySavedProfile != null)
				{
					AppUser profileAddProfile = userservice.linkProfile(savedProfile, alreadySavedProfile);
					
					UserDefaultResponseDTO dtoResponse = dtoConvertor.getUserDefaultDTO(profileAddProfile);
					
					return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
				}
				else
				{
					throw new Exception("User not found ,  "+alreadySavedProfile+" for "+username);
				}
				
			}
		}
		catch (Exception e) {
			System.out.println(e);
			ErrorDTO errorDTo = new ErrorDTO(e.getMessage());
			return new ResponseEntity<>(errorDTo, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return null;
		
		// code to add the profile
	}
	
	@PutMapping("/update")
	public ResponseEntity<Profile> updateProfile(@RequestBody Profile profile) throws Exception
	{
		Profile savedProfile =  profileService.addProfile(profile);
		return new ResponseEntity<Profile>(savedProfile,HttpStatus.CREATED);
		
	}
	@DeleteMapping("/profileId/{searchProfileid}")
	public void deleteProfileById(@PathVariable int searchProfileid) 
	{
		try {
			profileService.deleteProfileById(searchProfileid);
			
		  }catch(Exception e){
			  e.printStackTrace();
		  }

	}
	@GetMapping("/allprofiles")
	public List<Profile> getAllProfile()
	{
		
		try {
			List<Profile>  allExtractedProfiles = profileService.getAllProfiles();
			
			return allExtractedProfiles;
			
		} catch (Exception e) {
			
			System.out.println(e);
			
		}
		
		return null;
	}

	
}