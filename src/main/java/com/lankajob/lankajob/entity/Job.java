package com.lankajob.lankajob.entity;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String title;
    private String catgo;
    private int salary;
    private String location;
    private String exdate;
    private String desciption;

    @OneToMany(mappedBy = "job")
    private List<UserJob> userJob = new ArrayList<>();

    public Job() {
    }

    public Job(String title, String catgo, int salary, String location, String exdate, String desciption) {
        this.title = title;
        this.catgo = catgo;
        this.salary = salary;
        this.location = location;
        this.exdate = exdate;
        this.desciption = desciption;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCatgo() {
        return catgo;
    }

    public void setCatgo(String catgo) {
        this.catgo = catgo;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getExdate() {
        return exdate;
    }

    public void setExdate(String exdate) {
        this.exdate = exdate;
    }

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }
    

    public List<UserJob> getUserJob() {
		return userJob;
	}

	public void setUserJob(List<UserJob> userJob) {
		this.userJob = userJob;
	}

	@Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", catgo='" + catgo + '\'' +
                ", salary=" + salary +
                ", location='" + location + '\'' +
                ", exdate=" + exdate +
                ", desciption='" + desciption + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Job jobs = (Job) o;

        return id == jobs.id;

    }

    @Override
    public int hashCode() {
        return id;
    }
}
