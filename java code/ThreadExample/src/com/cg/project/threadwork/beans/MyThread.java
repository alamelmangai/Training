package com.cg.project.threadwork.beans;

public class MyThread extends Thread{

	public MyThread() {
		super();
	}

	public MyThread(String name) {
		super(name);
	}
	public void run(){
		if(this.getName().equals("thread-1")){
			for(int i=0;i<100;i++)
				if(i%2==0)
					System.out.print( i+" " );
		}
				else if(this.getName().equals("thread-0")){
					for(int j=0;j<100;j++)
						if(j%2!=0)
							System.out.print(j+" ");
				}

	}

}
