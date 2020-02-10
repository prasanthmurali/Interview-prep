package problems;

public class recursionPaths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int start = 6;
		int end = 13;
		int steps = ArrayBasedRecursion(start,end);
		System.out.println(steps);

	}
	
	public static int recursion(int start, int end) {
		if(start==end)
			return 0;
		if(start<=2 || start>=100)
			return 0;
		if(start>end)
			return 1+recursion(start-1,end);
		else
			return Math.min((1+recursion(start-1,end)), (1+recursion(start*2,end)));
	}
	
	public static int ArrayBasedRecursion(int start, int end) {
		if(start == end)
			return 0;
		if(start>end)
			return end-start;
		
		int[] arr = new int[end+1];
		
		/*
		 * 0 TO START
		 */
		for(int i=0;i<=start;i++)
			arr[i] = start-i;
		
		/* 
		 *Start to end
		 */
		for(int i = start+1;i<end+1;i++) {
			if(i%2==0) {
				arr[i] = arr[i/2]+1;
			}
			else {
				arr[i] = arr[i/2+1] + 2;
			}
		}
		
		return arr[end];
	}

}
