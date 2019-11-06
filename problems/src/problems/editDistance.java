package problems;

public class editDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(stringCompare2("abcde", "afde",2));

	}
	
	public static boolean stringCompare1(String s1, String s2) {
		return s1.toLowerCase()==s2.toLowerCase();
	}
	
	public static boolean stringCompare2(String s1, String s2,int tolerance) {
		if(Math.abs(s1.length()-s2.length())>tolerance)
			return false;
		s1 = s1.toLowerCase();
		s2=  s2.toLowerCase();
		int n = s1.length()>s2.length()?s2.length():s1.length();
		int d = 0;
		for(int i=0;i<n;i++) {
			if(!(s1.charAt(i)==s2.charAt(i)))
				d++;
			if(d>tolerance)
				return false;
		}
		return true;
	}

}
