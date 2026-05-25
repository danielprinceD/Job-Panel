package com.practice.entity.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.practice.entity.service.UserService;

@RestController
public class UserController
{
	@Autowired
	private UserService userService;

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
	public ResponseEntity addUser(@RequestBody Map user) throws Exception
	{
		boolean isAdded = userService.addUser(user);
		if(!isAdded){
			return ResponseEntity.status(400).body(Map.of(
				"code" , 400,
				"message" , Map.of(
					"error" , "User Not Added"
				)
			));
		}
		return ResponseEntity.ok(Map.of(
			"code" , 200,
			"message" , Map.of(
				"success" , "User Added Successfully"
			)
		));
	}

	@PutMapping("/users/{id}")
	public ResponseEntity updateUser( @PathVariable("id") String userId ,  @RequestBody Map user)
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
