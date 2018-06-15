public class MainClassa1{
	public static void main(String [] str){
	int num=152,rev=0,num1;
	num1=num;
	while(num>0){
		int rem=num%10;
		num=num/10;
		rev=rev*10+rem;
	}
	if(num1==rev)
		System.out.println("Palindrome");
	else	
		System.out.println("not Palindrome");

	}
}
