package org.boot.city.entity;

import java.util.Date;

public class PeopleTable {
	
	private Integer id;
	private String ompName;
	private String sex;
	private Date entryTime;
	private Integer deptId;
	private Integer levelId;
	private String ompNum;
	private Integer rId;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOmpName() {
		return ompName;
	}
	public void setOmpName(String ompName) {
		this.ompName = ompName;
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
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public Integer getLevelId() {
		return levelId;
	}
	public void setLevelId(Integer levelId) {
		this.levelId = levelId;
	}
	public String getOmpNum() {
		return ompNum;
	}
	public void setOmpNum(String ompNum) {
		this.ompNum = ompNum;
	}
	public Integer getrId() {
		return rId;
	}
	public void setrId(Integer rId) {
		this.rId = rId;
	}
	
	

}
