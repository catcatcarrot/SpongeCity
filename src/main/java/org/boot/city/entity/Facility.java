package org.boot.city.entity;

import java.util.Date;

public class Facility {
	
	private Integer id;
	private String name;
	private Integer number;
	private String region;
	private String type;
	private String buyMan;
	private Date buyTime;
	private Date dumpTime;
	private Integer status;
	
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
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBuyMan() {
		return buyMan;
	}
	public void setBuyMan(String buyMan) {
		this.buyMan = buyMan;
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
		return "Facility [id=" + id + ", name=" + name + ", buyTime=" + buyTime + ", dumpTime=" + dumpTime + "]";
	}

	
}
