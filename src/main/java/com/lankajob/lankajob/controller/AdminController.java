package com.lankajob.lankajob.controller;

import com.lankajob.lankajob.entity.Job;
import com.lankajob.lankajob.entity.User;
import com.lankajob.lankajob.entity.UserJob;
import com.lankajob.lankajob.repository.JobRepository;
import com.lankajob.lankajob.repository.UserJobRepository;
import com.lankajob.lankajob.repository.UserRepository;
import com.lankajob.lankajob.service.AdminService;
import com.lankajob.lankajob.service.MailService;
import com.lankajob.lankajob.service.UserJobService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private UserJobRepository userJobRepository;
    
    @Autowired
    private UserJobService userJobService;
    @Autowired
    private AdminService adminService;

    @GetMapping("/admin")
    public String adminHome(Model model){
        model.addAttribute("usersCount",userRepository.count());
        model.addAttribute("hiredUsers",userJobRepository.countByStatus(1));
        model.addAttribute("pendingUsers",userJobRepository.countByStatus(0));
        model.addAttribute("rejectedUsers",userJobRepository.countByStatus(-1));
        model.addAttribute("newUsers",userJobRepository.newApplicants());
        return "admin/index";
    }

    @GetMapping("/admin-jobs")
    public String jobsPage(Model model){   	
    	model.addAttribute("allJobs",jobRepository.findAll());
        return "admin/jobs";
    }
    
    @PostMapping("/admin-jobs")
    public String addJob(Job job,Model model) {
    	Job savedJob = jobRepository.save(job);
		model.addAttribute("jobIsAdded",savedJob.getId() != 0 ? 1:0);
		model.addAttribute("allJobs",jobRepository.findAll());
		return "admin/jobs";  	
    }

    @GetMapping("/admin-applicants")
    public String applicantsPage(Model model){  	
    	model.addAttribute("newUsers",userJobRepository.newApplicants());
        return "admin/applicants";
    }
    
    @GetMapping("/adminapplicatDetails")
    public String applicantDetailsPage(@RequestParam int id, Model model) {
    	UserJob userJob = userJobRepository.findByUserId(id);
        
    	if(id==0 || userJob==null) {
    		model.addAttribute("newUsers",userJobRepository.newApplicants());
    		return "admin/applicants";
    	}
    	
    	model.addAttribute("user",userJob);
    	return "admin/applicantDetails";
    	
    }
    
    @PostMapping("/adminapplicatStatusUpdate")
    public String userStatusUpdate(@RequestParam int status,int userJobID,Model model) {    	
    	UserJob userJob= userJobService.updateUserJob(status, userJobID);
    	boolean isMailSend = adminService.applicantStatusUpdateMail(status, userJob);
    	
    	if(userJob==null || !isMailSend ) {
    		model.addAttribute("isStatusUpdated",0);
    		model.addAttribute("user", userJobRepository.findById(userJobID));
    		return "admin/applicantDetails";
    	}else {
    		model.addAttribute("isStatusUpdated",1);
    		model.addAttribute("user", userJob);
    		return "admin/applicantDetails";
    	}    	
    }
    

    
    

//    @GetMapping("/test")
//    public String testPage(){
//        return "admin/sign_in_first";
//    }
//    
//    
    
  

}
