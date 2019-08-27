/**
 * 
 */
package com.example.demo;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author Abridge Solutions
 *
 */
public interface TransactionsDao extends JpaRepository<Customer_Transactions, Integer> {

	@Query(value="select * from Customer_Transactions limit 10",nativeQuery=true)
	public List<Customer_Transactions> listtop10transactions( );
}
