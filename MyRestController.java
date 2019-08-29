package com.example.demo;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

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
	@Autowired
	UserDAO udao;
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
	@PostMapping("/login")
	public String login(@RequestBody User user) throws NoSuchAlgorithmException {

		Optional<User> optionalUser = udao.findById(user.getUserId());
		if (optionalUser.isPresent()) {
			User loggedUser = optionalUser.get();
			/*
			 * if(loggedUser.getPassword().equals(user.getPassword())) return "success";
			 * else return "failure"; } return "failure";
			 */

			MessageDigest md = MessageDigest.getInstance("MD5");

			// digest() method is called to calculate message digest
			// of an input digest() return array of byte
			byte[] messageDigest = md.digest(user.getPassword().getBytes());

			// Convert byte array into signum representation
			BigInteger no = new BigInteger(1, messageDigest);

			// Convert message digest into hex value
			String hashtext = no.toString(16);
			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			System.out.println(hashtext);
			if (hashtext.equals(loggedUser.getPassword()))
				return "success";
			return "failure";
		}
		return "failure";
	}
	}
