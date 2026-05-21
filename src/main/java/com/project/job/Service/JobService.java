package com.project.job.Service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.project.job.pojo.Job;

public interface JobService
{
	Map getJobDetails(String jobId);
	List getAllJobs();
	Map addJob(Map jobDetail);
	Map updateJob(String jobId , Map jobDetail);
	Map addAttachemntByJobId(String jobId , MultipartFile filePath);
	List searchJobByTitle(String keyword);
}
