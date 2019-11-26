package problems;

public class SortingPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {5,1,7,4,9,2,4};
		heapSort(arr);
		for(int a:arr) {
			System.out.println(a);
		}
	}
	
	public static void heapSort(int[] arr) {
		int n = arr.length;
		for(int i=n/2-1;i>=0;i--)
			heapify(arr,n,i);
		for(int i=n-1;i>=0;i--) {
			swap(arr,i,0);
			heapify(arr,i,0);
		}
	}

	private static void heapify(int[] arr, int n, int i) {		
		int l  =2*i+1;
		int r = 2*i+2;
		int largest = i;
		if(l<n && arr[l]>arr[largest]) 
			largest = l;
		if(r<n && arr[r]>arr[largest])
			largest = r;
		if(largest!=i) {
			swap(arr,i,largest);
			heapify(arr,n,largest);
		}
	}

	public static void quickSort(int[] arr, int low, int high) {
		if(low<high) {
			int pa = partition(arr,low,high);
			quickSort(arr, low, pa-1);
			quickSort(arr, pa+1,high);
		}
	}

	private static int partition(int[] arr, int low, int high) {
		int pivot = arr[high];
		int i = low-1;
		for(int j=low;j<high;j++) {
			if(arr[j]<pivot) {
				i++;
				swap(arr,j,i);
			}
		}
		swap(arr,i+1,high);
		return i+1;
	}

	public static int indexOfMin(int [] arr, int i) {
		int minIndex = i;
		for(;i<arr.length;i++) {
			if(arr[i]<arr[minIndex])
				minIndex = i;
		}
		return minIndex;
	}

	public static void swap(int[] arr, int i, int j) {
		int temp  = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void selectionSort(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			int minIndex = indexOfMin(arr,i);
			swap(arr,i,minIndex);
		}
	}

	public static void bubbleSort(int[] arr) {
		int n = arr.length;
		for(int i=0;i<n-1;i++)
			for(int j=0;j<n-i-1;j++) {
				if(arr[j]>arr[j+1]) {
					swap(arr,j,j+1);
				}
			}
	}

	public static void mergeSort(int[] arr, int l, int r) {
		if(l<r) {
			int m =(l+r)/2;
			mergeSort(arr,l,m);
			mergeSort(arr,m+1,r);
			merge(arr,l,m,r);
		}
	}

	private static void merge(int[] arr, int l, int m, int r) {
		int n = arr.length;

		int n1 = m-l+1;
		int n2 = r-m;

		int[] left = new int[n1];
		int[] right = new int[n2];

		for(int i=0;i<n1;i++)
			left[i] = arr[l+i];
		for(int i = 0;i<n2;i++)
			right[i] = arr[m+1+i];

		int k = l;
		int i = 0;
		int j = 0;

		while(i<n1 && j<n2) {
			if(left[i]<=right[j]) {
				arr[k] = left[i];
				i++;
			}
			else {
				arr[k] = right[j];
				j++;
			}
			k++;
		}
		while(i<n1) {
			arr[k] = left[i];
			k++;
			i++;
		}
		while(j<n2) {
			arr[k] = right[j];
			k++;
			j++;
		}
	}

	public static void insertionSort(int[] arr) {
		int n = arr.length;
		for(int i=1;i<n;i++) {
			int j = i-1;
			int temp = arr[i];
			while(j>=0 && temp<=arr[j]) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = temp;
		}
	}

}
