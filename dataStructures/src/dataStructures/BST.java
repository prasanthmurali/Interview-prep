package dataStructures;

public class BST {

	NodeBST root;
	
	public BST() {
		root = null;
	}

	public NodeBST search(NodeBST root, int key) {
		if(root.key==key)
			return root;
		else if(key<root.key)
			return search(root.left,key);
		else
			return search(root.right, key);
	}
	
	public static NodeBST deleteNode(NodeBST root, int key) {
		if(root == null)
			return root;
		if(key<root.key)
			root.left = deleteNode(root.left,key);
		else if(key>root.key)
			root.right = deleteNode(root.right,key);
		else {
			/*
			 * root has one child
			 */
			if(root.left==null)
				return root.right;
			else if(root.right ==null)
				return root.left;
			
			/*
			 * root has two children
			 */
			root.key = minValue(root.right);
			deleteNode(root.right, root.key);
		}
		
		return root;
	}

	private static int minValue(NodeBST root) {
		// TODO Auto-generated method stub
		int min = Integer.MAX_VALUE;
		while(root!=null) {
			min = root.left.key;
			root = root.left;
		}
		return min;
	}

	public static NodeBST insert(NodeBST root, int key) {
		if(root==null) {
			root = new NodeBST(key);
			return root;
		}
		if(key<root.key)
			root.left = insert(root.left,key);
		else 
			root.right = insert(root.right,key);
		return root;
	}

	public static void inOrderBST(NodeBST root) {
		if(root!=null) {
			inOrderBST(root.left);
			System.out.println(root.key);
			inOrderBST(root.right);
		}
	}

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BST tree = new BST();
		tree.root = insert(tree.root,50);
		tree.root = insert(tree.root,30);
		tree.root = insert(tree.root,20);
		tree.root = insert(tree.root,40);
		tree.root = insert(tree.root,70);
		tree.root = insert(tree.root,60);
		tree.root = insert(tree.root,80);
		
		//inOrderBST(tree.root);
		
		tree.root = deleteNode(tree.root, 20);
		inOrderBST(tree.root);

	}

}

class NodeBST{
	int key;
	NodeBST left;
	NodeBST right;
	NodeBST(int key){
		this.key = key;
		left = right = null;
	}
}
