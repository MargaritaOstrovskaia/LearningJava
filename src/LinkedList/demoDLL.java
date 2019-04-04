package LinkedList;

public class demoDLL {
    public static void main(String[] args) {
        Integer[] datas = {1,2,3,4,5,6};
        DLList<Integer> list = new DLList<Integer>(datas);
        list.print("\nDouble Linked List: ");

        list.removeByIndex(4);
        list.print("\n\nDelete node 4: ");

        list.set(10,1);
        list.print("\n\nChange node 1: ");

        list.removeByIndex(0);
        list.print("\n\nDelete node 0: ");

        System.out.println("\n\nList size: " + list.getSize());

        list.reverse();
        list.print("\nReversed Double Linked List: ");
    }
}
