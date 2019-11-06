package dataStructures;

public class MaxHeap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Test basic heapification
		 */
		
		/*
		int arr[] = { 1, 3, 5, 4, 6, 13, 10, 
				9, 8, 15, 17 }; 

		int n = arr.length; 

		buildHeap(arr, n); 

		printHeap(arr, n); 
		*/
		
		/*
		 * Test k-th smallest
		 */
		/*
		 int arr[] = {12, 3, 5, 7, 19}; 
		 int n = arr.length;
		 int k = 4;
		 kthSmallest(arr,n,k);
		 */
		
		/*
		 * Test median in a stream
		 */
		/*
		int[] arr= {5,10,15};
		for(int i=0;i<arr.length;i++)
			System.out.println(streamMedian(arr, i+1));
		*/
		
		/*
		 * Test heap sort
		 */
		 int arr[] = {12, 3, 5, 7, 19}; 
		 heapSort(arr);
		 for(int i=0;i<arr.length;i++)
			System.out.println(arr[i]);
		 
	}
	
	public static int kthSmallest(int[] arr, int n, int k) {
		if(k>n)
			System.out.println("Please send a valid input. K cannot be greater than N.");
		int[] heapArray = arr;
		for(int i=k-1;i>=0;i--)
			heapify(heapArray,k,i);
		for(int i=k;i<n;i++)
			if(heapArray[i]<heapArray[0]) {
				heapArray[0] = heapArray[i];
				heapify(arr,k,i);
			}
		// System.out.println(arr[0]);
		return arr[0];	
	}
	
	public static void heapSort(int[] arr) {
		int n = arr.length;
		for(int i=n/2-1;i>=0;i--) 
			heapify(arr, n, i);
		
		for(int i=n-1;i>=0;i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			heapify(arr,i,0);
		}
	}
	
	public static void buildHeap(int[] arr, int n) {
		int start = n/2-1;
		for(int i=start;i>=0;i--)
			heapify(arr,n,i);
	}

	private static float streamMedian(int[] history, int n) {
		if(n==1)
			return history[0];
		if(n%2==0) {
			float n1 = kthSmallest(history, n, n/2);
			float n2 = kthSmallest(history, n, n/2+1);
			return (n1+n2)/2;
		}
		else {
			float n1 = kthSmallest(history, n, (n+1)/2);
			return n1;
		}
	}
	
	private static void heapify(int[] arr, int n, int i) {
		int largest = i;
		int l = 2*i+1;
		int r = 2*i+2;
		if(l<n && arr[l]>arr[largest])
			largest = l;
		if(r<n && arr[r] > arr[largest])
			largest = r;
		if(largest!=i) {
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;
			heapify(arr,n,largest);
		}
	}
	
	private static void printHeap(int arr[], int n)
	{
		for(int i=0;i<n;i++)
			System.out.println(arr[i]);
	}
}
