package com.project.job.Service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.server.ResponseStatusException;

import com.project.job.Repository.ApplicantRepository;
import com.project.job.Repository.EnrollmentRepository;
import com.project.job.Repository.JobRepository;
import com.project.job.Service.EntrollmentService;
import com.project.job.dto.mapper.ApplicantEnrollmentMapper;
import com.project.job.dto.mapper.ApplicantMapper;
import com.project.job.dto.mapper.EnrollmentMapper;
import com.project.job.dto.mapper.JobEntrollmentMapper;
import com.project.job.dto.mapper.JobMapper;
import com.project.job.dto.request.EnrollmentRequest;
import com.project.job.dto.response.ApplicantEnrollmentResponse;
import com.project.job.dto.response.ApplicantResponse;
import com.project.job.dto.response.EnrollmentResponse;
import com.project.job.dto.response.JobEnrollmentResponse;
import com.project.job.dto.response.JobResponse;
import com.project.job.pojo.ApplicantTable;
import com.project.job.pojo.EnrollmentTable;
import com.project.job.pojo.Job;

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
		ApplicantTable applicantTable = applicantRepository.findById(applicantId).orElse(null);
		Job job = jobRepository.findById(jobId).orElse(null);
		if(applicantTable == null){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST , "Applicant with id " + applicantId + " not found.");
		}
		if(job == null){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST , "Job with id " + jobId + " not found.");
		}
		EnrollmentTable enrollmentTable = new EnrollmentTable();
		enrollmentTable.setApplicants(applicantTable);
		enrollmentTable.setJobs(job);
		enrollmentTable = enrollmentRepository.save(enrollmentTable);
		if( enrollmentTable == null || enrollmentTable.getEnrollmentId() == null){
			throw new ErrorResponseException(HttpStatus.INTERNAL_SERVER_ERROR , new Throwable(){
				@Override public String getMessage()
				{
					return "Failed to enroll applicant with id " + applicantId + " to job with id " + jobId + ".";
				}
			});
		}

		return EnrollmentMapper.toEnrollmentResponse(enrollmentTable);
	}

	@Override public JobEnrollmentResponse getAllEnrollmentsByJobId(Long jobId)
	{
		Job job = jobRepository.findById(jobId).orElseThrow(
			()->new ResponseStatusException(HttpStatus.BAD_REQUEST , "Job with id " + jobId + " not found.")
		);
		JobResponse jobResponse = JobMapper.toJobResponse(job);
		List<EnrollmentResponse> enrollmentResponse = enrollmentRepository.findByJobs(job)
			.stream()
			.map(EnrollmentMapper::toEnrollmentResponse).toList();
		return JobEntrollmentMapper.toJobEnrollmentResponse(job , enrollmentResponse);
	}

	@Override public ApplicantEnrollmentResponse getAllEnrollmentsByApplicantId(Long applicantId)
	{
		ApplicantTable applicantTable = applicantRepository.findById(applicantId).orElse(null);
		if(applicantTable == null){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST , "Applicant with id " + applicantId + " not found.");
		}
		ApplicantResponse applicantResponse = ApplicantMapper.toApplicantResponse(applicantTable);
		List<EnrollmentResponse> enrollmentTable = enrollmentRepository.findByApplicants(applicantTable)
			.stream().map(EnrollmentMapper::toEnrollmentResponse).toList();

		return ApplicantEnrollmentMapper.toApplicantEnrollmentResponse(applicantResponse , enrollmentTable);
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
