package org.boot.city.entity;

import java.util.Date;

public class Task {
	
	private Integer taskId;//数据库中真正id
	private Integer id;
	private Double deep;
	private String site;
	private String faultName;
	private Date collectTime;
	private Date checkTime;
	private Date assignTime;
	private String dealStatus;
	private Integer total;
	private Integer rId;

	public Integer getrId() {
		return rId;
	}
	public void setrId(Integer rId) {
		this.rId = rId;
	}
	public Integer getTaskId() {
		return taskId;
	}
	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getDeep() {
		return deep;
	}
	public void setDeep(Double deep) {
		this.deep = deep;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getFaultName() {
		return faultName;
	}
	public void setFaultName(String faultName) {
		this.faultName = faultName;
	}
	public Date getCollectTime() {
		return collectTime;
	}
	public void setCollectTime(Date collectTime) {
		this.collectTime = collectTime;
	}
	public Date getCheckTime() {
		return checkTime;
	}
	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}
	public Date getAssignTime() {
		return assignTime;
	}
	public void setAssignTime(Date assignTime) {
		this.assignTime = assignTime;
	}
	public String getDealStatus() {
		return dealStatus;
	}
	public void setDealStatus(String dealStatus) {
		this.dealStatus = dealStatus;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	

}
