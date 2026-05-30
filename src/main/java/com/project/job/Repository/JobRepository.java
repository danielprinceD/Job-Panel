package com.project.job.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.project.job.pojo.Job;

@Service
public interface JobRepository extends JpaRepository<Job , Long>
{
	@Query("SELECT j FROM Job j WHERE LOWER(j.jobTitle) LIKE LOWER(CONCAT('%' , :keyword ,  '%')) OR LOWER(j.jobDescription) LIKE LOWER(CONCAT('%' , :keyword ,  '%')) OR LOWER(j.location) LIKE LOWER(CONCAT('%' , :keyword ,  '%'))")
	public List findByKeyword(String keyword);


}
