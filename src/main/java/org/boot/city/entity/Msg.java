package org.boot.city.entity;

import java.util.ArrayList;
import java.util.List;

public class Msg {
	
	//状态码  0-成功  !0-失败
	private int code;
	private String msg;
	private long count;
	List data=new ArrayList<>();
	
	public static Msg success() {
		Msg result = new Msg();
		result.setCode(0);
		result.setMsg("处理成功");
		return result;
	}
	
	public static Msg fail() {
		Msg result = new Msg();
		result.setCode(1);
		result.setMsg("处理失败");
		return result;
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
	public List getData() {
		return data;
	}
	public void setData(List data) {
		this.data = data;
	}
	
	

}
