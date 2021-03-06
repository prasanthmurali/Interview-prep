
public class linkedList {

	Node head;
	
	
	public static void main(String[] args) {
		/*
		 * example to create linkedlist with 3 elements 
		 */
		linkedList ll = new linkedList();
		Node e1 = new Node(1);
		Node e2 = new Node(2);
		Node e3 = new Node(3);
		Node e4 = new Node(4);
		Node e5 = new Node(5);
		
		ll.head = e1;
		e1.next = e2;
		e2.next = e3;
		e3.next = e4;
		e4.next = e5;
		
		ll.printLinkedList();
		
		/*
		 * delete a node by passing the node value
		 */
		ll.deleteNode(4);
		ll.printLinkedList();
		
	}
	
	public void printLinkedList() {
		Node n = head;
		while(n!=null) {
			System.out.println(n.data);
			n = n.next;
		}
	}
	
	public void deleteNode(int d) {
		Node n = head;
		Node prev = null;
		
		while(n!=null) {
			if(n.data==d) {
				if(prev==null) {
					head = head.next;
					break;
				}
				else {
					prev.next = n.next;
					break;
				}
			}
			else {
				prev = n;
				n = n.next;
			}
		}
	}

}

class Node{
	int data;
	Node next;
	
	Node(int d){
		data = d;
	}
}
