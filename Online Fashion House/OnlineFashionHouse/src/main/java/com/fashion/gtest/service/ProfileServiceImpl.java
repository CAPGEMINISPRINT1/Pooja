package com.fashion.gtest.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fashion.gtest.entity.AppUser;
import com.fashion.gtest.entity.Profile;
import com.fashion.gtest.repository.ProfileRepository;

@Service
public class ProfileServiceImpl implements ProfileService {

	@Autowired
	ProfileRepository profileRepository;

	@Override
	@Transactional
	public Profile addProfile(Profile profile) {
		// TODO Auto-generated method stub
		Profile savedProfile = profileRepository.save(profile);
		return savedProfile;
	}

	@Override
	public List<Profile> getAllProfiles() {
		// TODO Auto-generated method stub
		return profileRepository.findAll();
	}

	@Override
	public void deleteProfileById(int ProfileId) {
		// TODO Auto-generated method stub
		profileRepository.deleteById(ProfileId);
	}

	@Override
	public Profile updateProfile(Profile profile) {
		// TODO Auto-generated method stub
		Profile update = profileRepository.save(profile);
		return update;
	}

	@Override
	public List<Profile> getProfilesConnections(int profileId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}
