package dataStructures;
import java.util.Stack;

public class StackImp {

	int top;
	int max = 9999;
	int[] arr = new int[top];
	StackImp() {
		top =-1;
	}
	public boolean push(int x) {
		if(top>=max)
			System.out.println("Stack overflow");
		else {
			arr[++top] = x;
		}
		return true;
	}
	public int pop() {
		if(top<0)
		{
			System.out.println("Stack underflow");
			return 0;
		}
		else {
			int x = arr[top--];
			return x;
		}
	}
	
	public static boolean isDuplicateParanthesis(String s) {
		Stack<Character> exp = new Stack<>();
		char[] str = s.toCharArray();
		for(char c:str) {
			if(c==')') {
				int counter = 0;
				while(exp.pop()!='(') {
					counter++;
				}
				if(counter<1)
					return true;
			}
			else {
				exp.push(c);
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Test isDuplicateParanthesis
		 */
		String s = "((a+b)+((c+d)))";
		System.out.println(isDuplicateParanthesis(s));

	}

}
