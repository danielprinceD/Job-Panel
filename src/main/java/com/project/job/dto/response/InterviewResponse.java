package com.project.job.dto.response;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

@Data
@Service
public class InterviewResponse
{
	private Long interviewId;
	private List<EnrollmentResponse> enrollmentResponses;
	private String interviewLocation;
	private LocalDateTime interviewDateTime;

}
