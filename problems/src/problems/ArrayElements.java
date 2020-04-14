package problems;

public class ArrayElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * Test first Duplicate
		 */
//		int[] arr1= {1,2,3,2,4,5};
//		int[] arr2= {1,2,3,4,5};
//		System.out.println(firstDuplicate(arr2));
		
		/*
		 * Test first missing positive
		 */
		int[] arr1= {1,2,0}; //3
		int[] arr2= {3,4,-1,1}; //2
		int[] arr3= {7,8,9,11,12}; //1
		int[] arr4 = {1};//2
		int[] arr5 = {0,1,2};//3
		int[] arr6 = {1,1}; //1
		int[] arr7= {1,0,3,3,0,2};//4
		System.out.println(firstMissingPositive(arr7));
	}
	
	/*
	 * Given an unsorted integer array, find the smallest missing positive integer.
	 * O(1) - space 
	 * O(n) - run time
	 */
	public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int i;
        /*
         * 
         */
        for(i=0;i<n;i++){
            if (nums[i]<=0)
                nums[i]=99999;
        }
        /*
         * 
         */
        for(i=0;i<n;i++){
        	int element = nums[i];
        	element = Math.abs(element);
            if(element>0 && element<=n)
            		if(nums[element-1]>0)
            			nums[element-1] = nums[element-1]*-1;   
            		else if(nums[element-1]==0)
            			nums[element-1] = nums[element]*-1;
        }
        for(i=0;i<n;i++){
            if(nums[i]>=0)
                break;
        }
        return i+1;
	}
	
	/*
	 * One repeating element: Immutable array
	 * O(1) space 
	 * Run time less than O(n^2)
	 * Only one duplicate element
	 */
	
	public static int findDuplicate(int[] nums) {
        int hare = nums[0];
        int tortoise = nums[0];
        do{
            tortoise = nums[tortoise];
            hare = nums[nums[hare]];
        } while(hare!=tortoise);
        
        int start = nums[0];
        while(start!=tortoise){
            start = nums[start];
            tortoise = nums[tortoise];
        }
        return tortoise;
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
