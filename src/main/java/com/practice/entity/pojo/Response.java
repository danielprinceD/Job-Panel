package com.practice.entity.pojo;

import lombok.Getter;

import java.util.Map;

import org.springframework.http.HttpStatus;

@Getter
public class Response
{
	private Long code;
	private Object message;
	public Response(HttpStatus httpStatus, Object message) {
		this.code = Long.valueOf(httpStatus.value());
		this.message = message;
	}
	public Response build(){
		return this;
	};
}
