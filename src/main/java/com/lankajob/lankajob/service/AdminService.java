package com.lankajob.lankajob.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lankajob.lankajob.entity.UserJob;
import com.lankajob.lankajob.repository.UserRepository;

@Service
public class AdminService {
	

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private MailService mailService;
	
	public boolean applicantStatusUpdateMail(int status, UserJob userJob) {
		try {
			String msgBody="";
			String job = userJob.getJob().getTitle();
			
			if(status==1) {
				msgBody="Hey, You are hired for the new job "+ job;
			}else if(status==-1) {
				msgBody="Hey, Sorry it inform you that,You application got rejected for "+ job;
			}
			
			mailService.sendNewMail(userJob.getUser().getEmail(), "Its About your Job Application", msgBody);
			
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

}
