public class HCFLCM{
	public static void main(String[] args) {
		int firstNumber = 4;
		int secondNumber = 9;
		System.out.println("Input numbers: "+firstNumber+", "+secondNumber);
		System.out.println("LCM is: "+findLCM(firstNumber, secondNumber));
		System.out.println("HCF is: "+findHCF(firstNumber, secondNumber));
	}
	public static int findLCM(int n, int m) {
		int lcm = n > m ? n : m;
		while(true) {
			if( lcm % n == 0 && lcm % m == 0 )
            {
                break;
            }
            ++lcm;
		}
		return lcm;
	}
	public static int findHCF(int n, int m) {
		int hcf = 0;
		for(int i = 1; i <= n && i <= m; ++i)
        {
            if(n % i==0 && m % i==0)
                hcf = i;
        }
		return hcf;
	}
}