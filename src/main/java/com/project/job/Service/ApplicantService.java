package com.project.job.Service;

import java.util.List;

import com.project.job.dto.request.ApplicantRequest;
import com.project.job.dto.response.ApplicantResponse;

public interface ApplicantService
{
	ApplicantResponse getApplicantById(Long applicantId);
	List<ApplicantResponse> getAllApplicants();
	ApplicantResponse addApplicant(ApplicantRequest applicant) throws Exception;
	ApplicantResponse updateApplicant(Long applicantId, ApplicantRequest applicant) throws Exception;
	boolean deleteApplicant(Long applicantId);
}
