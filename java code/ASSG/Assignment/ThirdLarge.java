public class ThirdLarge{
	public static void main(String [] str){
		int []a={1,2,3,4,5,6};
		int temp=0;
		for(int i=0;i<a.length;i++){
		for(int j=0;j<a.length;j++){
		if(a[i]>a[j]){
			temp=a[i];
			a[i]=a[j];
			a[j]=temp;
			}
			}	
		}
		System.out.print(a[2]);
	}
}