package com.project.job.dto.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

import org.springframework.stereotype.Service;

@EqualsAndHashCode(callSuper = true)
@Data
@Service
public class ApplicantEnrollmentResponse extends ApplicantResponse
{
	List<EnrollmentResponse> entrollmentResponses;
}
