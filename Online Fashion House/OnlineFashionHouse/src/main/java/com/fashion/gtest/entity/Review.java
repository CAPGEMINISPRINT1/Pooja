package com.fashion.gtest.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "review")
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int userId;
	private String title;
	private String description;
    private	int points;
	 private String date;
	 private String userName;
	 private String productName;
	
}
