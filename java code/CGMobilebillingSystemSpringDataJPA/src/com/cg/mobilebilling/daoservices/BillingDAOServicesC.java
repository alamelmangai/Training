package com.cg.mobilebilling.daoservices;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.mobilebilling.beans.Customer;

public interface BillingDAOServicesC extends JpaRepository<Customer,Integer>{

}
