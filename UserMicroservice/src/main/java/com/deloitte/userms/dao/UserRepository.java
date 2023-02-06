package com.deloitte.userms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deloitte.userms.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	public User findByUserId(Integer userId);
}
