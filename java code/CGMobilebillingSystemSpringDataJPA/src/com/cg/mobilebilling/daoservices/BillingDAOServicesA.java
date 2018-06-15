package com.cg.mobilebilling.daoservices;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.mobilebilling.beans.PostpaidAccount;

public interface BillingDAOServicesA extends JpaRepository<PostpaidAccount,Long>{

}
