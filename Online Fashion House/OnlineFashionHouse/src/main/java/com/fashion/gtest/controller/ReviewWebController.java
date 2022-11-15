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
import org.springframework.web.bind.annotation.RequestParam;

import com.fashion.gtest.entity.AppUser;
import com.fashion.gtest.entity.Profile;
import com.fashion.gtest.entity.Review;
import com.fashion.gtest.mydto.ErrorDTO;
import com.fashion.gtest.mydto.MyDTO;
import com.fashion.gtest.mydto.UserDefaultResponseDTO;
import com.fashion.gtest.service.AppUserService;
import com.fashion.gtest.service.ReviewService;
import com.fashion.gtest.util.UserDTOConverter;

@Controller
@RequestMapping("/review")
public class ReviewWebController {

@Autowired
ReviewService reviewService;

@Autowired
AppUserService userService;

@Autowired
UserDTOConverter dtoConvertor;
	
public ReviewWebController() {
	
	System.out.println("/n/n/n=====>>Inside Constructor" +this);
}


@PostMapping("/add")
public ResponseEntity<String> addReview(@RequestBody Review review)
{
	try {
		Review savedReview = reviewService.addReview(review);
		String responseMsg = savedReview.getDate()+"save with id"+savedReview.getTitle();
		return new ResponseEntity<String>(responseMsg,HttpStatus.OK);
	} catch(Exception e) {
		String errorMsg = "Contact to customer care 19876-89-876 or mail us:- care@capg.com";
		return new ResponseEntity<String>(errorMsg,HttpStatus.OK);
	}
}

@GetMapping("/allReview")
public List<Review> getAllReviews()
{
	// write some code to extract users
	try {
		List<Review>  allExtractedReviews = reviewService.getAllReviews();
		
		return allExtractedReviews;
		
	} catch (Exception e) {
		// code missing for exception handling 
		System.out.println(e);
		
	}
	
	return null;
}

@PutMapping("/update")
public ResponseEntity<Review> updateReview(@RequestBody Review review) throws Exception
{
	Review savedReview =  reviewService.addReview(review);
	return new ResponseEntity<Review>(savedReview,HttpStatus.CREATED);
	
}
@DeleteMapping("/userId/{searchUserid}")
public void deleteReviewByUserId(@PathVariable int searchUserid ) 
{
	try {
		reviewService.deleteReviewByUserId(searchUserid);
		
	  }catch(Exception e){
		  e.printStackTrace();
	  }

}








}
