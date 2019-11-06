package problems;

public class Maximization {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {4,8,9,2,20};
		System.out.println(maxFour(arr));
		

	}
	
	public static int maxFour(int[] arr) {
		int n = arr.length;
		int[] diffArray = new int[n-1];
		for(int i=0;i<n-1;i++)
			diffArray[i] = arr[i+1]-arr[i];
		
		int max1=0,max2=0,sum=0;
		for(int i=0;i<n-1;i++) {
			if(diffArray[i]>=0)
				sum+=diffArray[i];
			else
				sum = 0;
			if(sum>max1) {
				max2 = max1;
				max1 = sum;
			}
			else if(sum>max2) {
				max1 = max2;
				max2 = sum;
			}
		}
		return max1+max2;
	}

}
