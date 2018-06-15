public class Occur{
	public static void main(String [] str){
		int []a={1,2,1,3,1,3};
		int []b=new int[a.length];
		int count=0;
       		for (int i = 0;i<a.length;i++)0{
          	  b[i]=a[i];
        	}
		for(int i=0;i<a.length;i++){
		for(int j=0;j<a.length;j++){
			if (a[i]==b[j]){
				count++;
				b[j]=0;
				}	
		}
		if(count>0){
		System.out.println(a[i]+" "+"occurs"+count+"times");
		count=0;
		}
		}	
	}
}