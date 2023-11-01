package com.example.demo;

import java.time.LocalDate;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.demo.entity.Customer;
import com.demo.entity.Policy;
import com.demo.service.CustomerService;
import com.demo.service.PolicyService;

@SpringBootApplication
@EnableJpaAuditing
@ComponentScan({ "com.demo" })
@EntityScan(basePackages = { "com.demo.entity" })
@EnableJpaRepositories({ "com.demo.dao" })
public class PolicyManagementApplication {

	static Logger log = Logger.getLogger(PolicyManagementApplication.class.getName());
	
	
	public static void main(String[] args	) {

		ApplicationContext ctx = SpringApplication.run(PolicyManagementApplication.class, args);
		 
		 
		 log.info(" application started");
		
	

		// Task 1 insert customer
		  CustomerService service = ctx.getBean(CustomerService.class);

		
		
		/*
		 * CustomerService service = ctx.getBean(CustomerService.class);
		 * 
		 * 
		 * 
		 * Customer customerdetailsobj = new Customer(); //
		 * //customerdetailsobj.setCustomerId(5); customerdetailsobj.setName("Amra");
		 * customerdetailsobj.setDateOfBirth(LocalDate.of(2010, 9, 9)); // Corrected
		 * customerdetailsobj.setGmail("amra@gmail.com");
		 * customerdetailsobj.setPhoneNumber(890007785);
		 * customerdetailsobj.setCity("chennai");
		 * 
		 * service.insertServiceCustomer(customerdetailsobj);
		 * 
		 */
		  //System.out.println(service.findServiceCustomer(1));
		  //system.out.println(service.findAllServiceCustomer());
		  //service.updateServiceCustomer(customerdetailsobj);
		 
		// ---------------------------------------------------------

		// Task 2 insert policy

		
		
           /*
		 * 
		 * 
		 * PolicyService policyservice = ctx.getBean(PolicyService.class);
		 * 
		 * Policy policydetailsobj = new Policy(); // //
		 * policydetailsobj.setPolicyId(1);
		 * policydetailsobj.setPolicyType("health policy");
		 * policydetailsobj.setPolicyStartDate(LocalDate.of(2002, 3, 9));
		 * policydetailsobj.setPolicyEndDate(LocalDate.of(2006, 9, 19));
		 * 
		 * 
		 * Customer custom = new Customer(); custom.setCustomerId(1l);
		 * 
		 * 
		 * policydetailsobj.setCustomer(custom);
		 * policyservice.insertServicePolicy(policydetailsobj);
		 */
		 
		 
		// System.out.println(policyservice.findServicePolicy(1));
		// policyservice.findAllServicePolicy();
		// policyservice.updateServicePolicy(policydetailsobj);

		// ------------------------------------------------------------------

		// Task 3 inset policy
		
		
		
		/*
		 * Policy c1 = new Policy(); c1.setPolicyType("motorcycle policy");
		 * c1.setPolicyStartDate(LocalDate.of(2002, 3, 9));
		 * c1.setPolicyEndDate(LocalDate.of(2006, 10, 29));
		 * 
		 * Policy c2 = new Policy(); c2.setPolicyType("Term line policy");
		 * c2.setPolicyStartDate(LocalDate.of(2007, 11, 12));
		 * c2.setPolicyEndDate(LocalDate.of(2009, 1, 29));
		 * 
		 * //insert customer Customer cu1 = new Customer(); cu1.setName("Raj");
		 * cu1.setDateOfBirth(LocalDate.of(1999, 12, 10));
		 * cu1.setGmail("Rajamirtha@gmail.com"); cu1.setPhoneNumber(950043876);
		 * cu1.setCity("singapore");
		 * 
		 * //associating claim to customer c1.setCustomer(cu1); c2.setCustomer(cu1);
		 * 
		 * //associating customer with claim List<Policy> cu2 = new ArrayList<Policy>();
		 * cu2.add(c1); cu2.add(c2); cu1.setPolicy(cu2);
		 * 
		 * 
		 * System.out.println("adding customer.......");
		 * 
		 * CustomerService service3 = ctx.getBean(CustomerService.class);
		 * service3.insertServiceCustomer(cu1);
		 * 
		 */

		// ------------------------------------------------------------------------

		// joins process...........
		
		/*
		 * CustomerService service1 = ctx.getBean(CustomerService.class);
		 * 
		 * Customer ser = service1.findServiceCustomer(2l);
		 * System.out.println("customerdetails- " +ser);
		 * 
		 * List<Policy> policyList = ser.getPolicy();
		 * 
		 * System.out.
		 * println("*******************************Printing Policy Type************************************"
		 * ); for (Policy bObj: policyList) { System.out.println("Policy type: "+
		 * bObj.getPolicyType());
		 * 
		 * }
		 */
		 

		// ----------------------------------------------------------------------------

		// propagation

		
		/*
		 * CustomerService svc = ctx.getBean(CustomerService.class); Policy policy = new
		 * Policy(); policy.setPolicyType("life policy");
		 * policy.setPolicyStartDate(LocalDate.of(2009, 5, 30));
		 * policy.setPolicyEndDate(LocalDate.of(2012, 7, 31));
		 * 
		 * Customer customer = new Customer(); customer.setCustomerId(1l);
		 * policy.setCustomer(customer);
		 * 
		 * Customer customer1 = new Customer(); customer1.setName("ram");
		 * customer1.setPhoneNumber(922033455);
		 * customer1.setDateOfBirth(LocalDate.of(2000, 11, 12));
		 * customer1.setCity("mumbai"); customer1.setGmail("ram@gmail.com");
		 * 
		 * svc.transactionalDemo(customer1, policy);
		 */

		// --------------------------------------------------------------------------

		// custom queries

		/*
		 * List<Customer> list = service.findServiceCustomerById(1);
		 * System.out.println("Customer Based on Id--------> " + list);
		 */

		// ------------------------------------------------------------------------
		
		/*
		 * List<Customer> listName = service.findServiceCustomerByName("n");
		 * System.out.println("Customer Based on name--------> " + listName);
		 */
		// -------------------------------------------------------------------------

		/*
		 * List<CustomerCustomized> customerListCustomized =
		 * service.findServiceCustomerByNameCustomized("Raj"); for(CustomerCustomized
		 * custom : customerListCustomized) {
		 * System.out.println("Customer Customized Data--------> " + custom.getName() +
		 * "-" +custom.getCity()); }
		 */
		// ---------------------------------------------------------------------------

		// namedQuery
		  //System.out.println("CUSTOMERDETAILS DATA ORDERBYNAME"+service.findAllOrderByNameDescending());

		// --------------------------------------------------------------------------------

		// Inner Join
		
		/*
		 * List<Customer> customerDetailsList = service.findCustomerWithPolicy();
		 * System.out.println("Customer details with Policy details Inner Join" +
		 * customerDetailsList);
		 */
		// ---------------------------------------------------------------------------------

		// Left outer join
		/*
		 * List<Customer> customerDetailsList1 = service.findCustomerWithPoliciesLeft();
		 * System.out.println("Customer details with Policy details Inner Join" +
		 * customerDetailsList1);
		 * 
		 */

		 
		// -----------------------------------------------------------------------------------

		// Customized join

		/*
		 * List<PolicyCustomized> customerPolicyList =
		 * service.findByCustomerPolicyCustomized();
		 * 
		 * for (PolicyCustomized cus : customerPolicyList) {
		 * System.out.println("customized joined data by using joins ==========> " +
		 * cus.getName() + "-" + cus.getCustomerCity() + "-" + cus.getGmail() + "-" );
		 * 
		 * }
		 */

	}

	}

