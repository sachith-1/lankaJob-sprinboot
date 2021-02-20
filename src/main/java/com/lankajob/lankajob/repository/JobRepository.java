package com.lankajob.lankajob.repository;

import com.lankajob.lankajob.entity.Job;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface JobRepository extends JpaRepository<Job,Integer> {
	
	
	 @Query(value = "SELECT * FROM job t WHERE " +
	            "LOWER(t.title) LIKE LOWER(CONCAT('%',:search, '%')) OR " +
	            "LOWER(t.desciption) LIKE LOWER(CONCAT('%',:search, '%')) AND "+
	            "t.catgo=:catgo",
	            nativeQuery = true
	    )
	List<Job> searchJobs(String search,String catgo);
	 
	Job findById(int id);
	
	List<Job> findTop10ByOrderByIdDesc();
	
	List<Job> findByCatgo(String catgo);
	
	int countByCatgo(String catgo);
	
	
	
}
