package problems;

public class matrixChainOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static int matrixMultOperations(int[] arr, int k, int j) {
		if(k==j)
			return 0;
		
		int min = Integer.MAX_VALUE;
		
		for(int i = k;i<=j;i++) {
			int count = matrixMultOperations(arr,k,i)+matrixMultOperations(arr,i+1,j)+arr[k-1]*arr[i]*arr[j];
		}
		
		return 0;
	}
}
