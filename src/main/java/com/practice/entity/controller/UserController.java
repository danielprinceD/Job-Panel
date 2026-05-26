package com.practice.entity.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practice.entity.pojo.Response;
import com.practice.entity.pojo.Users;
import com.practice.entity.service.UserService;

@RestController
public class UserController
{
	@Autowired
	private UserService userService;

	@GetMapping("/users/{id}")
	public ResponseEntity getUserByID(@PathVariable("id") String userID)
	{
		Users user = userService.getUserByID(userID);
		if(user != null){
			return ResponseEntity.status(404).body(Map.of(
				"code" , 404,
				"message" , Map.of(
					"error" , "User Not Found"
				)
			));
		}
		return ResponseEntity.ok(Map.of(
			"code" , 200,
			"message" , user
		));
	}

	@GetMapping("/users")
	public ResponseEntity getUsers()
	{
		List users = userService.getUsers();
		return ResponseEntity.ok(Map.of(
			"code" , 200,
			"message" , users
		));
	}

	@PostMapping("/users")
	public ResponseEntity<Response> addUser(@RequestBody Users user) throws Exception
	{
		boolean isAdded = userService.addUser(user);
		if(!isAdded){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
				new Response(HttpStatus.BAD_REQUEST , "User not created").build()
			);
		}
		return ResponseEntity.ok(new Response( HttpStatus.CREATED  , "User Added").build());
	}

	@PutMapping("/users/{id}")
	public ResponseEntity updateUser( @PathVariable("id") String userId ,  @RequestBody Users user)
	{
		boolean isUpdated = userService.updateUser( userId , user);
		if(!isUpdated){
			return ResponseEntity.status(400).body(Map.of(
				"code" , 400,
				"message" , Map.of(
					"error" , "User Not Updated"
				)
			));
		}
		return ResponseEntity.ok(Map.of(
			"code" , 200,
			"message" , Map.of(
				"success" , "User Updated Successfully"
			)
		));
	}

}
