package utilities;


public class DoublyLinkedList {
	
	public static class Node{
		public Node prev, next;
		public int data;
		Node(int data){this.data=data; prev=next=null;}
		
		public Node push(int i) {
			this.next = new Node(i);
			this.next.prev=this;
			return this.next;
		}
	}
	
	public static Node getLast(Node head) {
		while(head.next!=null)
		{
			head=head.next;
		}
		return head;
	}

	public static Node createList() {
		DoublyLinkedList.Node head = new DoublyLinkedList.Node(0);
		head.push(8).push(6).push(5).push(1).push(2).push(4).push(3).push(7).push(10).push(9);
		return head;
	}

	public static void printBackward(Node head) {
		
		head = getLast(head);
		while(head!=null)
		{
			System.out.print(" "+head.data);
			head=head.prev;
		}
		
	}

	public static void printForward(Node head) {
		while(head!=null)
		{
			System.out.print(" "+head.data);
			head=head.next;
		}
		
	}
	
	public static void insertNodeBefore(Node curr, Node element) {
		
		if(curr.prev==null)
		{
			element.next = curr;
			curr.prev=element;
		}
		else
		{
		Node previous = curr.prev;
		previous.next = element;
		element.prev=previous;
		element.next = curr;
		curr.prev = element;
		
		}
		
	}

	public static void main(String[] args) {
		
		Node head = createList();
		printForward(head);
		System.out.println();
		printBackward(head);
		System.out.println();
		System.out.println("Last is: "+getLast(head).data);
		
		System.out.println("Insering element before "+head.next.next.data);
		insertNodeBefore(head.next.next, new Node(16));
		printForward(head);
		
		head = reverse(head);
		System.out.println("\nReversed-");
		printForward(head);

	}

	private static Node reverse(Node head) {
		//start from i=null and only focus on j.next and j.prev
		Node i=null;
		Node j=head;
		Node k=head.next;
		
		while(j!=null)
		{
			j.next=i;
			j.prev=k;
			i=j;
			j=k;
			if(k!=null)
			k=k.next;
		}
		
		return i;
	}

	

}
