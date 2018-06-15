import java.util.InputMismatchException;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter Number:");
			int n1=scanner.nextInt();
			System.out.println("Enter Number:");
			int n2=scanner.nextInt();
			System.out.println(n1/n2);
			System.out.println("Arithmetic task complete here");
		}
		catch (InputMismatchException e) {
			e.printStackTrace();
			System.out.println("enter only Integer");
		}
		catch (ArithmeticException e) {
			e.printStackTrace();
			System.out.println("enter second number greater than zero");
		}
		 catch (Exception e) {
			 e.printStackTrace();
		}
		System.out.println("code after try catch block");
	}

}
