package problems;

public class orderStatistics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {7,9,3,4,11};
		System.out.println(secondOrderMin(arr));

	}

	public static int min(int arr[]) {
		int min = arr[0];
		int n = arr.length;
		for(int i=1;i<n;i++)
			if(arr[i]<=min)
				min = arr[i];
		return min;
		
	}
	
	public static int secondOrderMin(int arr[]) {
		int min1 = arr[0];
		int min2 = arr[1];
		if (min1>=min2) {
			int min = min2;
			min2 = min1;
			min1 = min;
		}
		int n = arr.length;
		for(int i=2;i<n;i++)
			if(arr[i]<=min1) {
				min2 = min1;
				min1 = arr[i];
			}
			else if(arr[i]<=min2 && arr[i]>=min1) {
				min2 = arr[i];
			}
		return min2;
	}
	
	public static int mthOrderMin(int arr[], int m) {
		int min = arr[0];
		
		
		
		
		return min;
	}
	
}
