package com.project.job.Service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.job.Repository.ApplicantRepository;
import com.project.job.Service.ApplicantService;
import com.project.job.dto.mapper.ApplicantMapper;
import com.project.job.dto.request.ApplicantRequest;
import com.project.job.dto.response.ApplicantResponse;
import com.project.job.pojo.ApplicantTable;

@Service
public class ApplicantServiceImpl implements ApplicantService
{
	@Autowired private ApplicantRepository applicantRepository;

	@Override public ApplicantResponse getApplicantById(Long applicantId)
	{
		Optional<ApplicantTable> applicantTable = applicantRepository.findById(applicantId);
		return applicantTable.map(ApplicantMapper::toApplicantResponse).orElse(null);
	}

	@Override public List<ApplicantResponse> getAllApplicants()
	{
		return applicantRepository.findAll().stream().map(ApplicantMapper::toApplicantResponse).toList();
	}

	@Override public ApplicantResponse addApplicant(ApplicantRequest applicant)
	{
		ApplicantTable applicantTable = applicantRepository.save(ApplicantMapper.toApplicantTable(applicant));
		return ApplicantMapper.toApplicantResponse(applicantTable);
	}

	@Override public ApplicantResponse updateApplicant(Long applicantId, ApplicantRequest applicant)
	{
		ApplicantTable applicantTable = ApplicantMapper.toApplicantTable(applicant);
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
