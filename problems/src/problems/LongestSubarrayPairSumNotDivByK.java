package problems;

import java.util.ArrayList;
import java.util.HashMap;

import com.sun.org.apache.xpath.internal.operations.Bool;

public class LongestSubarrayPairSumNotDivByK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {3, 7, 1, 9, 2};
		int k=3;
		ArrayList<Integer >maxSA = longestSubarray(arr, k);
		System.out.println(maxSA.toString());

	}
	public static ArrayList longestSubarray(int[]arr, int k) {
		int n = arr.length;
		int[] modArray = new int[n];
		ArrayList<Integer> maxSA = new ArrayList<Integer>();
		HashMap<Integer,Boolean> tracker = new HashMap<Integer,Boolean>();
		for(int i=0;i<n;i++) {
			modArray[i] = arr[i]%k;
		}
		ArrayList<Integer> subArray = new ArrayList<Integer>();
		for(int i=0;i<n;i++) {		
			int remainder = modArray[i];
			//if remainder is zero or k/2
			if(remainder==0 || (remainder==k/2 && k%2==0)) {
				//if subarray has zero 
				if(tracker.containsKey(remainder)){
					if(subArray.size()>maxSA.size()) {
						maxSA = subArray;
					}
					subArray=new ArrayList<Integer>();
					tracker = new HashMap<Integer,Boolean>();
				}
				//if subarray does not have zero
				else {
					subArray.add(arr[i]);
					tracker.put(remainder,true);
				}
			}
			// remainder is anything else
			else{
				//check if compliment exists and stop
				int compliment = k-remainder;
				if(tracker.containsKey(compliment)) {
					if(subArray.size()>maxSA.size()) {
						maxSA = subArray;
					}
					subArray=new ArrayList<Integer>();
					tracker = new HashMap<Integer,Boolean>();
				}
				// else add to list, update array and continue
				else {
					subArray.add(arr[i]);
					tracker.put(remainder,true);
				}
			}
		}
		
		return maxSA;
	}

}
