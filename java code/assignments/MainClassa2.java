public class MainClassa2{
	public static void main(String [] str){
		int num=113,sum=0,num1,rev;
		num1=num;
		while(num>0){
			int rem=num%10;
			num=num/10;
			rev=rem*rem*rem;
			sum=sum+rev;
		}
		if(num1==sum)
			System.out.println("armstrong");
		else	
			System.out.println("not armstrong");
	
	}
}
