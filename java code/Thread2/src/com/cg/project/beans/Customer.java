package com.cg.project.beans;
import com.cg.project.beans.Account;
public class Customer implements Runnable {
	public Customer(){}
	private static Account account;
	static{
		account = new Account(10000);
		System.out.println("Initial Balance :-"+account.getBalance()+"\n\n=====================");

	}
	@Override
	public void run() {
		Thread customerThread = Thread.currentThread();
		/*synchronized (account) {
			
		}*/
		if(customerThread.getName().equals("rahul")){
			for(int i=1;i<=10;i++){
				try{
					Thread.sleep(500);
					System.out.println("\nRahul has call withdraw()"+i+"time balance:+"+account.withdraw(3000));
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}
		}
		if(customerThread.getName().equals("anil")){
			for(int i=1;i<=10;i++){
				try{
					Thread.sleep(500);
					System.out.println("\nAnil has call deposit()"+i+"time balance:+"+account.deposit(3000));
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}
		}
		if(customerThread.getName().equals("aishu")){
			for(int i=1;i<=10;i++){
				try{
					Thread.sleep(500);
					System.out.println("\nAishu has call checkBalance()"+i+"time balance:+"+account.getBalance());
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}
		}
	}
}