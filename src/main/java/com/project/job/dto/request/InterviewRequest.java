package com.project.job.dto.request;

import lombok.Data;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

@Data
@Service
public class InterviewRequest
{
	public Long enrollmentId;
	private String interviewLocation;
	private LocalDateTime interviewDateTime;
}
