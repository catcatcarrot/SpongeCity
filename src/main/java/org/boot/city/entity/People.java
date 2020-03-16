package org.boot.city.entity;

import java.util.Date;

public class People {
	
	private Integer id;
	private String name;
	private String sex;
	private Date entryTime;
	private String deptName;
	private String levelName;
	private String number;
	private String region;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getEntryTime() {
		return entryTime;
	}
	public void setEntryTime(Date entryTime) {
		this.entryTime = entryTime;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getLevelName() {
		return levelName;
	}
	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	@Override
	public String toString() {
		return "People [id=" + id + ", name=" + name + ", sex=" + sex + ", entryTime=" + entryTime + ", deptName="
				+ deptName + ", levelName=" + levelName + ", number=" + number + ", region=" + region + "]";
	}
	
	

}
