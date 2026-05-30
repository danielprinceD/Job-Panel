package com.project.job.dto.mapper;

import java.util.List;

import com.project.job.dto.response.EnrollmentResponse;
import com.project.job.dto.response.JobEnrollmentResponse;
import com.project.job.dto.response.JobResponse;
import com.project.job.pojo.Job;

public class JobEntrollmentMapper
{
	public static JobEnrollmentResponse toJobEnrollmentResponse(Job job , List<EnrollmentResponse> enrollmentResponse)
	{
		JobEnrollmentResponse response = new JobEnrollmentResponse();
		response.setJobResponse(JobMapper.toJobResponse(job));
		response.setEnrollmentResponses(enrollmentResponse);
		return response;
	}
}
