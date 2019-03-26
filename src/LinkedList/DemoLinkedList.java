package LinkedList;

public class DemoLinkedList {

	public static void main(String[] args) {
		Node d = new Node(1,null);
		Node c = new Node(0,d);
		Node b = new Node(8,c);
		Node a = new Node(5,b);
		
		LinkedList linkedList = new LinkedList(a);
		linkedList.printList("Create new LinkedList: ");
		
		Node e = new Node(3,null);
		linkedList.insertNode(e);
		linkedList.printList("Add new Node(3): ");
		
		Node f = new Node(1,null);
		boolean insert = LinkedList.insertNodeByIndex(f,2);
		if (insert)
			linkedList.printList("Insert new Node(1) on position 2: ");
		else
			linkedList.printList("Can't insert new Node(1) on position 2. ");
			
		boolean delete1 = LinkedList.deleteNode(c);
		if (delete1)
			linkedList.printList("Delete c = Node(0,d): ");
		else
			linkedList.printList("Can't delete Node.");
		
		boolean delete2 = LinkedList.deleteNodeByIndex(3);
		if (delete2)
			linkedList.printList("Delete Node with index = 3: ");
		else
			linkedList.printList("Can't delete Node.");
		
		LinkedList.reverseList();
		linkedList.printList("Reverse: ");
		
		if (LinkedList.hasLoop())
			linkedList.printList("Has Loop.");
		else
			linkedList.printList("Hasn't Loop.");
		
		Node l = new Node(9,linkedList.firstNode);
		linkedList.insertNode(l);
		if (LinkedList.hasLoop())
			System.out.print("Has Loop.");
		else
			System.out.print("Hasn't Loop.");
	}
}