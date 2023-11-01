package com.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;

import com.demo.entity.Customer;

@Repository
public interface CustomerRespository extends JpaRepository<Customer, Long> {

	//by Id
	@Query(value = "select c from Customer c where c.customerId> :customerId1")
	List<Customer> findCustomerById(@Param("customerId1") long customerId);//byId

	//by Name
	@Query("select c from Customer c where c.name LIKE %:name1%")
	List<Customer> findCustomerByName(@Param("name1") String name);//byName

	// fetches only few columns from customer details
	@Query("select c.city as city,c.name as name from Customer c where c.name=:name1")
	List<CustomerCustomized> findByCustomerNameCustomized(@Param("name1") String name);//customized

	// namedQuery
	List<Customer> findAllOrderByNameDescending();//descending order

	// Inner Join
	@Query("SELECT c FROM Customer c JOIN c.policy")
	List<Customer> findCustomerWithPolicy(); //inner join

	// Left outer join
	@Query("SELECT c fROM Customer c LEFT JOIN c.policy p")
	List<Customer> findCustomerWithPoliciesLeft();//left join

	// Customized data by join
	@Query("SELECT c.name as name,c.city as customerCity,c.gmail as gmail FROM Customer c JOIN c.policy p")
	List<PolicyCustomized> findByCustomerPolicyCustomized();//customized join

}