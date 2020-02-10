package problems;

public class KLargest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static void buildHeap(int[] arr, int n) {
		for(int i=n/2-1;i>=0;i--)
			heapify(arr,n,i);
	}
	
	private static void heapify(int[] arr, int n, int i) {
		int l = 2*i+1;
		int r = 2*i+2;
		int largest = i;
		if(l<n && arr[l]<arr[largest])
			largest = l;
	}

	public static void kLargestNumbers(int[] arr, int k) {
		
	}

}
