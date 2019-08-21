package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class MyRestController {
	@Autowired
	CustomerDao dao;
	@GetMapping("/customers/")
	public List<Customer_Profile> getCustomerAll(){
		return dao.findAll();
	}
	@GetMapping("/customers/{cid}")
	public Optional<Customer_Profile> getStudentId(@PathVariable("cid") int cid){
		return dao.findById(cid);
	}
	@PostMapping("/customers/")
	public String insertCustomer(@RequestBody Customer_Profile e) {
		//if(dao.existsById(e.getCid()))
			//return "record already  exists";
	
		dao.save(e);
		return "Success";
	}
	@PutMapping("/customers/")
	public String updateCustomer(@RequestBody Customer_Profile e) {  
	if(dao.existsById(e.getCid()))
		dao.save(e);
	else
		return "record does't exists";
	return "Success";}


@DeleteMapping("/customers/{cid}")
public String removeStudent(@PathVariable("cid") int cid) {
	dao.deleteById(cid);
	return "deleted successfully";
}
	

}
