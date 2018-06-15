package com.cg.project.services;
import com.cg.project.exceptions.InValidNoRangeException;
public class MathServicesImpl implements MathServices {

	@Override
	public int add(int n1, int n2) throws InValidNoRangeException {
		if(n1<0||n2<0)throw new InValidNoRangeException("Enter valid number");
		return n1+n2;
	}

	@Override
	public int sub(int n1, int n2) throws InValidNoRangeException {
		if(n1<0||n2<0)throw new InValidNoRangeException("Enter valid number");
		return n1-n2;
	}

	@Override
	public int div(int n1, int n2) throws InValidNoRangeException {
		if(n1<0||n2<0)throw new InValidNoRangeException("Enter valid number");
		return n1/n2;
	}

}