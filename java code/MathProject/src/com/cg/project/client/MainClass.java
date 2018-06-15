package com.cg.project.client;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.cg.project.exceptions.InValidNoRangeException;
import com.cg.project.services.MathServices;
import com.cg.project.services.MathServicesImpl;

public class MainClass {

	public static void main(String[] args) throws InValidNoRangeException, FileNotFoundException, IOException {
		MathServices mathServices = new MathServicesImpl();
		Properties pro=new Properties();
		pro.load(new FileInputStream(new File("d:\\Math.properties")));
		int x=Integer.parseInt(pro.getProperty("x"));
		int y=Integer.valueOf(pro.getProperty("y"));
		System.out.println(mathServices.add(y,x));
	}

}
