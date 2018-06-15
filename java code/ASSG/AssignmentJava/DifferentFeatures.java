public class DifferentFeatures{

	public static void main(String[] args) {
		int [] input = {1,2,3,4,5,121,153};
		System.out.print("Input array: ");
		printArray(input);
		System.out.println("\nNumber of even numbers: "+findEven(input));
		System.out.println("Number of odd numbers: "+findOdd(input));
		System.out.println("Number of prime numbers: "+findPrimes(input));
		System.out.println("Number of pallindromes: "+findPallindrome(input));
		System.out.println("Number of armstrong numbers: "+findArmstrong(input));
	}
	public static int findEven(int [] input) {
		int evenNumbers = 0;
		for(int i: input) {
			if(i%2 == 0) 
				evenNumbers++;
		}
		return evenNumbers;
	}
	public static int findOdd(int [] input) {
		int oddNumbers = 0;
		for(int i: input) {
			if(i%2 != 0)
				oddNumbers++;
		}
		return oddNumbers;
	}
	public static int findPallindrome(int [] input) {
		int pallindromes = 0;
		int remainder=0,sum=0,temp=0;
		for (int num : input) {
			if(num>9) {
				remainder = 0;
				sum = 0;
				temp = num;

				while (num > 0) {
					remainder = num % 10;
					sum = (sum * 10) + remainder;
					num = num / 10;
				}
				if (temp == sum) pallindromes++;
			}
		}
		return pallindromes;
	}
	public static int findPrimes(int [] input) {
		int primes = 0;
		int factors = 0;
		for(int num: input) {
			factors = 0;
	        for(int i=2; i<num; i++)
	        {
	            if(num%i == 0)
	                factors++;
	        }
	        if(factors == 0)
	        {
	            primes++;
	        }
		}   
		return primes;
	}
	public static int findArmstrong(int [] input) {
		int armstrongNumbers = 0;
		int c = 0, a = 0, temp = 0;
		for (int num : input) {
			c = 0;
			a = 0;
			temp = num;
			while (num > 0) {
				a = num % 10;
				num = num / 10;
				c = c + (a * a * a);
			}
			if (temp == c)
				armstrongNumbers++;
		}	
		return armstrongNumbers;
	}
	public static void printArray(int [] array) {
		System.out.print("[");
		for(int i=0; i<array.length; i++) {
			System.out.print(array[i]);
			if(i==array.length-1) {
				System.out.print("]");
			}else {
				System.out.print(", ");
			}
		}
	}
}
