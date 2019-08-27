package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerAccountDAO extends JpaRepository<CustomerAccount, String>{

	@Query("from CustomerAccount where cid=?1")
	public List<CustomerAccount> getById(int cid);
	
}
