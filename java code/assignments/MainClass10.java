public class MainClass10{
 	public static void main(String[]str){
		int temp; 
		for (int i = 0; i < total; i++){ 
		for (int j = i + 1; j < total; j++){ 
		if (a[i] > a[j]){ 
		temp = a[i]; 
		a[i] = a[j]; 
		a[j] = temp;} 
		} 
		} 
		return a[total-3];} 
		public static void main(String[]str){ 
		int a[]={1,2,4,8,9,2}; 
		int b[]={44,99,77,33,22,55,88}; 
		System.out.println("Third Largest: "+getThirdLargest(a,6));
		System.out.println("Third Largest: "+getThirdLargest(b,7));}
	}