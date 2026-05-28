package com.project.job.combinator.validation;

import java.util.function.Function;

import com.project.job.pojo.Job;

public interface JobValidator extends Function<Job, JobValidator.JobValidationResult>
{
	static enum JobValidationResult
	{
		SUCCESS,
		JOB_TITLE_NOT_VALID,
		JOB_DESCRIPTION_NOT_VALID,
		JOB_STATUS_NOT_VALID,
		JOB_LOCATION_NOT_VALID ,
	}

	static JobValidator isJobTitleValid()
	{
		return job -> job.getJobTitle() != null && !job.getJobTitle().isEmpty() ? JobValidationResult.SUCCESS : JobValidationResult.JOB_TITLE_NOT_VALID;
	}
	static JobValidator isJobDescriptionValid()
	{
		return job -> job.getJobDescription() != null && !job.getJobDescription().isEmpty() ? JobValidationResult.SUCCESS : JobValidationResult.JOB_DESCRIPTION_NOT_VALID;
	}

	static JobValidator isJobStatusValid()
	{
		return job -> job.getJobStatus() != null ? JobValidationResult.SUCCESS : JobValidationResult.JOB_STATUS_NOT_VALID;
	}

	static JobValidator isJobLocationValid()
	{
		return job -> job.getLocation() != null && !job.getLocation().isEmpty() ? JobValidationResult.SUCCESS : JobValidationResult.JOB_LOCATION_NOT_VALID;
	}

	default JobValidator and(JobValidator other)
	{
		return job -> {
			JobValidationResult result = this.apply(job);
			return result.equals(JobValidationResult.SUCCESS) ? other.apply(job) : result;
		};
	}

}
