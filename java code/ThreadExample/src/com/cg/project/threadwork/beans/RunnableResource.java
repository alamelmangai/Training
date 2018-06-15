package com.cg.project.threadwork.beans;

public class RunnableResource implements Runnable {

	@Override
	public void run() {
	Thread t = Thread.currentThread();
	if(t.getName().equals("thread-1")){
		for(int i=0;i<100;i++)
			if(i%2==0)
				System.out.print( i+" " );
	}
			else if(t.getName().equals("thread-0")){
				for(int j=0;j<100;j++)
					if(j%2!=0)
						System.out.print(j+" ");
			}

	}

}
