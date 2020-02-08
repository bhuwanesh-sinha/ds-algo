package searching_algos;

import java.util.ArrayList;

/**
 * @author bhuvi
 * Search whther a linked list is a part of another linked list using KMP search
 */

class Node{
	Node next = null;
	char value;
	
	public Node(char value){this.value = value;}
	
	Node setNextNode(Node node){
		this.next = node;
		return node;
		}
	
}

public class KMPSearchLinkedList {
	

	public static void main(String[] args) {
		Node list = createLinkedList();
		Node searchList = createSearchList();
		printList(list);
		printList(searchList);
		int i = KMPSearch(list, searchList, 6);

	}

	private static int KMPSearch(Node list, Node searchList, int sizeOfSearchList) {
		int[] table = generateTable(searchList, sizeOfSearchList);
		int pos = -1;
		int table_ctr=0;
		
		while(list.next!=null)
		{
			
		}
		
		return pos;
	}

	private static int[] generateTable(Node searchList, int sizeOfSearchList) {
				
				int[] table = new int[sizeOfSearchList];
				table[0] = 0; 
				int i_index = 0;
				int j_index = 1;
				Node i = searchList;
				Node j = searchList.next;
				
				while(j_index<sizeOfSearchList)
				{
					if(i.value==j.value)
					{
						table[j_index]=i_index+1;
						i = i.next;
						j = j.next;
						i_index++;
						j_index++;
					}
					else
					{
						table[j_index]=0;
						j=j.next;
						j_index++;
					}
				}
				
				for(int x=0;x<table.length; x++)
					System.out.print(" "+table[x]);
				
				return table;
	}

	private static void printList(Node list) {
		Node pointer = list;
		System.out.println("------------------------------------------------------------");
		
		while(pointer!=null)
		{
			System.out.print(pointer.value+" ");
			pointer = pointer.next;
		}
		System.out.println();
		
	}

	private static Node createLinkedList() {//a b x a b c a b c a b y
		Node list = new Node('a');
		Node firstNode = list;
		list.setNextNode(new Node('b')).setNextNode(new Node('x')).setNextNode(new Node('a')).setNextNode(new Node('b')).setNextNode(new Node('c'))
				.setNextNode(new Node('a')).setNextNode(new Node('b')).setNextNode(new Node('c')).setNextNode(new Node('a')).setNextNode(new Node('b')).setNextNode(new Node('y'));
		return firstNode;
	}

	private static Node createSearchList() {   //a b c a b y  
		Node list = new Node('a');
		Node firstNode = list;
		list.setNextNode(new Node('b')).setNextNode(new Node('c')).setNextNode(new Node('a')).setNextNode(new Node('b')).setNextNode(new Node('y'));
		return firstNode;
	}

}
