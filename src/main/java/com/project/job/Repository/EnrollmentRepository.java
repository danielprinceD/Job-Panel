package com.project.job.Repository;

import jakarta.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.project.job.pojo.EnrollmentTable;

@Service
public interface EnrollmentRepository extends JpaRepository<EnrollmentTable , Long>
{
	@Modifying
	@Transactional
	@Query( value = "INSERT INTO EnrollmentTable (applicantId , jobId) VALUES (:applicantId , :jobId)" , nativeQuery = true)
	public int saveByApplicantIdAndJobId(Long applicantId , Long jobId);
}
