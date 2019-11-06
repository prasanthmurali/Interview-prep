package problems;
import java.util.HashMap;

public class MaxChocolates {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2, 7, 6, 1, 4, 5};
		int maxChocolates = max(arr,3);
		System.out.println(maxChocolates);

	}
	
	public static int max(int[] arr, int k) {
		int max = 0;
		HashMap<Integer,Integer> modToIdx = new HashMap<Integer, Integer>();
		int n = arr.length;
		int[] sumArray = new int[n];
		sumArray[0] = arr[0];
		int[] modArray = new int[n];
		modArray[0] = sumArray[0]%k;
		for(int i=1;i<n;i++) {
			sumArray[i] = sumArray[i-1]+arr[i];
			modArray[i]= sumArray[i]%k;
		}		
		for(int i=0;i<n;i++) {
			if(modArray[i]==0) 
				max = sumArray[i]>max?sumArray[i]:max;
			else {
				int mod = modArray[i];
				if(!modToIdx.containsKey(mod))
					modToIdx.put(mod, i);
				else {
					int newMax = sumArray[i] - sumArray[modToIdx.get(mod)];
					max = newMax>max?newMax:max;
				}
			}
		}
		return max;
	}

}
