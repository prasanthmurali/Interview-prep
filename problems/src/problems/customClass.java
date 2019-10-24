package problems;

public class customClass {

	public static void main(String[] args) {
		int arr[]= {46,15,44,1,20};
		System.out.println(countMoves(arr, arr.length));
	}

	private static int countMoves(int[] arr, int n) {
		int noOfEvens = 0;
		int count =0;
		
		for(int i=0;i<n;i++)
			if(arr[i]%2==0)
				noOfEvens++;
		
		for(int i=0;i<noOfEvens;i++)
			if(arr[i]%2!=0)
				count++;

		return count;
	}
}
