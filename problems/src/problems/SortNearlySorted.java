package problems;

public class SortNearlySorted {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {6, 5, 3, 2, 8, 10, 9};
		int n = arr.length;
		nearlySorted(arr,3);
	}
	
	public static void nearlySorted(int[] arr, int k) {
		int n = arr.length;
		int[] arr2 = new int[k+1];
		int i=0;
		for(;i<=k;i++) {
			arr2[i] = arr[i];
		}
		while(i<n) {
			minHeap(arr2);
			System.out.println(arr2[0]);
			arr2[0] = arr[i];
			i++;
		}
		for(i=k+1;i>0;i--) {
			minHeap(arr2);
			System.out.println(arr2[0]);
			arr2[0] = Integer.MAX_VALUE;
		}
	}
	
	public static void heapify (int[] arr, int n, int i) {
		int l = 2*i+1;
		int r = 2*i+2;
		int smallest = i;
		if(l<n&&arr[l]<arr[smallest])
			smallest = l;
		if(r<n && arr[r]<arr[smallest])
			smallest = r;
		if(smallest!=i) {
			int temp = arr[smallest];
			arr[smallest] = arr[i];
			arr[i] = temp;
			heapify(arr,n,smallest);
		}
	}
	
	public static void minHeap(int[] arr) {
		int n = arr.length;
		for(int i=n/2;i>=0;i--)
			heapify(arr,n,i);
	}

}
