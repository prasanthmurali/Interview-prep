package problems;

import java.util.ArrayList;
import java.util.HashSet;

public class CoinCombination {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum = 6;
		int[] denominations = {1,2,5};
		printPermuations(sum, denominations);

	}

	public static void printPermuations(int sum, int[] denomiations) {
		ArrayList<ArrayList<String>> combinations = new ArrayList<>();
		
		/*
		 * Add combinations for idx = 0
		 */
		int i = 0;
		ArrayList<String> combination = new ArrayList<>();
		combination.add("");
		combinations.add(combination);
		i++;
		
		/*
		 * Loop through rest of the elements
		 */
		while(i<=sum) {
			ArrayList<String> newCombination = new ArrayList<String>();
			for (Integer d: denomiations) {
				if(i-d<0)
					break;
				else {
					combination = combinations.get(i-d);
					for(String s:combination) {
						if(s.length()>0 && s.charAt(s.length()-1) > Integer.toString(d).charAt(0) ) {
							String newString = s.substring(0,s.length()-1) + Integer.toString(d) + s.charAt(s.length()-1);
							newCombination.add(newString);
						}
						else
							newCombination.add(s+Integer.toString(d));
					}
				}
			}
			combinations.add(newCombination);
			i++;
		}
		HashSet<String> output = new HashSet<>(combinations.get(sum));
		System.out.println(output);
	}
}
