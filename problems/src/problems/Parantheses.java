package problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class patternInfo{
	int sumSoFar;
	int posRemaining;
	
	patternInfo(int sumSoFar, int posRemaining){
		this.sumSoFar = sumSoFar;
		this.posRemaining= posRemaining;
	}
}

public class Parantheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		generateParantheses(3);
		
	}
	
	public static void generateParantheses(int n) {
		HashMap<String, patternInfo> patternSum = new HashMap<>();
		HashMap<String, patternInfo> modHashMap = new HashMap<>();
		patternSum.put("(", new patternInfo(1,n-1));
		for(int i=1;i<2*n;i++) {
			for(String pattern:patternSum.keySet()) {
				int sumSoFar = patternSum.get(pattern).sumSoFar;
				int posRemaining = patternSum.get(pattern).posRemaining;
				/*
				 * sum so far is n or number of positives is 0
				 */
				if(posRemaining==0 || sumSoFar == n) {
					String newPattern = pattern + ")";
					modHashMap.put(newPattern, new patternInfo(n,0));
				}
				
				/*
				 * when sum is > 0 and there are positives remaining 
				 */
				else if(sumSoFar>0) {
					String newPattern = pattern + "(";
					modHashMap.put(newPattern, new patternInfo(sumSoFar+1, posRemaining-1));
					newPattern = pattern + ")";
					modHashMap.put(newPattern, new patternInfo(sumSoFar-1, posRemaining));
				}
				/*
				 * when sum is 0 (but pos is remaining) 
				 */
				else {
					String newPattern = pattern + "(";
					modHashMap.put(newPattern, new patternInfo(sumSoFar+1,posRemaining-1));
				}
			}
			patternSum.clear();
			for(String pattern:modHashMap.keySet()) {
				patternSum.put(pattern, modHashMap.get(pattern));
			}
			modHashMap.clear();
		}
		for(String pattern:patternSum.keySet()) {
			System.out.println(pattern);
		}

	}

}
