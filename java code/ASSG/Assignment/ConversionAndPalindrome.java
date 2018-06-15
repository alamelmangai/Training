public class ConversionAndPalindrome{
	public static void main(String[] str){
		int k=9,rem=0,r1=0,i=1,b=0,n=1,rev=0;
		while(k>0){
			rem=k%2;
			k=k/2;
			b=b+rem*i;
			i=i*10;
			}
		System.out.println(b);
		n=b;
	while(n>0){
			r1=n%10;
			rev=rev*10+r1;
			n=n/10;	
		}
		System.out.println(rev);
		if(b == rev)
			System.out.println("is a palindrome");
		else
			System.out.println("is not a palindrome");
			
	}
}