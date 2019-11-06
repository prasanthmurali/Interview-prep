package problems;

public class Sorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {7,1,3,9,18,2,4};
		quickSort(arr,0,6);
		for(int i=0;i<arr.length;i++)
			System.out.println(arr[i]);
	}

	public static void mergeSort(int[] arr, int l, int r) {
		if(l<r) {
			int m = (l+r)/2;
			mergeSort(arr, l, m);
			mergeSort(arr, m+1, r);
			merge(arr, l, m, r);
		}

	}
	
	public static void quickSort(int[] arr, int low, int high) {
		if(low<high) {
			int pi = partition(arr,low,high);
			quickSort(arr,low,pi-1);
			quickSort(arr,pi+1,high);
		}
	}

	private static int partition(int[] arr, int low, int high) {
		int pivot  = arr[high];
		int i = low-1;
		
		for(int j=low;j<high;j++) {
			if(arr[j]<pivot) {
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		int temp = arr[i+1];
		arr[i+1] = arr[high];
		arr[high]  =temp;
		return i+1;
	}

	public static void merge(int[] arr, int l, int m, int r) {
		int n1 = m-l+1;
		int n2 = r-m;
		int[] temp1  = new int[n1];
		int[] temp2 = new int[n2];

		for(int i=0;i<n1;i++)
			temp1[i] = arr[l+i];
		for(int j=0;j<n2;j++)
			temp2[j] = arr[m+1+j];

		int i=0,j=0,k=l;
		while(i<n1 && j<n2) {
			if(temp1[i]<+temp2[j]) {
				arr[k] = temp1[i];
				i++;
				k++;
			}
			else {
				arr[k] = temp2[j];
				j++;
				k++;
			}
			while(i<n1) {
				arr[k] = temp1[i];
				i++;
				k++;
			}
			while(j<n2) {
				arr[k] = temp2[j];
				j++;
				k++;
			}
		}

	}

}
