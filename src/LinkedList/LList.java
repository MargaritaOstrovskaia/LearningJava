package LinkedList;

public class LList {
	static LLNode firstNode;
	
	LList(LLNode firstNode) {
		this.firstNode = firstNode;
	}
	
	static int getCount() {
		LLNode temp = firstNode;
		int count = 1;//
		
		while (temp.nextNode != null)
		{
			count = count+1;
			temp = temp.nextNode;
		}
		
		return count;
	}
	
	void insertNode(LLNode node) {
		LLNode finishNode = lastNode();
		finishNode.nextNode = node;
	}
	
	static boolean insertNodeByIndex(LLNode node, int index) {
		int count = getCount() - 1;
		
		if (count >= index) {
			
			LLNode temp = firstNode;
	
			for(int i=1; i<index; i++) {
				temp = temp.nextNode;
			}
			
			LLNode next = temp.nextNode;
			temp.nextNode = node;
			node.nextNode = next;
			
			return true;
		}
		else
			return false;
	}
	
	static boolean deleteNode(LLNode node) {
		LLNode temp = firstNode;
		boolean result = false;
		LLNode preNode = null;
		
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
		LLNode preNode = null;
		
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
		LLNode prev = null;
		LLNode temp = firstNode;
		LLNode next = temp.nextNode;
		
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
		
		LLNode temp1 = firstNode;
		LLNode temp2 = null;
		
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
		LLNode temp = firstNode;
		System.out.print(str);
		
		do {
			System.out.print(temp.value + " ");
			temp = temp.nextNode;
		} while (temp != null);
		
		System.out.println();
	}
	
	// find last list node
	private LLNode lastNode() {
		LLNode temp = firstNode;
		
		while (temp.nextNode != null) {
			temp = temp.nextNode;
		}
		
		return temp;
	}
}