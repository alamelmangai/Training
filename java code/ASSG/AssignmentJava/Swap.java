public class Swap{
	public static void main(String args[]){ 
		int a =5, b=10; 
		System.out.println("Before Swap a is "+a+" b is "+b); 
		a=a+b; 
		b=a-b; 
		a=a-b; 
		System.out.println("After Swap a is "+a+" b is "+b); 
		}
}