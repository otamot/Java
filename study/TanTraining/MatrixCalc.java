
public class MatrixCalc {
	static double[][] multi(double[][] A,double[][] B){
		double[][] ans = new double[A.length][B[0].length];
		for(int i = 0; i < A.length; i++){
			for(int j = 0; j <B[0].length; j++){
				ans[i][j]=0;
				for(int k = 0;k < A[i].length; k++){
					ans[i][j] += A[i][k]*B[k][j];
				}
			}
		}
		return ans;
	}

	static void printMatrix(double[][] A){
		for(int i = 0; i < A.length; i++){
			for(int j = 0; j < A[i].length; j++){
				System.out.print(A[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public static void main(String[] args){
		double a[][] = {{1,2},{2,3}};
		double b[][] = {{2,3},{4,5}};
		printMatrix(multi(a,b));
		System.out.println();

		double c[][] = {{1},{2}};
		double d[][] = {{2}};
		printMatrix(multi(c,d));
		System.out.println();

		double e[][] = {{1},{2},{3}};
		double f[][] = {{3,4,5}};
		printMatrix(multi(e,f));
		System.out.println();

		double g[][] = {{10}};
		double h[][] = {{200}};
		printMatrix(multi(g,h));
		System.out.println();
	}
}
