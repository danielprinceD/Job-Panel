package com.project.job.dto.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

import com.project.job.pojo.Job;


@Data
public class JobEnrollmentResponse
{
	JobResponse jobResponse;
	List<EnrollmentResponse> enrollmentResponses;

}
