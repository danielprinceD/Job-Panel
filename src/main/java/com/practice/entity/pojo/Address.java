package com.practice.entity.pojo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Address
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long addressID;
	private String userID;
	private String city;
	private String state;
	private String country;
}