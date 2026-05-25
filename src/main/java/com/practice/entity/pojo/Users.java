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

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Data
@NoArgsConstructor
@Entity(name="UsersTable")
public class Users
{
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long userID;
	private String userName;
	private String userEmail;

	@OneToOne( cascade = CascadeType.ALL , orphanRemoval = true)
	@JoinColumn( name="address_id" , referencedColumnName = "addressid")
	private Address address;

	@CreationTimestamp
	private LocalDateTime createdAt;

	@UpdateTimestamp
	private LocalDateTime updatedAt;

}
