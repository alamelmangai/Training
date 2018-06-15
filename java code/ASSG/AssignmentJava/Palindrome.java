public class Palindrome{
	public static void main(String [] str){
		int n=12321,sum=0,temp,rem;
		temp=n;
		while(n>0){
		rem=n%10;
		sum=(sum*10)+rem;
		n=n/10;
		}
	if(temp==sum)
		System.out.println("Number is Palindrome");
	else
		System.out.println("Not a Palindrome Number");
	}		
}