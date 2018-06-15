public class MainClass8{
	public static void main(String[] str){
		int a = 12321, sum=0, n;
		int t = a;
		while(a>0){
		n = a%10;
		sum = (sum*10) + n;
		a = a/10;
		}
	if(t==sum)
	System.out.println("no is a palandrome");
	else
	System.out.println("no is not a palandrome");
		
	}
}
