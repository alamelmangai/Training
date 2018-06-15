public class Fibonacci{
	public static void main(String [] str){
		int num=20,n1=0,n2=1,sum;
		System.out.print("0 1 ");
			for(int i=2;i<=20;i++){
				sum=n1+n2;
				System.out.print(sum+" ");
				n1=n2;
				n2=sum;
			}
	}
}