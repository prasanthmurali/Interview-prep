package problems;

public class DuplicatesInArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr1= {1,2,3,2,4,5};
		int[] arr2= {1,2,3,4,5};
		System.out.println(firstDuplicate(arr2));

	}
	
	/*
	 * One repeating element: Immutable array
	 * O(1) space 
	 * Run time less than O(n^2)
	 * Only one duplicate element
	 */
	
	public int findDuplicate(int[] nums) {
        
		
		
		return 0;
    }
	
	/*
	 * Notes: O(n^2)time: look for duplicate of every element
	 * Requirements:
	 * O(1) space - first Duplicate in Array
	 * return -1 if no duplicate found
	 */
	
	public static int firstDuplicate(int[] arr) {
		int n = arr.length;
		for(int i=0;i<n;i++) {
			int ele = Math.abs(arr[i]);
			if(arr[ele-1]<0)
				return ele;
			arr[ele-1] = arr[ele-1] * -1;
		}
		return -1;
	}

}
