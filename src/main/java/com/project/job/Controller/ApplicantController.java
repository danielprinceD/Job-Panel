package com.project.job.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.job.Service.ApplicantService;
import com.project.job.dto.request.ApplicantRequest;
import com.project.job.dto.response.ApplicantResponse;

@RequestMapping("/api/v1")
@RestController
public class ApplicantController
{

	@Autowired private ApplicantService service;

	@GetMapping("/applicants/{applicantId}")
	public ResponseEntity<ApplicantResponse> getApplicantById( @PathVariable("applicantId") Long applicantId) throws Exception
	{
		ApplicantResponse response = service.getApplicantById(applicantId);
		return response == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(response);
	}

	@GetMapping("/applicants")
	public ResponseEntity<?> getAllApplicants() throws Exception
	{
		return ResponseEntity.ok(service.getAllApplicants());
	}

	@PostMapping("/applicants")
	public ResponseEntity<ApplicantResponse> addApplicant(@RequestBody ApplicantRequest applicant) throws Exception
	{
		ApplicantResponse response = service.addApplicant(applicant);
		return response == null ? ResponseEntity.badRequest().build() : ResponseEntity.ok(response);
	}

}
