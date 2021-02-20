package com.lankajob.lankajob.repository;

import com.lankajob.lankajob.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {


	List<User> findTop10ByOrderByIdDesc();
	
	



}
