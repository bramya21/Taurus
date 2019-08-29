package com.example.demo.controller;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;
import org.mindrot.jbcrypt.BCrypt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.CustomerAccount;
import com.example.demo.model.Customer_Profile;
import com.example.demo.model.ProfileDummy;
import com.example.demo.model.User;
import com.example.demo.repo.AccountRepo;
import com.example.demo.repo.CustomerRepo;
import com.example.demo.repo.PDummyRepo;
import com.example.demo.repo.UserRepo;

@RestController
@RequestMapping(value = "/users")
public class MyController {

	@Autowired
	PDummyRepo drepo;

	@Autowired
	UserRepo repo;

	@Autowired
	AccountRepo accrepo;

	@Autowired
	CustomerRepo custrepo;

	@PostMapping("/login")
	public String login(@RequestBody User user) throws NoSuchAlgorithmException {

		Optional<User> optionalUser = repo.findById(user.getUserId());
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

	@PostMapping("/login1")
	public String login1(@RequestBody User user) throws NoSuchAlgorithmException {

		Optional<User> optionalUser = repo.findById(user.getUserId());
		if (optionalUser.isPresent()) {
			User loggedUser = optionalUser.get();
			/*
			 * if(loggedUser.getPassword().equals(user.getPassword())) return "success";
			 * else return "failure"; } return "failure";
			 */
			/*
			 * String generatedSecuredPasswordHash = BCrypt.hashpw(user.getPassword(),
			 * BCrypt.gensalt(12)); System.out.println(generatedSecuredPasswordHash);
			 */ 

			boolean matched = BCrypt.checkpw(user.getPassword(), loggedUser.getPassword());
			System.out.println(loggedUser.getPassword());
			System.out.println(matched);
		}
		return "failure";
	}

	@PostMapping("/account")
	public ResponseEntity<String> insertEmp(@RequestBody CustomerAccount account) {
		account.setAccno(account.getAccno() + 10000);
		CustomerAccount acc = accrepo.save(account);
		return ResponseEntity.ok("success");
	}

	@PostMapping("/customers")
	public ResponseEntity<String> insertCustomer(@RequestBody Customer_Profile e) {
		// if(dao.existsById(e.getCid()))
		// return "record already exists";
		System.out.println("hello");
		ProfileDummy d = new ProfileDummy();
		drepo.save(d);
		e.setCid("CUST" + d.getId());
		custrepo.save(e);
		return ResponseEntity.ok("success");
	}

	@PostMapping("/account/{aid}")
	public String removeAccount(@PathVariable("aid") int aid) {
		accrepo.deleteById(aid);
		return "deleted successfully";
	}

}
