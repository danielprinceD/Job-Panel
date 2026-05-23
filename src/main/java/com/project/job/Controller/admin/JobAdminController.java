package com.project.job.Controller.admin;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@PreAuthorize("hasRole('ADMIN')")
@RequestMapping("/api/v1/admin")
@RestController
public class JobAdminController
{
	@GetMapping("/jobs")
	public String getAdminJobDetails()
	{
		return "Admin Job Details";
	}

}
