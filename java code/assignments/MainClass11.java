public class MainClass11{

	public static void main(String[] args) {
		int [] input = {1, 12, 13, 2, 333, 444, 555, 666,8};
		categorizeArray(input);

	}
	
	public static void categorizeArray(int [] input) {
		int oneDigitNumbers = 0;
		int twoDigitNumbers = 0;
		int threeDigitNumbers = 0;
		
		for(int i: input) {
			if(i>=0 && i<10) {
				oneDigitNumbers++;
			}else if(i>=10 && i<100) {
				twoDigitNumbers++;
			}else if(i>=100 && i<1000) {
				threeDigitNumbers++;
			}
		}
		
		System.out.println("One digit numbers: "+oneDigitNumbers);
		System.out.println("Two digit numbers: "+twoDigitNumbers);
		System.out.println("Three digit numbers: "+threeDigitNumbers);
	}

}
