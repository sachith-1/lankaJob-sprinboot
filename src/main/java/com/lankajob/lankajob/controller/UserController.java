package com.lankajob.lankajob.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lankajob.lankajob.entity.User;
import com.lankajob.lankajob.entity.UserJob;
import com.lankajob.lankajob.repository.JobRepository;
import com.lankajob.lankajob.repository.UserJobRepository;
import com.lankajob.lankajob.repository.UserRepository;
import com.lankajob.lankajob.service.UserService;


@Controller
public class UserController {
	
	@Autowired
	private JobRepository jobRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserJobRepository userJobRepository;
	@Autowired
	private UserService userService;
	
	
	@GetMapping(value= {"/home","/","/index"})
	public String homePage(Model model) {
		model.addAttribute("jobs", jobRepository.findTop10ByOrderByIdDesc());
		return "/index";
	}
	
	@PostMapping("/searchJobs")
	public String searchJobs(@RequestParam String searchTerm, String catgo,Model model) {	
		model.addAttribute("jobs",jobRepository.searchJobs(searchTerm, catgo));
		return "/search";
	}
	
	@GetMapping("/category")
	public String categoryPage(@RequestParam(required = false) String catgo,@RequestParam(required = false) String isSuccess,Model model) {
		if(catgo==null) {
			model.addAttribute("jobs",jobRepository.findAll());
		}else {
			model.addAttribute("jobs", jobRepository.findByCatgo(catgo));			
		}
		
		if(isSuccess!=null && isSuccess.equals("1")) {
			model.addAttribute("isSuccess", 1);
		}else if(isSuccess!=null && isSuccess.equals("0")) {
			model.addAttribute("isSuccess", 0);
		}
		
		model.addAttribute("technology", jobRepository.countByCatgo("technology"));
		model.addAttribute("development", jobRepository.countByCatgo("development"));
		model.addAttribute("medical", jobRepository.countByCatgo("medical"));
		model.addAttribute("government", jobRepository.countByCatgo("government"));
		model.addAttribute("accounting", jobRepository.countByCatgo("accounting"));
		model.addAttribute("media", jobRepository.countByCatgo("media"));
		
		return "category";
	}
	
	@GetMapping("/contact")
	public String contactPage() {
		return "contact";
	}
	
	@GetMapping("/jobPost")
	public String jobPostPage(@RequestParam int id, Model model) {
		
		model.addAttribute("job", jobRepository.findById(id));
		System.out.println(jobRepository.findById(id));
		return "jobPost";
		
	}
	
	@GetMapping("/applyJob")
	public String applyJobPage(@RequestParam String jobId,Model model) {
		model.addAttribute("jobId", jobId);
		model.addAttribute("userObj", new User());
		return "resume";
	}
	
	@PostMapping("/applyJob")
	public String applyJob(@RequestParam int jobId,@ModelAttribute User user,Model model) {
		
		boolean isSuccess = userService.applyToJob(user, jobId);
		if(isSuccess) {
			return "redirect:category?isSuccess=1";
		}else {
			return "redirect:category?isSuccess=0";
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
