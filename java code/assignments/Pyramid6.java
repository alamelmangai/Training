public class Pyramid6{
	public static void main(String [] str){
		int n=6,c=1,i=1;
  		for(i=1;i<=2*n-1;i++)
		for(int j=c;j<=n;j++){
		System.out.print(" ");}

		for(int k=1;k<=c*2-1;k++){
		System.out.print("*");}
		if(i < n)
			c++;
		else
			c--;
			System.out.println(" ");
	}
}