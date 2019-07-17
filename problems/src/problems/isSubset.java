package problems;
import java.util.HashSet;

public class isSubset {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr1[]= {1,2,3,4,5};
		int arr2[] = {3,4,5};
		System.out.println(isSubset(arr1,arr2));

	}

	private static boolean isSubset(int[] arr1, int[] arr2) {
		HashSet<Integer> hset = new HashSet<>();
		for(int i=0;i<arr1.length;i++) {
			hset.add(arr1[i]);
		}
		for(int i=0;i<arr2.length;i++) {
			if(!hset.contains(arr2[i])) {
				return false;
			}
		}
		// TODO Auto-generated method stub
		return true;
	}

}
