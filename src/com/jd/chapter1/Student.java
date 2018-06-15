package com.jd.chapter1;

import java.math.BigDecimal;
import java.util.Date;

public class Student {
	private String name;
	private int age;
	private String school;
	private BigDecimal salary;
	private Integer workHour;
	private BigDecimal  jixiao;
	private BigDecimal high;
	private Date birth;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public BigDecimal getSalary() {
		return salary;
	}
	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
	public Integer getWorkHour() {
		return workHour;
	}
	public void setWorkHour(Integer workHour) {
		this.workHour = workHour;
	}
	public BigDecimal getJixiao() {
		return jixiao;
	}
	public void setJixiao(BigDecimal jixiao) {
		this.jixiao = jixiao;
	}
	public BigDecimal getHigh() {
		return high;
	}
	public void setHigh(BigDecimal high) {
		this.high = high;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
}
