package problems;
import java.lang.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * findMedianSortedArrays
		 
		int nums1[] = {-5, 3, 6, 12, 15};
		int nums2[] = {-12, -10, -6, -3, 4, 10};
		int m = nums1.length;
		int n = nums2.length;
		int median = findMedianSortedArrays(nums1,nums2,m,n);
		System.out.print(median);
		*/
		
		/*
		 * largestSumSubarray
		 */
		int arr[] = {-2, -3, 4, -1, -2, 1, 5, -3}; 
		largestSumSubarray(arr);
		

	}
	
	public static void largestSumSubarray(int[] arr) {
		int n = arr.length;
		int min=0;
		int max = 0;
		int sum = 0;
		for(int i=0;i<n;i++) {
			sum = sum + arr[i];
			if(sum<=min)
				min = sum;
			if(sum>=max)
				max = sum;
		}
		System.out.println(max-min);
		
	}
	
	public static int findMedianSortedArrays(int[] nums1, int[] nums2, int m, int n) {
		int start = 0;
		int end = m;
		int xLeft, xRight, yLeft, yRight;
		
		while(start<=end) {
			int partitionX = (start+end)/2;
			int total = (m+n+1)/2;
			int partitionY = total-partitionX;
			if(partitionX==0) {
				 xLeft = -5;
			}
			else {
				 xLeft = nums1[partitionX-1];
			}
			
			if(partitionX==m) {
				 xRight = 999;
			}
			else {
				 xRight = nums1[partitionX];
			}
			
			if(partitionY==0) {
				 yLeft = -5;
			}
			else {
				 yLeft = nums2[partitionY-1];
			}
			
			if(partitionY==m) {
				 yRight = -5;
			}
			else {
				 yRight = nums2[partitionY];
			}
			
			if((xLeft<=yRight)&&(yLeft<=xRight)) {
				int median = 0;
				if((m+n)%2==0) {
					 median = (Math.max(xLeft, yLeft) + Math.min(xRight, yRight))/2;
				}
				else {
					 median = Math.max(xLeft, yLeft) ;
				}
				return median;
			}
			else if(xLeft>yRight) {
				end = partitionX-1;
			}
			else if (yLeft>xRight){
				start = partitionX+1;
			}
		}
		return 0;    
    }
}
