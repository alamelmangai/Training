public class DecToBin{
	public static void main(String [] str){
		int bin=0,dec=11,q,r=0,k=0,rev=0;
		q=dec;
		while(q>0){
		r=q%2;
		q=q/2;
		bin=bin*10+r;
		}
		if(dec%2==0){
		bin=bin*10;
		}
		while(bin>0){
		k=bin%10;
		rev=(rev*10)+k;
		bin=bin/10;
		}
		System.out.println(rev);
	}
}