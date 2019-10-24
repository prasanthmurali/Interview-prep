package problems;
import java.util.ArrayList;

public class sortedArray {
	
	public static void main(String[] args) {
		int arr[] = { 2, 6, 9, 12, 17, 22, 31, 32, 35, 42 };
		//int arr[] = { 3, 5, 6, 7, 8, 10, 12};
		tripletsOfAP(arr);
		
	}
	
	public static void tripletsOfAP(int[] arr) {
		ArrayList<Integer> arrayElements= new ArrayList<Integer>();
		int n = arr.length;
		for(int i=0;i<n;i++)
			arrayElements.add(arr[i]);
		for(int i =0;i<n-2;i++)
			for(int j=i+1;j<n-1;j++) {
				int a = arr[i];
				int b = arr[j];
				int c = 2*b-a;
				if(arrayElements.contains(c))
					System.out.println(a+" "+b+ " "+c);
			}
	}

}
