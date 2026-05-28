package com.project.job.dto.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.project.job.Repository.EnrollmentRepository;
import com.project.job.dto.request.EnrollmentRequest;
import com.project.job.dto.request.InterviewRequest;
import com.project.job.dto.response.InterviewResponse;
import com.project.job.pojo.EnrollmentTable;
import com.project.job.pojo.InterviewTable;

public class InterviewMapper
{

	public static InterviewTable toInterviewTable( InterviewRequest request , List<EnrollmentTable> enrollmentTable ){
		InterviewTable interviewTable = new InterviewTable();
		interviewTable.setEnrollments(enrollmentTable);
		interviewTable.setInterviewLocation(request.getInterviewLocation());
		interviewTable.setInterviewDateTime(request.getInterviewDateTime());
		return interviewTable;
	}

	public static InterviewResponse toInterviewResponse(InterviewTable interviewTable)
	{
		InterviewResponse response = new InterviewResponse();
		response.setInterviewId(interviewTable.getInterviewId());
		response.setInterviewLocation(interviewTable.getInterviewLocation());
		response.setInterviewDateTime(interviewTable.getInterviewDateTime());
		response.setEnrollmentResponses(
			interviewTable.getEnrollments().stream().map(EnrollmentMapper::toEnrollmentResponse).toList()
		);
		return response;
	}

}
