package problems;

import java.util.ArrayList;
import java.util.Arrays;

public class subArrays {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr= {1,2,3,4};
		ArrayList<int[]> subArrays = getAllSubArrays(arr);
		for(int[]subArray:subArrays) {		
				System.out.println(Arrays.toString(subArray));
		}
	}
	
	public static ArrayList<int[]> getAllSubArrays(int[] arr) {
		ArrayList<int[]> subArrays = new ArrayList<int []>();
		int n=arr.length;
		for(int i=0;i<n;i++) {
			for(int j=i+1;j<=n;j++) {
				int[] newSubArray = new int[j-i];
				for(int k=i;k<j;k++) {
					newSubArray[k-i] = arr[k];
				}
				subArrays.add(newSubArray);
			}
		}	
		return subArrays;
	}
}