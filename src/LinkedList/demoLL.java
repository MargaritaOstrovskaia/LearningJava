package LinkedList;

public class demoLL {

	public static void main(String[] args) {
		LLNode d = new LLNode(1,null);
		LLNode c = new LLNode(0,d);
		LLNode b = new LLNode(8,c);
		LLNode a = new LLNode(5,b);
		
		LList linkedList = new LList(a);
		linkedList.printList("Create new LList: ");
		
		LLNode e = new LLNode(3,null);
		linkedList.insertNode(e);
		linkedList.printList("Add new LLNode(3): ");
		
		LLNode f = new LLNode(1,null);
		boolean insert = LList.insertNodeByIndex(f,2);
		if (insert)
			linkedList.printList("Insert new LLNode(1) on position 2: ");
		else
			linkedList.printList("Can't insert new LLNode(1) on position 2. ");
			
		boolean delete1 = LList.deleteNode(c);
		if (delete1)
			linkedList.printList("Delete c = LLNode(0,d): ");
		else
			linkedList.printList("Can't delete LLNode.");
		
		boolean delete2 = LList.deleteNodeByIndex(3);
		if (delete2)
			linkedList.printList("Delete LLNode with index = 3: ");
		else
			linkedList.printList("Can't delete LLNode.");
		
		LList.reverseList();
		linkedList.printList("Reverse: ");
		
		if (LList.hasLoop())
			linkedList.printList("Has Loop.");
		else
			linkedList.printList("Hasn't Loop.");
		
		LLNode l = new LLNode(9,linkedList.firstNode);
		linkedList.insertNode(l);
		if (LList.hasLoop())
			System.out.print("Has Loop.");
		else
			System.out.print("Hasn't Loop.");
	}
}