package problems;

public class countDecodings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char digits[] = {'1', '2', '3', '4'}; 
	    int n = digits.length; 
	    System.out.printf("Count is %d", numOfDecodings(digits, n)); 

	}
	
	public static int numOfDecodings(char[] arr, int n) {
		if(n==0 || n==1)
			return 1;
		if(arr[0] == '0')
			return 0;
		int count = 0;
		if(arr[n-1]>'0')
			count = numOfDecodings(arr,n-1);
		
		if((arr[n-2]=='1' || arr[n-2]=='2') && arr[n-1]<'7')
			count+=numOfDecodings(arr,n-2);
		
		return count;
	}

}
