public class EvenOdd{ 
	public static void main(String args[]){ 
		int [] m={1,2,3,4,5}; 
		for(int i=0;i<m.length();i++){ 
				if(m[i]%2 == 0)
					System.out.println("Odd "+m[i]);  
				else 
					System.out.println("Even "+m[i]); 
		} 
	} 
} 