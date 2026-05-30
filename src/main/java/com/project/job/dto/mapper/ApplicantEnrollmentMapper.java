package com.project.job.dto.mapper;

import java.util.List;

import com.project.job.dto.response.ApplicantEnrollmentResponse;
import com.project.job.dto.response.ApplicantResponse;
import com.project.job.dto.response.EnrollmentResponse;

public class ApplicantEnrollmentMapper
{
	public static ApplicantEnrollmentResponse toApplicantEnrollmentResponse(ApplicantResponse applicantResponse , List<EnrollmentResponse> enrollmentResponses)
	{
		ApplicantEnrollmentResponse response = new ApplicantEnrollmentResponse();
		response.setApplicantId(applicantResponse.getApplicantId());
		response.setApplicantName(applicantResponse.getApplicantName());
		response.setApplicantEmail(applicantResponse.getApplicantEmail());
		response.setApplicantPhone(applicantResponse.getApplicantPhone());
		response.setEntrollmentResponses(enrollmentResponses);
		return response;
	}
}
