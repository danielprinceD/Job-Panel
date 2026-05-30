package com.project.job.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.project.job.dto.request.EnrollmentRequest;
import com.project.job.dto.response.ApplicantEnrollmentResponse;
import com.project.job.dto.response.EnrollmentResponse;

public interface EntrollmentService
{
	EnrollmentResponse enrollApplicantToJob(Long applicantId , Long jobId);
	List<EnrollmentResponse> getAllEnrollmentsByJobId(Long jobId);
	ApplicantEnrollmentResponse getAllEnrollmentsByApplicantId(Long applicantId);
	EnrollmentResponse getEnrollmentById(Long enrollmentId);
	EnrollmentResponse deleteEnrollmentById(Long enrollmentId);
	EnrollmentResponse updateEnrollmentDetails(Long enrollmentId , EnrollmentRequest enrollmentRequest);

}
