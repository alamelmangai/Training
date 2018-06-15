public class MainClassa9{
	public static void main(String [] str){
	int a=1,b=4,c=3,d;
        float x,y;
	System.out.println("Quadratic eq is "+ a+"x^2+"+b+"x+"+c+"=0");
	d=((b^2)-(4*a*c))^(1/2);
	x=(-b+d)/(2*a);
	y=(-b-d)/(2*a);
	System.out.println("roots are "+x+" "+y);
	}
	}
