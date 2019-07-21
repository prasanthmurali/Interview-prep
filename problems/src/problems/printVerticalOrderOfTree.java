package problems;
import java.util.TreeMap;
import java.util.Vector;
import java.util.Map.Entry;

public class printVerticalOrderOfTree {
	
	static class Node{
		int data;
		Node left;
		Node right;
		
		Node (int d){
			data = d;
			left = null;
			right = null;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node root = new Node(1); 
        root.left = new Node(2); 
        root.right = new Node(3); 
        root.left.left = new Node(4); 
        root.left.right = new Node(5); 
        root.right.left = new Node(6); 
        root.right.right = new Node(7); 
        root.right.left.right = new Node(8); 
        root.right.right.right = new Node(9); 
        printVerticalTree(root);

	}
	
	static void printVerticalTree(Node root) {
		TreeMap<Integer, Vector<Integer>> t = new TreeMap<>();
		int hd = 0;
		getVerticalOrder(root, hd, t);
		
		for(Entry<Integer, Vector<Integer>> e: t.entrySet()) {
			System.out.println(e.getValue());
		}
	}

	private static void getVerticalOrder(Node root, int hd, TreeMap<Integer, Vector<Integer>> t) {
		// TODO Auto-generated method stub
		if(root ==null)
			return;
		Vector<Integer> listOfNumbers = t.get(hd);
		if(listOfNumbers==null) {
			listOfNumbers = new Vector<>();
			listOfNumbers.add(root.data);
		}
		else
			listOfNumbers.add(root.data);
		t.put(hd, listOfNumbers);
		
		getVerticalOrder(root.left, hd-1, t);
		getVerticalOrder(root.right, hd+1, t);
		
	}

}


