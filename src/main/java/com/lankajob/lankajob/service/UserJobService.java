package com.lankajob.lankajob.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lankajob.lankajob.entity.UserJob;
import com.lankajob.lankajob.repository.UserJobRepository;

@Service
public class UserJobService {
	
	@Autowired
	private UserJobRepository userJobRepository;
	
	public UserJob updateUserJob(int status,int userJobID ) {
		
		UserJob userJob = userJobRepository.findById(userJobID).orElse(null);
		userJob.setStatus(status);
		userJobRepository.save(userJob);
		return userJob;
		
	}

}
