package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerTransactionDAO extends JpaRepository<CustomerTransaction, Integer> {
	@Query("from CustomerTransaction where fromaccount=?1 ")
	List<CustomerTransaction> findAllById(String id);

}
