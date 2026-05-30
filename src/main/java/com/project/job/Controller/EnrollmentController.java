package com.project.job.Controller;

import lombok.extern.slf4j.Slf4j;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.project.job.Service.EntrollmentService;
import com.project.job.dto.response.EnrollmentResponse;

@Slf4j @RequestMapping("/api/v1")
@RestController
public class EnrollmentController
{
	@Autowired private EntrollmentService entrollmentService;


	@PostMapping("/enrolls")
	public ResponseEntity<?> enrollApplicantToJob(@RequestParam("applicant_id") Long applicantId ,@RequestParam("job_id") Long jobId)
	{
		try {
			EnrollmentResponse enrollmentResponse = entrollmentService.enrollApplicantToJob(applicantId , jobId);
			return ResponseEntity.ok(
				enrollmentResponse
			);
		}
		catch(DataIntegrityViolationException e){
			return ResponseEntity.badRequest().body(Map.of(
				"error" , "Applicant with id " + applicantId + " is already enrolled to job with id " + jobId
			));
		}
		catch(ResponseStatusException e){
			return ResponseEntity.badRequest().body(Map.of(
				"code" , e.getStatusCode().value(),
				"error", e.getReason()
			));
		}
		catch(Exception e){
			return ResponseEntity.status(500).body("An unexpected error occurred: " + e.getMessage());
		}
	}

	@GetMapping("/enrolls/{enrollment_id}")
	public ResponseEntity<?> getEnrollmentById( @PathVariable("enrollment_id") Long enrollmentId)
	{
		try {
			EnrollmentResponse enrollmentResponse = entrollmentService.getEnrollmentById(enrollmentId);
			if(enrollmentResponse == null){
				return ResponseEntity.status(404).body("Enrollment with id " + enrollmentId + " not found.");
			}
			return ResponseEntity.ok(
				enrollmentResponse
			);
		}
		catch(ErrorResponseException e){
			return ResponseEntity.status(e.getStatusCode()).body(e.getMessage());
		}
		catch(Exception e){
			return ResponseEntity.status(500).body("An unexpected error occurred: " + e.getMessage());
		}
	}
}
