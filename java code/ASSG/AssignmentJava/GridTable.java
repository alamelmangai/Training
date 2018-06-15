public class GrisTable{
	public static void main(String [] str){
		for(int i=1;i<=10;i++){
			for( int j=i;j<=i*10;j+=i)
			System.out.print("\t"+j);
			System.out.println("");
		}
	}
}