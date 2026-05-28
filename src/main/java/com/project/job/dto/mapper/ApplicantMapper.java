package com.project.job.dto.mapper;

import com.project.job.dto.request.ApplicantRequest;
import com.project.job.dto.response.ApplicantResponse;
import com.project.job.pojo.ApplicantTable;

public class ApplicantMapper
{
	public static ApplicantTable toApplicantTable(ApplicantRequest request)
	{
		ApplicantTable applicantTable = new ApplicantTable();
		applicantTable.setApplicantName(request.getApplicantName());
		applicantTable.setApplicantEmail(request.getApplicantEmail());
		applicantTable.setApplicantPhone(request.getApplicantPhone());
		return applicantTable;
	}

	public static ApplicantResponse toApplicantResponse(ApplicantTable applicantTable)
	{
		ApplicantResponse response = new ApplicantResponse();
		response.setApplicantId(applicantTable.getApplicantId());
		response.setApplicantName(applicantTable.getApplicantName());
		response.setApplicantEmail(applicantTable.getApplicantEmail());
		response.setApplicantPhone(applicantTable.getApplicantPhone());
		return response;
	}

}
