public class BinToDec{
	public static void main(String [] str){
		int bin=1011,dec=0,r,i=1;
		while(bin>0){
		r=bin%10;
		dec=dec+r*i;
		bin=bin/10;
		i=i*2;
		}
		System.out.println(dec);
	}
}