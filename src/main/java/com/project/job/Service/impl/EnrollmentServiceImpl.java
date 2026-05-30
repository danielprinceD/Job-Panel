package com.project.job.Service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.ErrorResponseException;

import com.project.job.Repository.ApplicantRepository;
import com.project.job.Repository.EnrollmentRepository;
import com.project.job.Repository.JobRepository;
import com.project.job.Service.EntrollmentService;
import com.project.job.dto.mapper.EnrollmentMapper;
import com.project.job.dto.request.EnrollmentRequest;
import com.project.job.dto.response.EnrollmentResponse;
import com.project.job.pojo.EnrollmentTable;


@Component
public class EnrollmentServiceImpl implements EntrollmentService
{
	@Autowired private EnrollmentRepository enrollmentRepository;
	@Autowired private ApplicantRepository applicantRepository;
	@Autowired private JobRepository jobRepository;

	@Override public EnrollmentResponse getEnrollmentById(Long enrollmentId)
	{
		EnrollmentTable enrollmentTable = enrollmentRepository.findById(enrollmentId).orElse(null);
		if(enrollmentTable == null){
			return null;
		}
		return EnrollmentMapper.toEnrollmentResponse(enrollmentTable);
	}

	@Override public EnrollmentResponse enrollApplicantToJob(Long applicantId, Long jobId)
	{
		if(applicantRepository.findById(applicantId).isEmpty()){
			throw new ErrorResponseException(HttpStatus.BAD_REQUEST , new Throwable(){
				@Override public String getMessage()
				{
					return "Applicant with id " + applicantId + " not found.";
				}
			});
		}
		if(!jobRepository.findById(jobId).isEmpty()){
			throw new ErrorResponseException(HttpStatus.BAD_REQUEST , new Throwable(){
				@Override public String getMessage()
				{
					return "Job with id " + jobId + " not found.";
				}
			});
		}
		int responseID = enrollmentRepository.saveByApplicantIdAndJobId(applicantId, jobId);
		if( responseID == -1 ){
			throw new ErrorResponseException(HttpStatus.INTERNAL_SERVER_ERROR , new Throwable(){
				@Override public String getMessage()
				{
					return "Failed to enroll applicant with id " + applicantId + " to job with id " + jobId + ".";
				}
			});
		}

		return EnrollmentMapper.toEnrollmentResponse(enrollmentRepository.findById(Long.valueOf(responseID)).get());
	}

	@Override public List<EnrollmentResponse> getAllEnrollmentsByJobId(Long jobId)
	{
		return List.of();
	}

	@Override public List<EnrollmentResponse> getAllEnrollmentsByApplicantId(Long applicantId)
	{
		return List.of();
	}

	@Override public EnrollmentResponse deleteEnrollmentById(Long enrollmentId)
	{
		return null;
	}

	@Override public EnrollmentResponse updateEnrollmentDetails(Long enrollmentId, EnrollmentRequest enrollmentRequest)
	{
		return null;
	}
}
