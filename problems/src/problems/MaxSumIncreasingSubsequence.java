package problems;

public class MaxSumIncreasingSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,101,2,3,100,4,5};
		int max = maxSum(arr);
		System.out.println(max);

	}
	
	public static int maxSum(int[] arr) {
		int max = 0;
		int n = arr.length;
		int[] sumArray = new int[n];
		sumArray[0] = arr[0];
		for(int i=1;i<n;i++) {
			if(arr[i]>=arr[i-1])
				sumArray[i] = sumArray[i-1]+arr[i];
			else {
				int j = secondLowest(arr,i,arr[i]);
				sumArray[i] = sumArray[j] + arr[i]; 
			}
			if(sumArray[i]>max)
				max = sumArray[i];
		}
		return max;
	}

	private static int secondLowest(int[] arr, int i, int val1) {
		int j = i-1;
		while(j>=0) {
			if(arr[j]<=val1)
				break;
			else
				j--;
		}
		return j;
	}

}
