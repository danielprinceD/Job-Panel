package com.project.job.dto.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.project.job.dto.response.EnrollmentResponse;
import com.project.job.pojo.EnrollmentTable;

public class EnrollmentMapper
{
	public static EnrollmentResponse toEnrollmentResponse(EnrollmentTable enrollment)
	{
		EnrollmentResponse response = new EnrollmentResponse();
		response.setEnrollmentId(enrollment.getEnrollmentId());
		response.setJobResponses(
			enrollment.getJobs().stream().map(JobMapper::toJobResponse).toList()
		);
		response.setApplicantResponses(
			enrollment.getApplicants().stream().map(ApplicantMapper::toApplicantResponse).toList()
		);
		return response;
	}
}
