package com.project.job.combinator.validation;

import java.util.function.Function;

import com.project.job.pojo.ApplicantTable;

public interface ApplicantValidator extends Function<ApplicantTable , ApplicantValidator.ApplicantValidationResult>
{

	static enum ApplicantValidationResult
	{
		SUCCESS,
		APPLICANT_NAME_NOT_VALID,
		APPLICANT_EMAIL_NOT_VALID,
		APPLICANT_PHONE_NOT_VALID
	}

	static ApplicantValidator isApplicantNameValid()
	{
		return applicant -> applicant.getApplicantName() != null && !applicant.getApplicantName().isEmpty() ? ApplicantValidationResult.SUCCESS : ApplicantValidationResult.APPLICANT_NAME_NOT_VALID;
	}

	static ApplicantValidator isApplicantEmailValid()
	{
		return applicant -> applicant.getApplicantEmail() != null && !applicant.getApplicantEmail().isEmpty() ? ApplicantValidationResult.SUCCESS : ApplicantValidationResult.APPLICANT_EMAIL_NOT_VALID;
	}

	static ApplicantValidator isApplicantPhoneValid()
	{
		return applicant -> applicant.getApplicantPhone() != null && !applicant.getApplicantPhone().isEmpty() ? ApplicantValidationResult.SUCCESS : ApplicantValidationResult.APPLICANT_PHONE_NOT_VALID;
	}


	default ApplicantValidator and(ApplicantValidator other)
	{
		return applicant -> {
			ApplicantValidationResult result = this.apply(applicant);
			return result.equals(ApplicantValidationResult.SUCCESS) ? other.apply(applicant) : result;
		};
	}

}
