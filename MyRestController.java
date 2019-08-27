package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins="*")
@RestController
@RequestMapping("/bank")
public class MyRestController {
	@Autowired
	TransactionsDao dao;
	
	@GetMapping("/transactions")
	public List<Customer_Transactions> listalltransactions( )
	{
		return dao.findAll();
	}
	@PostMapping("/transactions")
	public String insertTransactionRecord(@RequestBody Customer_Transactions t)
	{
		dao.save(t);
		return "success";
	}
	@DeleteMapping("/transactions/{tid}")
	public String deleteRecord(@PathVariable("tid") int id)
	{
		if(dao.existsById(id))
			dao.deleteById(id);
		else
			return "record does not exist";
		return "Success";
	}
	@GetMapping("/viewtransactions/")
	public List<Customer_Transactions> listtoptransactions( )
	{ 
		return dao.listtop10transactions();
	}
	
}
