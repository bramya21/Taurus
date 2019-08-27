package com.example.demo;


import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id; 

@Entity
public class CustomerTransaction {
	@Id
	int tid;
	String fromaccount;
	String toaccount;
	Date transactiondate;
	double amounttransffered;
	public double getAmmouttransffered() {
		return amounttransffered;
	}
	public void setAmmouttransffered(double amounttransffered) {
		this.amounttransffered = amounttransffered;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getFromaccount() {
		return fromaccount;
	}
	public void setFromaccount(String fromaccount) {
		this.fromaccount = fromaccount;
	}
	public String getToaccount() {
		return toaccount;
	}
	public void setToaccount(String toaccount) {
		this.toaccount = toaccount;
	}
	public Date getTransactiondate() {
		return transactiondate;
	}
	public void setTransactiondate(Date transactiondate) {
		this.transactiondate = transactiondate;
	}
}
