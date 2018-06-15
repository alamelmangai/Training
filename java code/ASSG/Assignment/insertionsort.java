public class InsertionSort{
	public static void main(String[] args){
		int[] arr={10,5,3,4,8,27};
		int temp,n,min,key;
		n=arr.length;
		for(int i=1;i<n;i++){
		System.out.println( i + "  " );
		key=arr[i];
		for(int j=i-1;j>=0;j--){
			if(arr[j]>key){
			arr[j+1]=arr[j];
			arr[j]=key;

}
}			
}
		for(int i=0;i<n;i++)
		System.out.print( arr[i] + "  " );		
}
}