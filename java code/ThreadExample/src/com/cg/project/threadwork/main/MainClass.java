package com.cg.project.threadwork.main;

import com.cg.project.threadwork.beans.MyThread;
import com.cg.project.threadwork.beans.RunnableResource;

public class MainClass {

	public static void main(String[] args)/*throws InterruptedException */{/*
		MyThread th1 = new MyThread("thread-1");
		MyThread th2 = new MyThread("thread-0");
		th1.start();
		th2.start();*/
		RunnableResource resource = new RunnableResource();
		Thread th1 = new Thread(resource,"thread-1");
		Thread th2 = new Thread(resource,"thread-0");
		th1.start();
		//th1.join();
		th2.start();
	}

}
