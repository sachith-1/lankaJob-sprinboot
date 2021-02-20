package com.lankajob.lankajob.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lankajob.lankajob.entity.UserJob;

@Repository
public interface UserJobRepository extends JpaRepository<UserJob, Integer> {
	
	int countByStatus(int status);
	
//	select applicants.appID,fname,lname,title,status from applicants,jobs,appliedjobs where applicants.appID=appliedjobs.appID and jobs.jobID=appliedjobs.appID ORDER BY ajID DESC
	
	
	@Query(value="select * from user,job,user_job where user.id=user_job.user_id and job.id=user_job.job_id ORDER BY user_job.id DESC",nativeQuery = true)	
	List<UserJob> newApplicants();
	
	UserJob findByUserId(int id);

}
