package problems;

public class LongestSumSubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int largestSum(int[] arr) {
		int maxSoFar = 0;
		int maxEndingHere = 0;
		for(int i=0;i<arr.length;i++) {
			maxEndingHere = maxEndingHere + arr[i];
			if(maxEndingHere<0)
				maxEndingHere = 0;
			if(maxSoFar<maxEndingHere)
				maxSoFar = maxEndingHere;
		}
		return maxEndingHere;
	}
	
}
