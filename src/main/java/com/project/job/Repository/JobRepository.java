package com.project.job.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.project.job.pojo.Job;

@Service
public interface JobRepository extends JpaRepository<Job , Long>
{

}
