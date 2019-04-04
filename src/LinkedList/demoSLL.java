package LinkedList;

public class demoSLL {
    public static void main(String[] args) {
        Integer[] datas = {1,2,3,4,5,6};
        SLList<Integer> list = new SLList<>(datas);
        list.print("\nSingle Linked List: ");

        list.removeByIndex(2);
        list.print("\nDelete node 2: ");

        list.add(11, 5);
        list.print("\nSingle Linked List: ");

        list.set(10,1);
        list.print("\nChange node 1: ");

        list.removeByIndex(0);
        list.print("\nDelete node 0: ");

        list.reverse();
        list.print("\nReversed Single Linked List: ");

        System.out.println("\nList size: " + list.getSize());
    }
}
