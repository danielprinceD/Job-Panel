package com.project.job.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.project.job.pojo.InterviewTable;

@Service
public interface InterviewRepository extends JpaRepository<InterviewTable , Long>
{
}
