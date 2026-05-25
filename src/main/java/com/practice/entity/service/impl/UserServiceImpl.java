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
	private UserRepository userRepository;

	@Override public List getUsers()
	{
		return userRepository.findAll();
	}

	@Override public Map getUserByID(String userID)
	{

		try {
			Long id = Long.valueOf(userID);
			Users user = userRepository.findById(id).orElseThrow();
			return new ObjectMapper().convertValue(user , Map.class);
		}
		catch(Exception e)
		{
			return Map.of();
		}
	}

	@Override public boolean addUser(Map user)
	{
		try
		{
			Users users = new ObjectMapper().convertValue(user , Users.class);
			System.out.println( user +  " " + users);
			userRepository.save(users);
			return true;
		}
		catch(Exception e)
		{
			return false;
			}
	}

	@Override public boolean updateUser(String userId, Map user)
	{
		try
		{
			Users users = new ObjectMapper().convertValue(user , Users.class);
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
