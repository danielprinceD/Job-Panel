package com.project.job.dto.request;

import lombok.Data;

import org.springframework.stereotype.Service;

@Data
@Service
public class ApplicantRequest
{
	private String applicantName;
	private String applicantEmail;
	private String applicantPhone;
}
