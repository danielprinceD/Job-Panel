package com.project.job.dto.request;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import org.springframework.stereotype.Service;

import com.project.job.pojo.enums.JOB_STATUS;

@Data
@Service
public class JobRequest
{
	private Long jobId;
	private String jobTitle;
	private String jobDescription;
	private Double salary;
	private String location;
	private Integer workingHours;
	private String modeOfWork;
	private JOB_STATUS jobStatus;
}
