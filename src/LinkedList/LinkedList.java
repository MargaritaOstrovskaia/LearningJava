package LinkedList;

public class LinkedList {
	static Node firstNode;
	
	LinkedList(Node firstNode) {
		this.firstNode = firstNode;
	}
	
	static int getCount() {
		Node temp = firstNode;
		int count = 1;//
		
		while (temp.nextNode != null)
		{
			count = count+1;
			temp = temp.nextNode;
		}
		
		return count;
	}
	
	void insertNode(Node node) {
		Node finishNode = lastNode();
		finishNode.nextNode = node;
	}
	
	static boolean insertNodeByIndex(Node node, int index) {
		int count = getCount() - 1;
		
		if (count >= index) {
			
			Node temp = firstNode;
	
			for(int i=1; i<index; i++) {
				temp = temp.nextNode;
			}
			
			Node next = temp.nextNode;
			temp.nextNode = node;
			node.nextNode = next;
			
			return true;
		}
		else
			return false;
	}
	
	static boolean deleteNode(Node node) {
		Node temp = firstNode;
		boolean result = false;
		Node preNode = null;
		
		while (temp.nextNode != null)
		{
			if(temp == node) {
				if (preNode != null) {
					preNode.nextNode = node.nextNode;
					temp.nextNode = null;
				}
				else {
					node = temp.nextNode;
					temp.nextNode = null;
					firstNode = node;
				}
				
				result = true;
			}
			else {
				preNode = temp;
				temp = temp.nextNode;
			}
		}
		
		return result;
	}
	
	static boolean deleteNodeByIndex(int index) {
		Node preNode = null;
		
		for(int i=0; i<=index; i++) {
			if(i==index) { // delete
				if(preNode == null)
					firstNode = firstNode.nextNode;
				else
					preNode.nextNode = preNode.nextNode.nextNode;
				
				return true;
			}
			else { // go to next node
				if(preNode == null)
					preNode = firstNode;
				else
					preNode = preNode.nextNode;
			}
		}
		
		return false;
	}
	
	static void reverseList() {
		Node prev = null;
		Node temp = firstNode;
		Node next = temp.nextNode;
		
		do
		{
			temp.nextNode = prev;
			
			prev = temp;
			temp = next;
			next = temp.nextNode;
		}
		while (next != null);
		
		temp.nextNode = prev;
		firstNode = temp;
	}
	
	// is it loop?
	static boolean hasLoop() {
		
		Node temp1 = firstNode;
		Node temp2 = null;
		
		if (firstNode.nextNode != null & firstNode.nextNode.nextNode != null)
			temp2 = firstNode.nextNode.nextNode;
		
		while(temp1.nextNode != null & temp2.nextNode.nextNode != null)
		{
			if(temp1 == temp2)
				return true;
			else {
				temp1 = temp1.nextNode;
				temp2 = temp2.nextNode.nextNode;
			}
		}
		
		return false;
	}
	
	void printList(String str) {
		Node temp = firstNode;
		System.out.print(str);
		
		do {
			System.out.print(temp.value + " ");
			temp = temp.nextNode;
		} while (temp != null);
		
		System.out.println();
	}
	
	// find last list node
	private Node lastNode() {
		Node temp = firstNode;
		
		while (temp.nextNode != null) {
			temp = temp.nextNode;
		}
		
		return temp;
	}
}