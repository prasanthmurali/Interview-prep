package problems;

import java.util.ArrayList;

public class LCS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * test LCSString
		 */
		/*
		String s1 = "abcdh";
		String s2  ="aedfhr";
		int lcs = LCSString(s1,s2);
		System.out.println(lcs);
		*/
		
		/*
		 * Test LCIS
		 */
		int[] l1 = {3,4,9,1};
		int[] l2 = {5,3,8,9,10,2,1};
		ArrayList<Integer> output = LCIS(l1,l2);
		for(int i:output)
			System.out.println(i + " ");

	}

	public static ArrayList<Integer> LCIS(int[] l1, int[] l2){

		/*
		 * Assume n1<n2 for this problem 
		 */

		int n1 = l1.length;
		int n2 = l2.length;
		ArrayList<Integer> output = new ArrayList<>();
		int k = l1[0]==l2[0]?1:0;
		int top = 0;
		for(int i=k;i<n1;i++) {
			int temp = k;
			if(l1[i]>top) {
				while(k<n2 && l1[i]!=l2[k]) {
					k++;
				}
				if(k!=n2) {
					output.add(l1[i]);
					top = l1[i];
					k++;
				}
				else {
					k = temp;
				}
			}
		}
		return output;
	}

	public static int LCSString(String s1, String s2) {
		int n1 = s1.length();
		int n2 = s2.length();
		/*
		 * Assume n1 < n2 for this problem
		 */
		int lcs[] = new int[n1];
		lcs[0] = s1.charAt(0)==s2.charAt(0)?1:0;
		int k = lcs[0];
		for(int i=k;i<n1;i++) {
			int temp = k;
			while(k<n2 && s1.charAt(i)!=s2.charAt(k)) {
				k++;
			}
			if(k!=n2) {
				lcs[i] = lcs[i-1] + 1;
				k++;
			}
			else {
				k= temp;
				lcs[i] = lcs[i-1];
			}

		}

		return lcs[n1-1];
	}

}
