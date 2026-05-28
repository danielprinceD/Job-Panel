package com.project.job.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class ApplicantTable
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long applicantId;
	private String applicantName;
	@Column(unique = true)
	private String applicantEmail;
	private String applicantPhone;

}
