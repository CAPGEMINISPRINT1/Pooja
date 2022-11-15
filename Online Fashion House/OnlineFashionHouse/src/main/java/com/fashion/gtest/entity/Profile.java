package com.fashion.gtest.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Profile")

public class Profile {
	
@Id
@GeneratedValue(strategy = GenerationType.AUTO)

private int profileId;
 
 private int age;
 private String email;
 private long phoneNumber;
private String address;

public Profile( int age, String email, long phoneNumber, String address) {
	super();
	
	this.age = age;
	this.email = email;
	this.phoneNumber = phoneNumber;
	this.address = address;
}
	
	
}