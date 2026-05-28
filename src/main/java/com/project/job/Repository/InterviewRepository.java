package com.project.job.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.job.pojo.InterviewTable;

public interface InterviewRepository extends JpaRepository<InterviewTable , Long>
{
}
