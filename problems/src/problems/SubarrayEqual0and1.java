package problems;

import java.util.HashMap;

public class SubarrayEqual0and1 {

	public static void main(String[] args) {
		//int[] arr= {1, 0, 0, 1, 0, 1, 1};
		int[] arr =  {1, 0, 0, 1, 0};
		greaterCountOfOne(arr);
		
		//largestSubArray(arr);
		//System.out.println(countSubArrays(arr));
	}
	
	/*
	 * Total number of subArrays with equal 0s and 1s
	 */
	public static int countSubArrays(int[] arr) {
		int count = 0;
		int n = arr.length;
		HashMap<Integer,Integer> tracker = new HashMap<Integer, Integer>();
		
		/* 
		 * convert all zeros to minus ones
		 */
		for(int i=0;i<n;i++) {
			if(arr[i]==0)
				arr[i] = -1;
		}
		/*
		 * Calculate Left sum
		 */
		int[] sumArray = new int[n];
		int sum = 0;
		for(int i=0;i<n;i++) {
			sum = sum+arr[i];
			sumArray[i] = sum;
		}
		
		/*
		 * find zero sum indices and add it to the counts
		 */
		for(int i=0;i<n;i++) {
			if(sumArray[i]==0) {
				count+=1;
				if(!tracker.containsKey(0)) {
					tracker.put(0,i);
				}	
			}
		}
		
		
		/*
		 * Find non start indices and add to counts
		 */	
		for(int i=0;i<n;i++) {
			if(!tracker.containsKey(sumArray[i])) {
				tracker.put(sumArray[i], i);
			}
			else {
				count+=1;
			}
		}
		return count;
	}
	
	/*
	 * Longest SubArray with equal 0s and 1s
	 */
	public static void largestSubArray(int[] arr) {
		int n = arr.length;
		/* 
		 * convert all zeros to minus ones
		 */
		for(int i=0;i<n;i++) {
			if(arr[i]==0)
				arr[i] = -1;
		}
		int[] sumArray = new int[n];
		int sum = 0;
		for(int i=0;i<n;i++) {
			sum = sum+arr[i];
			sumArray[i] = sum;
		}
		
		/*
		 * find zero sum from index = 0 and max from other index, 
		 * return the max of those two 
		 */
		int zeroSumLength = -1;
		for(int i=0;i<n;i++) {
			if(sumArray[i]==0)
				if(i>zeroSumLength)
					zeroSumLength = i;
		}
		
		/*
		 * Find max non zero index length
		 */	
		HashMap<Integer,Integer> tracker = new HashMap<Integer, Integer>();
		int start = -1;
		int maxLength = -1;
		for(int i=0;i<n;i++) {
			if(!tracker.containsKey(sumArray[i])) {
				tracker.put(sumArray[i], i);
			}
			else {
				int curLength = i-tracker.get(sumArray[i]);
				if(curLength>maxLength) {
					maxLength = curLength;
					start = tracker.get(sumArray[i])+1;
				}
			}
		}
		if(zeroSumLength>start)
		{
			start = 0;
			maxLength = zeroSumLength+1;
		}
		if(start!=-1)
			System.out.println("Start :"+start+" End:"+(start+maxLength-1));
		else
			System.out.println("No such array present");
	}
	
	/*
	 * Longest subarray with count of 1s 1 more than count of 0s
	 */
	public static void greaterCountOfOne(int[] arr) {
		int n=arr.length;
		/* 
		 * convert all zeros to minus ones
		 */
		for(int i=0;i<n;i++) {
			if(arr[i]==0)
				arr[i] = -1;
		}
		/*
		 * Calculate Left sum
		 */
		int[] sumArray = new int[n];
		int sum = 0;
		for(int i=0;i<n;i++) {
			sum = sum+arr[i];
			sumArray[i] = sum;
		}
		HashMap<Integer, Integer> tracker = new HashMap<Integer,Integer>();
		int start =-1;
		int maxLength = -1;
		for(int i=0;i<n;i++) {
			if(!tracker.containsKey(sumArray[i])) 
				tracker.put(sumArray[i], i);
			else {
				int currentValue = sumArray[i];
				if(tracker.containsKey(currentValue-1))
					if((i-tracker.get(currentValue-1))>maxLength) {
						start = tracker.get(currentValue-1)+1;
						maxLength = i-tracker.get(currentValue-1);
					}	
			}
		}
		if(start==(start+maxLength-1))
			System.out.println("Start :"+start+" End:"+(start+maxLength-1));
		else
			System.out.println("No such array present");
	}
}
