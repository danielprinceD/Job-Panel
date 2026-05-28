package com.project.job.dto.response;

import lombok.Data;

import org.springframework.stereotype.Service;

@Data
@Service
public class ApplicantResponse
{
	private Long applicantId;
	private String applicantName;
	private String applicantEmail;
	private String applicantPhone;
}
