package com.lankajob.lankajob.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lankajob.lankajob.entity.User;
import com.lankajob.lankajob.entity.UserJob;
import com.lankajob.lankajob.repository.JobRepository;
import com.lankajob.lankajob.repository.UserJobRepository;
import com.lankajob.lankajob.repository.UserRepository;


@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private JobRepository jobRepository;
	@Autowired
	private UserJobRepository userJobRepository;
	@Autowired
	private MailService sendMail;
	
	public boolean applyToJob(User user,int jobId) {
		try {
			User getUser = new User();
			getUser = userRepository.save(user);
			UserJob userJob = new UserJob(getUser,jobRepository.findById(jobId),0);
			userJobRepository.save(userJob);
			
			sendMail.sendNewMail(getUser.getEmail(), "Your application accepted!", "Hey, Your job application accepted!.");	
			
			return true;
			
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
		
	}

}
