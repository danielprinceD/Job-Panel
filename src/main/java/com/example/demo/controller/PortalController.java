package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.coyote.Request;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


abstract class HttpResponseWrapper {
	private Map defaultMessage;
	public HttpResponseWrapper() {
		this.defaultMessage = new HashMap<>();
		this.defaultMessage.put("status", "success");
	}
}

class PortalCreationHttpResponseWrapper extends HttpResponseWrapper{
	private String message;
	private Map data;
	private Map defaultMessage;

	public PortalCreationHttpResponseWrapper(String message, Map data ) {
		this.message = message;
		this.data = data;

	}

	public Map getDefaultMessage() {
		return defaultMessage == null ? Map.of() : defaultMessage;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Map getData() {
		return data;
	}

	public void setData(Map data) {
		this.data = data;
	}
}

@RestController
public class PortalController
{
	@GetMapping("/portal/{id}")
	public Map getPortalDetails( @PathVariable("id") String id)
	{
		Map<String, String> portalDetails = new HashMap<>();
		portalDetails.put("id", id);
		portalDetails.put("name", "Portal " + id);
		portalDetails.put("description", "This is portal " + id);
		return portalDetails;
	}

	@PostMapping("/portal")
	public PortalCreationHttpResponseWrapper createPortal(@RequestBody Map requestData){

		return new PortalCreationHttpResponseWrapper("Portal created successfully", requestData );
	}
}
