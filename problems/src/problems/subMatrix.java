package problems;

public class subMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int mat[][] = {{1,2,34,6},{5,3,8,1,2},{4,6,7,5,5},{2,4,8,9,4,}}; 	
		subMatrixSum(mat);

	}
	
	
	public static void subMatrixSum(int[][] mat){
		int m = mat.length;
		int n = mat[0].length;
		int[][] auxMat = new int[m][n];
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;i++) {
				auxMat[i][j] = mat[]
			}
		}
		
	}
	
}
