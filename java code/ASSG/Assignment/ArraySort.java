public class ArraySort{
	public static void main(String [] str){
		int a[]={1,2,3,4,5,6,7,8,9};
		int i,j,temp;
		for(i=0;i<a.length;i=i+2){
			for(j=i+1;j<a.length;j++){
				if(a[i]<a[j]){
					temp=a[i];
					a[i]=a[j];
					a[j]=temp;
				}
			}
		}
	        for(i=0;i<a.length;i++)
			System.out.print(a[i]);
	}
}