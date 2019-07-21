package problems;
import java.util.HashMap;

public class arrayIntoPairsSumK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr1[]= {9,7,5,3};
		int arr2[]= {92, 75, 65, 48, 45, 35};
		int arr3[] = {91, 74, 66, 48};
		
		System.out.println(canDivideArray(arr3,10));

	}

	private static boolean canDivideArray(int[] arr, int k) {
		// TODO Auto-generated method stub
		if((arr.length%2)==1)
			return false;
		HashMap<Integer, Integer> remainderMap = new HashMap<Integer, Integer>();
		for(int i=0;i<arr.length;i++) {
			if(!remainderMap.containsKey(arr[i]%k)) 
				remainderMap.put(arr[i]%k, 1);
			else
				remainderMap.put(arr[i]%k, remainderMap.get(arr[i]%k)+1);
		}
		for(int i=0;i<arr.length;i++) {
			int element = arr[i];
			int remainder = element%k;
			if(remainderMap.get(remainder)%2==1) {
				{
					if(remainderMap.containsKey(k-remainder)&&remainderMap.get(k-remainder)%2==1) {
						return true;
					}
					else {
						return false;
					}
				}
				
			}
		}
		return true;
	}

}
