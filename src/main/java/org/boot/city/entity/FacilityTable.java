package org.boot.city.entity;

import java.util.Date;

public class FacilityTable {
	
	private Integer id;
	private String fcName;
	private Integer fcNum;
	private Integer rId;
	private Integer tId;
	private String person;
	private Date buyTime;
	private Date dumpTime;
	private Integer status;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFcName() {
		return fcName;
	}
	public void setFcName(String fcName) {
		this.fcName = fcName;
	}
	public Integer getFcNum() {
		return fcNum;
	}
	public void setFcNum(Integer fcNum) {
		this.fcNum = fcNum;
	}
	public Integer getrId() {
		return rId;
	}
	public void setrId(Integer rId) {
		this.rId = rId;
	}
	public Integer gettId() {
		return tId;
	}
	public void settId(Integer tId) {
		this.tId = tId;
	}
	public String getPerson() {
		return person;
	}
	public void setPerson(String person) {
		this.person = person;
	}
	public Date getBuyTime() {
		return buyTime;
	}
	public void setBuyTime(Date buyTime) {
		this.buyTime = buyTime;
	}
	public Date getDumpTime() {
		return dumpTime;
	}
	public void setDumpTime(Date dumpTime) {
		this.dumpTime = dumpTime;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "FacilityTable [id=" + id + ", fcName=" + fcName + ", fcNum=" + fcNum + ", rId=" + rId + ", tId=" + tId
				+ ", person=" + person + ", buyTime=" + buyTime + ", dumpTime=" + dumpTime + ", status=" + status + "]";
	}
	
	
}
