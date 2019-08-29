package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4300")
@RequestMapping("/rest")
public class MyRestController {
	@Autowired
	CustomerAccountDAO cadao;
	@Autowired
	CustomerTransactionDAO ctdao;
	
	/**************************
	 * Account related rest api
	 **************************/
	@GetMapping("/accounts")
	public List<CustomerAccount> getAccounts(){
		return cadao.findAll();
	}
	@GetMapping("/accounts/{cid}")
	public List<CustomerAccount> getAccountById(@PathVariable("cid") int cid){
		return cadao.getById(cid);
		
	}
	@PostMapping("/accounts")
	public CustomerAccount saveAccount(@RequestBody CustomerAccount ac){
		return cadao.save(ac);
	}
	@DeleteMapping("/accounts/{accno}")
	public String deleteCustomerAccount(@PathVariable("accno") String id) {
		System.out.println(id);
		cadao.deleteById(id);
	return "delete ";
	}

	/******************************
	 * Transaction related rest api
	 ******************************/
	
	@GetMapping("/transaction/{from}")
	public List<CustomerTransaction> getTransactionById(@PathVariable("from") String id){
		return ctdao.findAllById(id);
	}
	@PostMapping("/transaction")
	public String saveTransaction(@RequestBody CustomerTransaction ct) {
		ctdao.save(ct);
		return "success";
	}
	@PutMapping("/transaction")
	public String insertTransaction(@RequestBody CustomerTransaction ct) {
		System.out.print("working");
		ctdao.save(ct);
		return "success";
	}
	}
