package com.project.job.combinator.validation;

import java.util.function.Function;

import com.project.job.pojo.EnrollmentTable;
import com.project.job.pojo.Job;

public interface EnrollmentValidator extends Function<EnrollmentTable, EnrollmentValidator.JobValidationResult>
{
	static enum JobValidationResult
	{
		SUCCESS,

	}


	default EnrollmentValidator and(EnrollmentValidator other)
	{
		return job -> {
			JobValidationResult result = this.apply(job);
			return result.equals(JobValidationResult.SUCCESS) ? other.apply(job) : result;
		};
	}

}
