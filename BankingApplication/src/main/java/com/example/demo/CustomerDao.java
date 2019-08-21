package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDao extends JpaRepository<Customer_Profile,Integer> {

}
