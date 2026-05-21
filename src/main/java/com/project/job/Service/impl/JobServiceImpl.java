package com.project.job.Service.impl;

import tools.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import com.project.job.Repository.JobRepository;
import com.project.job.Service.JobService;
import com.project.job.pojo.Job;

@Service
public class JobServiceImpl implements JobService
{
//	private List<Map> jobs = new ArrayList<>();

	@Autowired
	private JobRepository jobRepository;

	@Override
	public Map getJobDetails(String jobId)
	{
		Job job = jobRepository.findById(Long.valueOf(jobId)).orElseThrow(
			()->new ResponseStatusException(HttpStatus.NOT_FOUND , "Job Not Found")
		);
		return new ObjectMapper().convertValue(job , Map.class);
	}

	@Override
	public List getAllJobs()
	{
		return new ObjectMapper().convertValue( jobRepository.findAll() , List.class);
	}

	@Override
	public Map addJob(Map jobDetail)
	{
//		jobDetail.put("id", String.valueOf(jobs.size() + 1));
//		jobs.add(jobDetail);
		System.out.println(jobDetail);
		Job inputJob = new ObjectMapper().convertValue(jobDetail , Job.class);
		System.out.println(inputJob);
		jobRepository.save(inputJob);
		return jobDetail;
	}

	@Override
	public Map updateJob(String jobId, Map jobDetail)
	{
		Job updatedJob = new ObjectMapper().convertValue(jobDetail , Job.class);
		Optional<Job> job = Optional.ofNullable(jobRepository.findById(Long.valueOf(jobId)).orElseThrow(
			() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Job Not Found")
		));
		if(job.isPresent()){
			updatedJob.setJobId(Long.valueOf(jobId));
			jobRepository.save(updatedJob);
		}
		return new ObjectMapper().convertValue( updatedJob , Map.class);
	}

	public void validateFile(MultipartFile file) throws ResponseStatusException
	{
		if(file.isEmpty()){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST , "File is Empty");
		}
		if(file.getSize() > 5 * 1024 * 1024){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST , "File Size Exceeds Limit of 5MB");
		}
	}

	@Override
	public Map addAttachemntByJobId(String jobId, MultipartFile file)
	{
		try {
			validateFile(file);
			Job job = jobRepository.findById(Long.valueOf(jobId)).orElseThrow(
				()->new ResponseStatusException(HttpStatus.NOT_FOUND , "Job Not Found")
			);

			job.setAttachment(file.getBytes());
			jobRepository.save(job);
			return Map.of("message" , "File Uploaded Successfully");
		}
		catch(ResponseStatusException e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST , e.getReason());
		}
		catch(Exception e){
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR , "An Error Occurred While Uploading File");
		}
	}

	@Override
	public List searchJobByTitle(String keyword)
	{
		try{
			List<Job> jobs = jobRepository.findByKeyword(keyword);
			return jobs;
		}
		catch(ResponseStatusException e){
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST , "An Error Occurred While Searching for Jobs");
		}
	}

}
