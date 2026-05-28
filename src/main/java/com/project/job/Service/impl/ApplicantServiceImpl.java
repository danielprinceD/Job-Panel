package com.project.job.Service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.project.job.Repository.ApplicantRepository;
import com.project.job.Service.ApplicantService;
import com.project.job.combinator.validation.ApplicantValidator;
import com.project.job.dto.mapper.ApplicantMapper;
import com.project.job.dto.request.ApplicantRequest;
import com.project.job.dto.response.ApplicantResponse;
import com.project.job.pojo.ApplicantTable;

@Service
public class ApplicantServiceImpl implements ApplicantService
{
	@Autowired private ApplicantRepository applicantRepository;

	ApplicantValidator applicantValidator = ApplicantValidator.isApplicantEmailValid()
		.and(ApplicantValidator.isApplicantNameValid())
		.and(ApplicantValidator.isApplicantPhoneValid());

	@Override public ApplicantResponse getApplicantById(Long applicantId)
	{
		Optional<ApplicantTable> applicantTable = applicantRepository.findById(applicantId);
		return applicantTable.map(ApplicantMapper::toApplicantResponse).orElse(null);
	}

	@Override public List<ApplicantResponse> getAllApplicants()
	{
		return applicantRepository.findAll().stream().map(ApplicantMapper::toApplicantResponse).toList();
	}

	@Override public ApplicantResponse addApplicant(ApplicantRequest applicant) throws Exception
	{
		ApplicantTable applicantTable = ApplicantMapper.toApplicantTable(applicant);
		ApplicantValidator.ApplicantValidationResult result = applicantValidator.apply(applicantTable);

		if( result != ApplicantValidator.ApplicantValidationResult.SUCCESS ){
			throw new Exception("Invalid applicant data: " + result.name());
		}
		applicantTable = applicantRepository.save(applicantTable);
		return ApplicantMapper.toApplicantResponse(applicantTable);
	}

	@Override public ApplicantResponse updateApplicant(Long applicantId, ApplicantRequest applicant) throws Exception
	{
		ApplicantTable applicantTable = ApplicantMapper.toApplicantTable(applicant);
		ApplicantValidator.ApplicantValidationResult result = applicantValidator.apply(applicantTable);
		if( result != ApplicantValidator.ApplicantValidationResult.SUCCESS ){
			throw new Exception("Invalid applicant data: " + result.name());
		}
		applicantTable.setApplicantId(applicantId);
		applicantTable = applicantRepository.save(applicantTable);
		return ApplicantMapper.toApplicantResponse(applicantTable);
	}

	@Override public boolean deleteApplicant(Long applicantId)
	{
		if (applicantRepository.existsById(applicantId)) {
			applicantRepository.deleteById(applicantId);
			return true;
		}
		return false;
	}
}
