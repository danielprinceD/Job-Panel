package com.project.job.pojo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jdk.jfr.Timestamp;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

@Data
@Entity(name = "enrollment_table")
@Table(
	uniqueConstraints = {
		@UniqueConstraint(
			columnNames = { "applicant_id" , "job_id" }
		)
	}
)
public class EnrollmentTable
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long enrollmentId;

	@ManyToOne( cascade = CascadeType.ALL  )
	@JoinColumn( name = "applicant_id" , referencedColumnName = "applicantId")
	private ApplicantTable applicants;

	@ManyToOne( cascade = CascadeType.ALL )
	@JoinColumn( name = "job_id" , referencedColumnName = "jobId")
	private Job jobs;

	@CreationTimestamp
	private LocalDateTime createdAt;

}
