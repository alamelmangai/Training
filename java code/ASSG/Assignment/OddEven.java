public class OddEven{
	public static void main(String [] args){
		int a=1,b=30,i;
		i=a;
		System.out.print("Even: ");
		while(i<b){
		if(i%2==0)
			System.out.print(i+" ");
		i++;
		}
		i=a;
		System.out.print("Odd: ");
		while(i<b){
		if(i%2!=0)
			System.out.print(i+" ");
		i++;
		}

	}
}