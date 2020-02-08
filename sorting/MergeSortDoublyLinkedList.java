package sorting;

import utilities.DoublyLinkedList;
import utilities.DoublyLinkedList.Node;

public class MergeSortDoublyLinkedList {

	private static Node mergeSortDLL(Node first) {
		if(first.next==null || first==null){return first;}
		
		Node second = getMid(first);
		Node l=mergeSortDLL(first);
		Node r=mergeSortDLL(second);
		return merge(l, r);
	}
	
	private static Node merge(Node first, Node second) {
		
		if (first == null) { 
            return second; 
        } 
  
        // If second linked list is empty 
        if (second == null) { 
            return first; 
        }
		
		Node head =null;
		
		if(first.data <= second.data)
		{
			Node temp = first;
			first=first.next;
			head=isolate(temp);
			//head=head.next;
		} 
		else 
		{
			Node temp = second;
			second=second.next;
			head=isolate(temp);
			//head=head.next;
		}

		while (first!=null && second!=null) {
			
			
			if ((first.data <= second.data)) 
			{
				Node temp = first;
				first=first.next;
				head.next=temp;
				temp.prev=head;
				temp.next=null;
				head=head.next;
			} 
			else 
			{
				Node temp = second;
				second=second.next;
				head.next=temp;
				temp.next=null;
				temp.prev=head;
				head=head.next;
			}
		}
		
		if(first==null){head.next=second;}
		if(second==null){head.next=first;}
		
		while(head.prev!=null)
			head=head.prev;
		
		return head;
	}

	private static Node isolate(Node temp) {
		temp.next=null;
		temp.prev=null;
		return temp;
	}

	private static Node getMid(Node first) {
		Node faster, slower;
		faster=slower=first;
		
		while(faster.next!=null && faster.next.next!=null)
		{
			faster = faster.next.next;
			slower=slower.next;
		}
		Node temp = slower.next;
		temp.prev=null;
		slower.next=null;
		return temp;
	}

	public static void main(String[] args) {
		DoublyLinkedList.Node head = DoublyLinkedList.createList();
		mergeSortDLL(head);
		DoublyLinkedList.printForward(head);

	}

}
