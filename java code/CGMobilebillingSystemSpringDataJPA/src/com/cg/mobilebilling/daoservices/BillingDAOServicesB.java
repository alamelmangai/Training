package com.cg.mobilebilling.daoservices;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.mobilebilling.beans.Bill;


public interface BillingDAOServicesB extends JpaRepository<Bill,Integer>{

}
