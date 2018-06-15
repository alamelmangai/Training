public class Fact{
	public static void main(String [] str){
		int num=4,fact=1;
		while(num>0){
		fact=fact*num;
		num=num-1;
		}
		System.out.print("Factorial is "+fact);
	}
}