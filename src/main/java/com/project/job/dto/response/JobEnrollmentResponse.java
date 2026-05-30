package com.project.job.dto.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.project.job.pojo.Job;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Data
public class JobEnrollmentResponse
{
	JobResponse jobResponse;
	List<EnrollmentResponse> enrollmentResponses;

}
