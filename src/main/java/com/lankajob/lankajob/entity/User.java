package com.lankajob.lankajob.entity;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String fName;
    private String lName;
    private String email;
    private String phone;
    private String address;
    private String about;
    private String school;
    private String yearsSchool;
    private String exam;
    private String uni;
    private String degree;
    private String cls;//class
    private String post1;
    private String comapny1;
    private String fromto1;
    private String post2;
    private String company2;
    private String fromto2;

    @OneToMany(mappedBy = "user")
    private List<UserJob> userJob = new ArrayList<>();
    

    public User() {
    }

    public User(String fName, String lName, String email, String phone, String address, String about, String school, String yearsSchool, String exam, String uni, String degree, String cls, String post1, String comapny1, String fromto1, String post2, String company2, String fromto2) {
        this.fName = fName;
        this.lName = lName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.about = about;
        this.school = school;
        this.yearsSchool = yearsSchool;
        this.exam = exam;
        this.uni = uni;
        this.degree = degree;
        this.cls = cls;
        this.post1 = post1;
        this.comapny1 = comapny1;
        this.fromto1 = fromto1;
        this.post2 = post2;
        this.company2 = company2;
        this.fromto2 = fromto2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getYearsSchool() {
        return yearsSchool;
    }

    public void setYearsSchool(String yearsSchool) {
        this.yearsSchool = yearsSchool;
    }

    public String getExam() {
        return exam;
    }

    public void setExam(String exam) {
        this.exam = exam;
    }

    public String getUni() {
        return uni;
    }

    public void setUni(String uni) {
        this.uni = uni;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getCls() {
        return cls;
    }

    public void setCls(String cls) {
        this.cls = cls;
    }

    public String getPost1() {
        return post1;
    }

    public void setPost1(String post1) {
        this.post1 = post1;
    }

    public String getComapny1() {
        return comapny1;
    }

    public void setComapny1(String comapny1) {
        this.comapny1 = comapny1;
    }

    public String getFromto1() {
        return fromto1;
    }

    public void setFromto1(String fromto1) {
        this.fromto1 = fromto1;
    }

    public String getPost2() {
        return post2;
    }

    public void setPost2(String post2) {
        this.post2 = post2;
    }

    public String getCompany2() {
        return company2;
    }

    public void setCompany2(String company2) {
        this.company2 = company2;
    }

    public String getFromto2() {
        return fromto2;
    }

    public void setFromto2(String fromto2) {
        this.fromto2 = fromto2;
    }
    

    public List<UserJob> getuserJob() {
		return userJob;
	}

	public void setuserJob(List<UserJob> userJob) {
		this.userJob = userJob;
	}

	@Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", address='" + address + '\'' +
                ", about='" + about + '\'' +
                ", school='" + school + '\'' +
                ", yearsSchool='" + yearsSchool + '\'' +
                ", exam='" + exam + '\'' +
                ", uni='" + uni + '\'' +
                ", degree='" + degree + '\'' +
                ", cls='" + cls + '\'' +
                ", post1='" + post1 + '\'' +
                ", comapny1='" + comapny1 + '\'' +
                ", fromto1='" + fromto1 + '\'' +
                ", post2='" + post2 + '\'' +
                ", company2='" + company2 + '\'' +
                ", fromto2='" + fromto2 + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return id == user.id;

    }

    @Override
    public int hashCode() {
        return id;
    }
}
