package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer_Profile {
	@Id
	private int cid;
	private String cname;
	private String phoneno;
	private String mailid;
	private String address;
	private String adharno;
	private int uid;
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public String getMailid() {
		return mailid;
	}
	public void setMailid(String mailid) {
		this.mailid = mailid;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAdharno() {
		return adharno;
	}
	public void setAdharno(String adharno) {
		this.adharno = adharno;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	@Override
	public String toString() {
		return "Customer_Profile [cid=" + cid + ", cname=" + cname + ", phoneno=" + phoneno + ", mailid=" + mailid
				+ ", address=" + address + ", adharno=" + adharno + ", uid=" + uid + "]";
	}
	
	
}
