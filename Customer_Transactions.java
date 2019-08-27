package com.example.demo;




import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Customer_Transactions {
	@Id
	@GeneratedValue
	int tid;
	String fromaccno;
	String toaccno;
	@Column
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date date=new Date();
	double amttransfer;
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getFromaccno() {
		return fromaccno;
	}
	public void setFromaccno(String fromaccno) {
		this.fromaccno = fromaccno;
	}
	public String getToaccno() {
		return toaccno;
	}
	public void setToaccno(String toaccno) {
		this.toaccno = toaccno;
	}
	public Date getDate(Date date) {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getAmttransfer() {
		return amttransfer;
	}
	public void setAmttransfer(double amttransfer) {
		this.amttransfer = amttransfer;
	}
	
}
