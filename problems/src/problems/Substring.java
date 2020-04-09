package problems;
import java.util.*;

public class Substring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(lengthOfLongestSubstring("abba"));
	}
	
 public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> h = new HashMap<Character, Integer>();
        int n = s.length();
        int maxSoFar = 0;
        int start = 0;
        int end = 1;
        if (n==0)
            return 0;
        if(n==1)
        	
            return 1;
        h.put(s.charAt(start),start);
        for(;end<n;end++){
            // if end character is already seen before 
            if(h.containsKey(s.charAt(end))){
                if(end-start > maxSoFar)
                    maxSoFar=end-start;
               // if(end!=n-1)
                if(h.get(s.charAt(end)) + 1>start)
                		start = h.get(s.charAt(end)) + 1;
                h.put(s.charAt(end),end);
                	//start = h.get(s.charAt(end));
            }
            h.put(s.charAt(end),end);
        }
        if(end-start > maxSoFar)
        		return end-start;
        return maxSoFar;
    }

}
