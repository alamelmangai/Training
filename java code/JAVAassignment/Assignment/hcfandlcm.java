public class HcfAndLcm{
	public static void main(String[] str){
		int a,b,p=6,q=10,t,hcf,lcm;
		a=p;
		b=q;
		while(b != 0){
			t=b;
			b=a % b;
			a=t;}
		hcf = a;
		lcm = (p * q) / hcf;
		System.out.print("HCF = " + hcf);
		System.out.print("\nLCM = " + lcm);
}
}

