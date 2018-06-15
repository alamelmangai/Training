package com.cg.project.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.cg.project.bean.Address;
import com.cg.project.bean.Associate;

public class MainCLass {

	public static void main(String[] args) {
		ApplicationContext applicationContext =new ClassPathXmlApplicationContext("projectbeans.xml");
		/*Associate associate=(Associate)applicationContext.getBean("associate");
		System.out.println(associate);*/
		Associate associate1=(Associate)applicationContext.getBean("associate");
		Associate associate2=(Associate)applicationContext.getBean("associate");
		if(associate1==associate2)
			System.out.println("Same Reference");
		else
			System.out.println("Different Reference");

		if(associate1.equals(associate2))
			System.out.println("Same Data");
		else
			System.out.println("Different Data");
	}

}
