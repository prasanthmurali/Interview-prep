package problems;
import java.util.HashMap;

public class longestSubArraySumDivByK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int arr[] = {2, 7, 6, 1, 4, 5};
		int arr[] = {-2, 2, -5, 12, -11, -1, 7};
		System.out.println(longestArrayLength(arr,3));
		
	}
	
	public static int longestArrayLength(int[] arr,int k) {
		int sum=0;
		int[] remainderArray = new int[arr.length];
		for(int i=0;i<arr.length;i++) {
			sum=sum+arr[i];
			remainderArray[i] = sum%k;
		}
		HashMap<Integer, Integer> modMap = new HashMap<Integer, Integer>();
		int maxLength = 0;
		for(int i=0;i<remainderArray.length;i++) {
			if(remainderArray[i]==0) {
				maxLength = maxLength+i;
			}
			else if(!modMap.containsKey(remainderArray[i])) {
				modMap.put(remainderArray[i], i);
			}
			else if(maxLength<(i-modMap.get(remainderArray[i]))) {
				maxLength = i-modMap.get(remainderArray[i]);
			}
		}
		return maxLength;
	}

}
