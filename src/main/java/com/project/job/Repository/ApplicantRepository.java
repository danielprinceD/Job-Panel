package com.project.job.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.job.pojo.ApplicantTable;

public interface ApplicantRepository extends JpaRepository<ApplicantTable , Long>
{
}
