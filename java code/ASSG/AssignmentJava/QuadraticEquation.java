public class QuadraticEquation{
	public static void main(String[] args){
		int a=2, b=3, c=1;
		double root1, root2, d;
		System.out.println("Quadratic equation: "+a+"x^2 + "+b+"x + "+c);
		d = b * b - 4 * a * c;
		if(d > 0){
			System.out.println("Roots are real and unequal");
			root1 = ( - b + Math.sqrt(d))/(2*a);
			root2 = (-b - Math.sqrt(d))/(2*a);
			System.out.println("Root one:"+root1);
			System.out.println("Root two:"+root2);
		}
		else if(d == 0){
			System.out.println("Roots are real and equal");
			root1 = (-b+Math.sqrt(d))/(2*a);
			System.out.println("Root:"+root1);
		}
		else{
			System.out.println("Roots are imaginary");
		}
	}
}