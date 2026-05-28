package com.project.job.dto.response;

import lombok.Data;

import org.springframework.stereotype.Service;

import com.project.job.pojo.enums.JOB_STATUS;

@Data
@Service
public class JobResponse
{
	private Long jobId;
	private String jobTitle;
	private String jobDescription;
	private Double salary;
	private JOB_STATUS jobStatus;
	private String location;
	private Integer workingHours;
	private String modeOfWork;
}
