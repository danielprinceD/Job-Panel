package com.practice.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.practice.entity.pojo.Users;

@Service
public interface UserRepository extends JpaRepository<Users, Long>
{

}
