public class MatrixMultiplication{
	public static void main(String [] arg){
		int a[][]={{1,1},{2,2}};
		int b[][]={{2,2},{3,3}};
		int c[][]=new int[2][2];	
		for(int i=0;i<2;i++){
			for(int j=0;j<2;j++){
				c[i][j]=0;
				for(int k=0;k<2;k++)
				c[i][j]+=a[i][k]*b[k][j];
				System.out.print(c[i][j]+" ");
			}
			System.out.println("");
		}
	}	
}