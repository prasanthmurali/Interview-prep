package problems;

import java.util.ArrayList;
import java.util.Arrays;

class Stock{
	int buyDate;
	int sellDate;
	
	public Stock(int b, int s) {
		buyDate = b;
		sellDate = s;
	}
}

public class BuyAndSellStocks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr ={23, 13 ,25, 29 ,33, 19, 34, 45, 65 ,67};
		ArrayList<Stock> profitDays = maxProfit(arr);
		for (Stock day: profitDays) {
			System.out.println(day.buyDate + " " + day.sellDate);
		}

	}
	
	public static ArrayList<Stock> maxProfit(int[] arr){
		int n = arr.length;
		int diffArray [] =new int[n-1];
		ArrayList<Stock> output = new ArrayList<Stock>();
		for(int i=0;i<n-1;i++) {
			diffArray[i] = arr[i+1]-arr[i];
		}
		int start = -1;
		int end = -1;
		
		for(int i=0;i<n-1;i++) {
			if(diffArray[i]>=0) {
				end = i;
			}
			else {
				if(start!=end){
					output.add(new Stock(start+1,end+1));
					start  = end+1;
				}
				else
					start++;
			}
		}
		if(end>start) {
			output.add(new Stock(start+1,end+1));
		}
		return output;
	}

}
