public class Armstrong{
	public static void main(String[] str){
		int num=371,i,arm=0,temp;
		temp=num;
		while(temp!=0){
		i=temp%10;
		arm=i*i*i+arm;
		temp=temp/10;
		}
		while(temp!=0){
		i=temp%10;
		arm=i*i*i+arm;
		temp=temp/10;
		}
		if(num==arm)
		System.out.print(num+" is armstrong number");
		else
		System.out.println(num+" is not armstrong number");
	}
}