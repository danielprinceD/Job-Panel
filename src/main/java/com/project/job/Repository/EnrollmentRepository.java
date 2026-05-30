package com.project.job.Repository;

import jakarta.transaction.Transactional;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.project.job.pojo.ApplicantTable;
import com.project.job.pojo.EnrollmentTable;
import com.project.job.pojo.Job;

@Service
public interface EnrollmentRepository extends JpaRepository<EnrollmentTable , Long>
{
}
