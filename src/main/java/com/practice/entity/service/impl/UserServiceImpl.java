package com.practice.entity.service.impl;

import tools.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.practice.entity.pojo.Users;
import com.practice.entity.repository.UserRepository;
import com.practice.entity.service.UserService;

@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private UserRepository userRepository;

	@Override public List getUsers()
	{
		return userRepository.findAll();
	}

	@Override public Users getUserByID(String userID)
	{

		try {
			Long id = Long.valueOf(userID);
			Users user = userRepository.findById(id).orElseThrow();
			return user;
		}
		catch(Exception e)
		{
			return null;
		}
	}

	@Override public boolean addUser(Users user)
	{
		try
		{
			userRepository.save(user);
			return true;
		}
		catch(Exception e)
		{
			return false;
			}
	}

	@Override public boolean updateUser(String userId, Users user)
	{
		try
		{
			Users users = objectMapper.convertValue(user , Users.class);
			users.setUserID(Long.valueOf(userId));
			userRepository.save(users);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override public boolean deleteUser(String userID)
	{
		return false;
	}
}
