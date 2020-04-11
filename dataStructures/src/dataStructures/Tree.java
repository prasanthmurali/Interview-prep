package dataStructures;

import java.util.ArrayList;
import java.util.Arrays;

public class Tree {
	
	Node root;

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		
		
		/*
		 * Test leafNodesFromPreOrder
		 */
		int preorder[] = {890, 325, 290, 530,400, 965}; 
        int n = preorder.length; 
        leafNodesFromPreOrder(preorder, n); 
        
		/*
		 * Test minDepth()
		 
		Tree tree = new Tree(); 
        tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(5); 
  
        System.out.println("The minimum depth of "+ 
          "binary tree is : " + minDepth(tree.root));
          */
	}
	
	/*
	 * Longest diameter of a binary tree
	 */
	public static int diameter(Node root) {
		
		if(root==null)
			return 0;
		
		// Diameter of right sub tree
		int a = diameter(root.left);
		// Diameter of left sub tree
		int b = diameter (root.right);
		// Diameter through the root 
		int c = 1 + height(root.left) + height(root.right);
		
		
		return Math.max(Math.max(a, b), c);
	}
	
	/*
	 * Return height of a tree
	 */
	private static int height(Node node) {
		if(node==null)
			return 0;
		return 1+Math.max(height(node.left), height(node.right));
	}

	/*
	 * Min depth of binary tree
	 */
	public static int minDepth(Node root) {
		if(root == null)
			return 1;
		else if(root.left==null)
			return minDepth(root.right) + 1;
		else if(root.right==null)
			return minDepth(root.left) + 1;
		else
			return Math.min(minDepth(root.left), minDepth(root.right));
		
	}
	
	/*
	 * Print leaf nodes from a pre order traversal w/o
	 * building the tree
	 */
	public static void leafNodesFromPreOrder(int arr[], int n) {
		int i=0;
		int max = 0;
		while(i!=n) {
			if(arr[i]>max)
				max = arr[i];
			if(i<n-1) {
				int root = arr[i];
				if(i<n-1 && arr[i+1]<root ) {
					if(arr[i+2]>root) {
						System.out.println(arr[i+1]);
					}
				}
				else {
					if(arr[i+1]>max && arr[i]>arr[i-1]) {
						max  =arr[i+1];
						System.out.println(root);
					}
				}
			}
			i+=1;
		}
		System.out.println(arr[i-1]);
	}
	

}

class Node{
	int n;
	Node left;
	Node right;
	
	public Node(int n) {
		this.n = n;
		this.left = this.right = null;
	}
	
	/*
	 * In order traversal visits the left node, followed
	 * by the current node, followed by the right node.
	 * Similarly, we have pre order traversal and post
	 * order traversal.
	 */
	public void inOrderTraversal(Node n) {
		if(n!=null) {
			inOrderTraversal(n.left);
			System.out.println(n);
			inOrderTraversal(n.right);
		}
	}
	
	
	
	/*
	 * Min - heap: each node smaller than its children
	 */
	
	/*
	 * Tries: 
	 */
	
	
}
