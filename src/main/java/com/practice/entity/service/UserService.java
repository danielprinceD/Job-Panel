package com.practice.entity.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public interface UserService
{
	List getUsers();
	Map getUserByID(String userID);
	boolean addUser(Map user);
	boolean updateUser(String userId , Map user);
	boolean deleteUser(String userID);
}
