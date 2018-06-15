package test;

public class Question23 {
	
	public static void main(String args[]) {
		int [] inputArray= {1,2,3,4,5,6,7,8,9,10};
		int [] convertedArray = halfStraightHalfReverse(inputArray);
		System.out.print("Input array: ");
		printArray(inputArray);
		System.out.print("\nConverted Array: ");
		printArray(convertedArray);
	}
	
	public static int[] halfStraightHalfReverse(int [] input) {
		int [] convertedArray = new int[input.length];
		int leftMost = 0;
		int rightMost = input.length-1;
		
		for(int i=0; i<input.length; i++) {
			if(i%2==0) {
				convertedArray[i] = input[rightMost];
				rightMost--;
			}else {
				convertedArray[i] = input[leftMost];
				leftMost++;
			}
		}
		return convertedArray;
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
