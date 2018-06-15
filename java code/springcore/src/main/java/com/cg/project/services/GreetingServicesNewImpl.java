package com.cg.project.services;

import org.springframework.stereotype.Component;

@Component("greetingServices") 
public class GreetingServicesNewImpl implements GreetingServices{
	
	public GreetingServicesNewImpl() {
		System.out.println("This is new implementation file!!!");
	}

	@Override
	public void SayHello(String personName) {
		System.out.println("Hello "+personName);
		
	}

	@Override
	public void SayGoodBye(String personName) {
		System.out.println("GoodBye "+personName);
		
	}

}