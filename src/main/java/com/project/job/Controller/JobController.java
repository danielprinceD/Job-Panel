package com.project.job.Controller;

import tools.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.server.ResponseStatusException;

import com.project.job.Service.JobService;
import com.project.job.pojo.Job;

@RequestMapping("/api/v1")
@RestController
public class JobController
{
	private JobService jobService;

	public JobController(JobService jobService)
	{
		this.jobService = jobService;
	}

	@GetMapping("/jobs")
	public ResponseEntity getAllJobDetails()
	{
		List jobList = jobService.getAllJobs();
		return ResponseEntity.ok(jobList);
	}

	@GetMapping("/jobs/{jobId}")
	public ResponseEntity getJobDetails(@PathVariable  String jobId)
	{
		Map resultData;
		try {
			resultData = jobService.getJobDetails(jobId);
		}
		catch(ResponseStatusException e){
			return ResponseEntity.status(e.getStatusCode()).body(Map.of("message" , e.getReason()));
		}
		return ResponseEntity.ok(Map.of( "message" , "Data Fetched Successfully" , "data" , resultData ));
	}

	@PostMapping("/jobs")
	public ResponseEntity addJob(@RequestBody Map jobDetail)
	{
		Map resultData = jobService.addJob(jobDetail);
		return ResponseEntity.ok(Map.of( "message" , "Data Added Successfully" , "data" , resultData ));
	}

	@PutMapping("/jobs/{jobId}")
	public ResponseEntity updateJob(@PathVariable("jobId") String jobId , @RequestBody Map jobDetail)
	{
		Map updatedResultData;
		try {
			updatedResultData = jobService.updateJob(jobId , jobDetail);
		}
		catch(ResponseStatusException e){
			return ResponseEntity.status(e.getStatusCode()).body(Map.of("message" , e.getReason()));
		}
		return ResponseEntity.ok(updatedResultData);
	}

	@PostMapping("/jobs/{id}/attachment")
	public ResponseEntity<?> addJobImageById( @PathVariable("id") String jobId , @RequestPart("attachment") MultipartFile file){
//		Map requestJson = new ObjectMapper().convertValue( data , Map.class);
		try {
			jobService.addAttachemntByJobId( jobId , file);
		}catch(ResponseStatusException  e){
			return ResponseEntity.internalServerError().body(Map.of("message" , e.getReason()));
		}
		return ResponseEntity.ok(Map.of("message" , "Attachment Added Successfully"));
	}


}
