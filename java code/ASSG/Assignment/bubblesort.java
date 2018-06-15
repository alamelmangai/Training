public class BubbleSort{
	public static void main(String[] args){
		int[] arr={10,5,3,4,8,27};
		int temp,n;
		n=arr.length;
		for(int i=0;i<n;i++){
		for(int j=0;j<n-1;j++){
			if(arr[j]>arr[j+1]){
			temp=arr[j];
			arr[j]=arr[j+1];
			arr[j+1]=temp;
}
}			
}
		for(int i=0;i<n;i++)
		System.out.print( arr[i] + "  " );		
}
}