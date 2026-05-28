package com.project.job.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.job.pojo.EnrollmentTable;

public interface EnrollmentRepository extends JpaRepository<EnrollmentTable , Long>
{
}
