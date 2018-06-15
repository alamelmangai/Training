package com.cg.project.services;
import com.cg.project.exceptions.InValidNoRangeException;
public interface MathServices {
	public abstract int add(int n1,int n2)throws InValidNoRangeException;
	abstract int sub(int n1,int n2)throws InValidNoRangeException;
	int div(int n1,int n2)throws InValidNoRangeException;
}
