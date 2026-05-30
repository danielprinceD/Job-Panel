package com.project.job.dto.response;

import lombok.Data;

import java.util.List;

import org.springframework.stereotype.Service;

@Data
@Service
public class EnrollmentResponse
{
	public Long enrollmentId;
	public ApplicantResponse applicantResponses;
	public JobResponse jobResponses;
}
