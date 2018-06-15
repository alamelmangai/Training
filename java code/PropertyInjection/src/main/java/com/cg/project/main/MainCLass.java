package com.cg.project.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.cg.project.bean.Address;
import com.cg.project.bean.Associate;

public class MainCLass {

	public static void main(String[] args) {
		ApplicationContext applicationContext =new ClassPathXmlApplicationContext("projectbeans.xml");

		Associate associate=(Associate)applicationContext.getBean("associate");
		System.out.println(associate);
	}

}
