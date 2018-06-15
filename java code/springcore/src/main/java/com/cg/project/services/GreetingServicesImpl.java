package com.cg.project.services;

public class GreetingServicesImpl implements GreetingServices{

	/*public GreetingServicesImpl(String str) {
	}*/

	@Override
	public void SayHello(String personName) {
		System.out.println("Hello "+personName);
		
	}

	@Override
	public void SayGoodBye(String personName) {
		System.out.println("GoodBye "+personName);
		
	}

}
