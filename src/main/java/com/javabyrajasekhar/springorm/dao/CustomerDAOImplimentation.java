package com.javabyrajasekhar.springorm.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.javabyrajasekhar.springorm.entity.Customer;

@Repository
public class CustomerDAOImplimentation implements CustomerDAO {

	@Autowired
	HibernateTemplate hibernateTemplate;

	@Override
	public List<Customer> getCustomers() {

		return hibernateTemplate.loadAll(Customer.class);
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		hibernateTemplate.persist(theCustomer);
	}

	@Override
	public Customer getCustomer(int theId) {
		return hibernateTemplate.get(Customer.class, theId);

	}

	@Override
	public void deleteCustomer(int theId) {
		Customer customer = hibernateTemplate.get(Customer.class, theId);
		if (null != customer) {
			hibernateTemplate.delete(customer);
			System.out.println("deleted customer succesfully " + theId);
		} else {
			System.out.println(" customer not found - " + theId);
		}

	}

}
