package com.project.job.pojo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class InterviewTable
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long interviewId;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn( name = "enrollment_id" , referencedColumnName = "enrollmentId")
	private List<EnrollmentTable> enrollmentId;

	private String interviewLocation;
	private LocalDateTime interviewDateTime;

}
