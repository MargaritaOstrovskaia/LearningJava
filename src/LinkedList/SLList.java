package LinkedList;

import java.util.ArrayList;

public class SLList<E> implements SLLInterface<E> {
    private SLLNode<E> head;
    private int size;

    private void init(){
        size = 0;
        head = new SLLNode<E>(null);
    }

    private void addNewNode(SLLNode<E> lastNode, E data) {
        SLLNode<E> node = new SLLNode<E>(data);
        node.next = lastNode.next;
        lastNode.next = node;
        size += 1;
    }

    public SLList() {
        init();
    }

    public SLList(Object[] objects) {
        init();

        SLLNode<E> target = head;
        for (Object o : objects) {
            addNewNode(target, (E)o);
            target = target.next;
        }
    }

    @Override
    public SLLNode<E> getNode(int index) {
        if (size <= index || index < 0)
            throw new IndexOutOfBoundsException();

        int i = 0;
        SLLNode<E> target = head;
        while (i <= index) {
            target = target.next;
            i++;
        }

        return target;
    }

    @Override
    public E getData(int index) {
        if (size <= index || index < 0)
            throw new IndexOutOfBoundsException();

        SLLNode<E> node = getNode(index);
        return node.data;
    }

    @Override
    public void add(E data) {
        if(size == 0) {
            addNewNode(head, data);
            return;
        }

        SLLNode<E> lastNode = getNode(size-1);
        addNewNode(lastNode, data);
    }

    @Override
    public void add(E data, int index) {
        if(index == 0) {
            addNewNode(head, data);
            return;
        }

        if (size < index || index < 0)
            throw new IndexOutOfBoundsException();

        if(index == size-1 || size == 0)
            add(data);

        SLLNode<E> lastNode = getNode(index-1);
        addNewNode(lastNode, data);
    }

    @Override
    public void set(E data, int index) {
        if (size < index || index < 0)
            throw new IndexOutOfBoundsException();

        int i = 0;
        SLLNode<E> target = head;
        while (i <= index) {
            target = target.next;
            i++;
        }

        target.data = data;
    }

    private void remove(SLLNode<E> lastNode) {
        lastNode.next = lastNode.next.next;
        size--;
    }

    @Override
    public void removeByIndex(int index) {
        if (size <= index || index < 0)
            throw new IndexOutOfBoundsException();

        if(index == 0) {
            remove(head);
            return;
        }

        SLLNode<E> lastNode = getNode(index-1);
        remove(lastNode);
    }

    @Override
    public void removeFirstElementByData(E data) {
        SLLNode<E> target = head;
        while (target.next != null) {
            if(target.next.data == data) {
                remove(target);
                return;
            }

            target = target.next;
        }
    }

    @Override
    public void removeAllElementsByData(E data) {
        ArrayList<SLLNode<E>> lastNodes = new ArrayList<>();

        SLLNode<E> target = head;
        while (target.next != null) {
            if(target.next.data == data)
                lastNodes.add(target);

            target = target.next;
        }

        for(SLLNode<E> node : lastNodes)
            remove(node);
    }

    @Override
    public void reverse() {
        if (size < 2)
            return; // 3

        SLLNode<E> last = head.next; // element 0
        SLLNode<E> target = last.next; // element 1
        SLLNode<E> next = target.next; // element 2

        last.next = null;
        do
        {
            target.next = last;

            // next step
            last = target;
            target = next;
            next = target.next;
        } while(next != null);

        target.next = last;
        head.next = target;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void print(String str) {
        if (str != null)
            System.out.println(str);

        if (size > 0) {
            int i = 0;
            SLLNode<E> target = head;
            while (i < size) {
                target = target.next;
                i++;
                System.out.print(target.data.toString() + " ");
            }
        }
    }
}
