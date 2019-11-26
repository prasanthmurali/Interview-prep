package problems;

import java.util.ArrayList;
import java.util.HashMap;

public class Staircase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] X = {1,2,3};
		ArrayList<ArrayList<Integer>> n = setOfPermutations(4,X);
		System.out.println(n);
	}


	/*
	 * recursive version
	 */
	public static int permutations(int n, int s, int[] X) {
		for(int i=0;i<X.length;i++) {
			if(n-X[i]>0)
				s = permutations(n-X[i],s,X);
			else if(n-X[i]==0)
				return s+1;
			else
				return s;
		}
		return s;
	}

	/*
	 * DP version
	 */
	public static int DPpermutations(int n, int[] X) {
		int[] arr = new int[n];
		for(int i=0;i<n;i++) {
			int j = 0;
			while(j<X.length) {
				int diff = (i+1) - X[j];
				if(diff==0)
					arr[i]+=1;
				else if(diff>0)
					arr[i] += arr[diff-1];
				j++;
			}
		}
		return arr[n-1];
	}

	/*
	 * get the actual set of values
	 */
	public static ArrayList<ArrayList<Integer>> setOfPermutations(int n, int[] X) {
		HashMap<Integer,ArrayList<ArrayList<Integer>>> h= new HashMap<>();
		for(int i=0;i<n;i++)
			h.put(i+1, new ArrayList<>());
		
		
		for(int i=0;i<n;i++) {
			int j = 0;
			while(j<X.length) {
				int diff = (i+1) - X[j];
				if(diff==0) {
					ArrayList<Integer> a = new ArrayList<>();
					a.add(X[j]);
					h.get(i+1).add(a);
				}
				if(diff>0) {
					ArrayList<ArrayList<Integer>> listOfList = h.get(diff);			
					for(ArrayList<Integer> list: listOfList) {
						ArrayList<Integer> a = new ArrayList<>();
						for (Integer num:list) {
							a.add(num);
						}
						a.add(X[j]);
						h.get(i+1).add(a);
					}
				}
				j++;
			}
		}
		return h.get(n);
	}
}
