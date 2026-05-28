package com.project.job.dto.request;

import lombok.Data;

import org.springframework.stereotype.Service;

@Data
@Service
public class EnrollmentRequest
{
	private Long applicantId;
	private Long jobId;
}
