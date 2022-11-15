package com.fashion.gtest.entity;



import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "App_users")

public class AppUser {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)

private int userId;

private String userName;
private String password;

@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "profile")


private Profile userProfile;

public AppUser(String userName, String password) {
	super();
	this.userName = userName;
	this.password = password;
	
}


}
