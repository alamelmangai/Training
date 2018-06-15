public class SelectionSort{
	public static void main(String[] args){
		int[] arr={10,5,3,4,8,27};
		int temp,n,min;
		n=arr.length;
		for(int i=0;i<n;i++){
		min=arr[i];
		for(int j=i+1;j<n-1;j++){
			if(arr[j]<arr[i]){
			temp=arr[j];
			arr[j]=arr[i];
			arr[i]=temp;
}
}			
}
		for(int i=0;i<n;i++)
		System.out.print( arr[i] + "  " );		
}
}