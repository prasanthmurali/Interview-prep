package problems;
import java.util.HashMap;
import java.util.Map;

public class LongestSubsetWithoutPairDivByK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int arr[] = {3, 7, 2, 9, 1} ;
		//int arr[] = {3, 17, 12, 9, 11, 15};
		int arr[] = {2, 4, 4, 3} ;
		System.out.println(lengthOfLongestSubset(arr, 4));

	}
	
	public static int lengthOfLongestSubset(int[] arr, int k) {
		int[] remainderArray = new int[arr.length];
		int n = arr.length;
		for(int i=0;i<n;i++) {
			remainderArray[i] = arr[i]%k;
		}
		HashMap<Integer,Integer> modMap = new HashMap<Integer,Integer>();
		for(int i=0;i<n;i++) {
			if(!modMap.containsKey(remainderArray[i])) {
				modMap.put(remainderArray[i], 1);
			}
			else {
				modMap.replace(remainderArray[i], modMap.get(remainderArray[i])+1);
			}
		}
		int maxLength = 0;
		for(Map.Entry<Integer, Integer> entry: modMap.entrySet()) {
			// if entry is 0 or k/2
			if(entry.getKey()==0 || (entry.getKey()==k/2 && k%2==0)) {
				maxLength+=1;
			}
			// if entry is non zero
			else {
				//if compliment exists
				int complimentKey = k-entry.getKey();
				int currentKey = entry.getKey();
				int currentValue = entry.getValue();
				if(modMap.containsKey(complimentKey)) {
				int complimentValue = modMap.get(complimentKey);
				//check which value is greater
					if(currentValue>complimentValue) {
					maxLength = maxLength + currentValue;

				}
					else {
						maxLength = maxLength + complimentValue;
				}
				modMap.replace(currentKey, 0);
				modMap.replace(complimentKey, 0);
				}
				//if compliment does not exist;
				else {
					maxLength = maxLength + entry.getValue();
				}
			}
		}
		return maxLength;
		
	}

}
