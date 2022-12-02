package com.fashion.gtest.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.fashion.gtest.entity.AppUser;
import com.fashion.gtest.repository.UserRepository;
@SpringBootTest
class UserServiceImplTest {

	@Mock
	UserRepository userRepository;
	
	@InjectMocks
	UserServiceImpl appuserService;
	
	
	
	
	@Test
	//@Disabled
	@DisplayName("Test to verify all user returend")
	void testGetAllUsers() throws Exception{
		
		// given
		
				AppUser user1 = new AppUser("A","A");
				user1.setUserProfile(null);
				
				AppUser user2 = new AppUser("B","B");
				user1.setUserProfile(null);
				
				List<AppUser> sampleOutput = new ArrayList<>();
				sampleOutput.add(user1);
				sampleOutput.add(user2);
				
				BDDMockito.given(appuserService.getAllUsers()).willReturn(sampleOutput);
				
				// ----------------------------------------------------------------------
				
				// when :- readyto test the funcationality (service)
				List<AppUser> actualOutput = appuserService.getAllUsers();
				
				
				// then : verify the sampleOutput with actual output
				// assertThat(actualOutput).isNotNull();  // or
				assertNotNull(actualOutput);
				assertThat(actualOutput.size()).isGreaterThan(0);
				assertIterableEquals(sampleOutput, actualOutput);
				
			}
		
		
	
	
	
	

	@Test
	@DisplayName("Test to verify all user returend")
	void testAddUser() throws Exception {
		// given
				AppUser sampleInput = new AppUser("A","A");
				AppUser expectedOutput = new AppUser("A","A");
				//Object obj = new Object();
				BDDMockito.given(appuserService.addUser(sampleInput)).willReturn(expectedOutput);
				
				// when 
				AppUser actualOutput = appuserService.addUser(sampleInput);
				
				// verify 
				assertEquals(expectedOutput, actualOutput);
			}
	

	@Test
	@Disabled
	void testUpdateUser() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testLinkProfile() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testGetUsersConnections() {
		fail("Not yet implemented");
	}

	@Test
	//@Disabled
	@DisplayName("get all Users by user name")
	void testGetAllUsersByUserName() throws Exception {
	AppUser sampleOutput= new AppUser ("A","A");
	//given
	sampleOutput.setUserName("A");
	String sampleInput= "A";
	BDDMockito.given(appuserService.getAllUsersByUserName(sampleInput)).willReturn(sampleOutput); 
		//when
	AppUser actualOutput=appuserService.getAllUsersByUserName(sampleInput);
	//verify
	assertEquals(sampleOutput,actualOutput);
	assertSame(sampleOutput.getUserName(),actualOutput.getUserName());
		
	}

	@Test
	//@Disabled
	@DisplayName("get all Users by user id")
	void testGetAllUserByUserId()throws Exception {
		AppUser sampleOutput= new AppUser ("A","A");
		//given
		sampleOutput.setUserId(1);
		int sampleInput=1;
		BDDMockito.given(appuserService.getAllUserByUserId(sampleInput)).willReturn(sampleOutput);
		//when
		AppUser actualOutput=appuserService.getAllUserByUserId(sampleInput);
		//verify
		assertEquals(sampleOutput,actualOutput);
		assertSame(sampleOutput.getUserId(),actualOutput.getUserId());
	}

	@Test
	@Disabled
	void testDeleteUserById() {
		fail("Not yet implemented");
	}

	
	
	
}
