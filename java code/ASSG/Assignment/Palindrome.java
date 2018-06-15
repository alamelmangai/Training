public class Palindrome{
	public static void main(String [] str){
		int num=121,rev=0,k=0,temp;
		temp=num;
		for(int i=3;i>0;i--){
		k=temp%10;
		rev=(rev*10)+k;
		temp=temp/10;
		}
		if(num==rev)
		System.out.println(num+" is palindrome");
		else
		System.out.print(num+" is not palindrome");
	}
}