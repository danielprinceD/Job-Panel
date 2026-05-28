package com.project.job.dto.mapper;

import com.project.job.dto.request.JobRequest;
import com.project.job.dto.response.JobResponse;
import com.project.job.pojo.Job;

public class JobMapper
{
	public static Job toJobTable(JobRequest request)
	{
		Job jobTable = new Job();
		jobTable.setJobTitle(request.getJobTitle());
		jobTable.setJobDescription(request.getJobDescription());
		jobTable.setLocation(request.getLocation());
		jobTable.setSalary(request.getSalary());
		jobTable.setJobStatus(request.getJobStatus());
		jobTable.setModeOfWork(request.getModeOfWork());
		jobTable.setWorkingHours(request.getWorkingHours());

		return jobTable;
	}

	public static JobResponse toJobResponse(Job jobTable)
	{
		JobResponse response = new JobResponse();
		response.setJobId(jobTable.getJobId());
		response.setJobTitle(jobTable.getJobTitle());
		response.setJobDescription(jobTable.getJobDescription());
		response.setLocation(jobTable.getLocation());
		response.setSalary(jobTable.getSalary());
		response.setJobStatus(jobTable.getJobStatus());
		response.setModeOfWork(jobTable.getModeOfWork());
		response.setWorkingHours(jobTable.getWorkingHours());

		return response;
	}

}
