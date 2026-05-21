package com.project.job.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class Job
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long jobId;
	private String jobTitle;
	private String jobDescription;
	private Double salary;
	private String location;
	private Integer workingHours;
	private String modeOfWork;
	@Lob
	private byte[] attachment;

	public byte[] getAttachment() {
		return attachment;
	}
	public void setAttachment(byte[] attachment) {
		this.attachment = attachment;
	}

	public Long getJobId(){
		return jobId;
	}

	public void setJobId(Long jobId){
		this.jobId = jobId;
	}

	public String getJobTitle(){
		return jobTitle;
	}

	public String getJobDescription()
	{
		return jobDescription;
	}

	public Double getSalary()
	{
		return salary;
	}

	public String getLocation()
	{
		return location;
	}

	public Integer getWorkingHours()
	{
		return workingHours;
	}

	public String getModeOfWork()
	{
		return modeOfWork;
	}

	public void setJobTitle(String jobTitle)
	{
		this.jobTitle = jobTitle;
	}

	public void setJobDescription(String jobDescription)
	{
		this.jobDescription = jobDescription;
	}

	public void setSalary(Double salary)
	{
		this.salary = salary;
	}

	public void setLocation(String location)
	{
		this.location = location;
	}

	public void setWorkingHours(Integer workingHours)
	{
		this.workingHours = workingHours;
	}

	public void setModeOfWork(String modeOfWork)
	{
		this.modeOfWork = modeOfWork;
	}
}
