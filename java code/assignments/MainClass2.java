public class MainClass2{

	public static void main(String[] args) {
		int min = 111;
		int max = 222;
		int evenIndex = 0;
		int oddIndex = 0;
		int even[] = new int[(max-min)/2+1];
		int odd[] = new int[(max-min)/2+1];
		for(int i=min; i<=max; i++) {
			if(i%2 == 0) {
				even[evenIndex++] = i;
			}else {
				odd[oddIndex++] = i;
			}
		}
		
		System.out.print("Even numbers: ");
		printArray(even);
		System.out.print("Odd numbers: ");
		printArray(odd);
		
		
	}
	public static void printArray(int [] array) {
		System.out.print("[");
		for(int i=0; i<array.length; i++) {
			System.out.print(array[i]);
			if(i==array.length-1) {
				System.out.println("]");
			}else {
				System.out.print(", ");
			}