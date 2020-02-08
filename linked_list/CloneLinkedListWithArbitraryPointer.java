package linked_list;

import java.util.HashMap;

class Node{
	int data;
	Node next;
	Node arbit;
	Node(int data){this.data=data;}
}
public class CloneLinkedListWithArbitraryPointer {
	static Node head=null;
	
	

	public static void main(String[] args) {

	Node n1 = new Node(1);
	Node n2 = new Node(2);
	Node n3 = new Node(3);
	Node n4 = new Node(4);
	Node n5 = new Node(5);
	
	head=n1;
	n1.next=n2;
	n2.next=n3;
	n3.next=n4;
	n4.next=n5;
	n5.next=null;
	
	n1.arbit=n3;
	n3.arbit=n5;
	n4.arbit=n5;
	n2.arbit=n1;
	n5.arbit=n2;
	
	printList(head);
	Node head2= cloneList(head);
	System.out.println();
	printList(head2);
	}



	private static Node cloneList(Node head1) {
		Node curr=head1;
		HashMap<Integer, Node> map = new HashMap<Integer, Node>();
		while(curr.next!=null)
		{
			map.put(curr.data, new Node(curr.data));
			curr=curr.next;
		}
		curr=head1;
		Node head2=map.get(head1.data);
		Node curr2=head2;
		while(curr.next!=null)
		{
			curr2.next = map.get(curr.data);
			curr2.arbit = map.get(curr.arbit);
			curr=curr.next;
		}
		return head2;
	}



	private static void printList(Node head2) {
		Node curr=head;
		while(curr.next!=null){
			System.out.println(curr.data+"-->"+curr.arbit.data);
			curr=curr.next;}
		
	}

}
