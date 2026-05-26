package com.practice.entity.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.practice.entity.pojo.Users;

@Component
public interface UserService
{
	List<Users> getUsers();
	Users getUserByID(String userID);
	boolean addUser(Users user);
	boolean updateUser(String userId , Users user);
	boolean deleteUser(String userID);
}
