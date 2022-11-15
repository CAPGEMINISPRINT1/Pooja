package com.fashion.gtest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fashion.gtest.entity.Profile;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Integer> {

	
}
