package LinkedList;

import java.util.ArrayList;

public class DLList<E> implements DLLInterface<E> {
    private DLLNode<E> head;
    private DLLNode<E> tail;
    private int size;

    private void init(){
        size = 0;
        head = new DLLNode<E>(null);
        tail = new DLLNode<E>(null);
        head.next = tail;
        tail.prev = head;
    }

    private DLLNode<E> addNewNode(DLLNode<E> lastNode, E data) {
        DLLNode<E> node = new DLLNode<E>(data);
        node.prev = lastNode;
        node.next = lastNode.next;

        lastNode.next.prev = node;
        lastNode.next = node;

        size += 1;
        return node;
    }

    public DLList() {
        init();
    }

    public DLList(Object[] objects) {
        init();

        DLLNode<E> target = head;
        for (Object o : objects) {
            addNewNode(target, (E)o);
            target = target.next;
        }
    }

    @Override
    public DLLNode<E> add(E data) {
        DLLNode<E> node = addNewNode(tail.prev, data);
        return node;
    }

    @Override
    public DLLNode<E> add(E data, int index) {
        if (size < index || index < 0)
            throw new IndexOutOfBoundsException();

        if(index == size-1 || size == 0)
            return add(data);

        DLLNode<E> lastNode = getNode(index-1);
        DLLNode<E> node = addNewNode(lastNode, data);

        return node;
    }

    @Override
    public DLLNode<E> set(E data, int index) {
        if (size < index || index < 0)
            throw new IndexOutOfBoundsException();

        int i = 0;
        DLLNode<E> target = head;
        while (i <= index) {
            target = target.next;
            i++;
        }

        target.data = data;
        return target;
    }

    private DLLNode<E> remove(DLLNode<E> node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;

        size--;
        return node;
    }

    @Override
    public DLLNode<E> removeByIndex(int index) {
        if (size <= index || index < 0)
            throw new IndexOutOfBoundsException();

        int i = 0;
        DLLNode<E> target = head;
        while (i <= index) {
            target = target.next;
            i++;
        }

        return remove(target);
    }

    @Override
    public DLLNode<E> removeFirstElementByData(E data) {
        DLLNode<E> node = getNodeByData(data);

        if(node == null)
            return null;

        return remove(node);
    }

    @Override
    public ArrayList<DLLNode<E>> removeAllElementsByData(E data) {
        ArrayList<DLLNode<E>> nodes = getAllNodesByData(data);
        if(nodes == null)
            return null;

        for(DLLNode<E> node : nodes)
            remove(node);

        return nodes;
    }

    @Override
    public void print(String str) {
        if (str != null)
            System.out.println(str);

        if (size > 0) {
            int i = 0;
            DLLNode<E> target = head;
            while (i < size) {
                target = target.next;
                i++;
                System.out.print(target.data.toString() + " ");
            }
        }
    }

    private ArrayList<DLLNode<E>> getElementsByData(E data, boolean isAllNodes) {
        ArrayList<DLLNode<E>> nodes = new ArrayList<>();

        DLLNode<E> target = head;
        int i = 0;
        while (i < size) {
            target = target.next;

            if(target.data == data) {
                nodes.add(target);

                if(!isAllNodes)
                    return nodes;
            }

            i++;
        }

        return nodes;
    }

    @Override
    public DLLNode<E> getNodeByData(E data) {
        ArrayList<DLLNode<E>> nodes = getElementsByData(data, false);
        if (nodes.size() == 0)
            return  null;

        return nodes.get(0);
    }

    @Override
    public ArrayList<DLLNode<E>> getAllNodesByData(E data) {
        ArrayList<DLLNode<E>> nodes = getElementsByData(data, true);
        if (nodes.size() == 0)
            return  null;

        return nodes;
    }

    private ArrayList<Integer> getIndexesByData(E data, boolean isAllIndexes) {
        ArrayList<Integer> indexes = new ArrayList<>();

        DLLNode<E> target = head;
        int i = 0;
        while (i < size) {
            target = target.next;

            if(target.data == data) {
                indexes.add(i);

                if(!isAllIndexes)
                    return indexes;
            }

            i++;
        }

        return indexes;
    }

    @Override
    public int getFirstIndexByData(E data) {
        ArrayList<Integer> indexes = getIndexesByData(data, false);
        if (indexes.size() == 0)
            return -1;

        return indexes.get(0);
    }

    @Override
    public ArrayList<Integer> getAllIndexesByData(E data) {
        ArrayList<Integer> indexes = getIndexesByData(data, true);

        return indexes;
    }

    @Override
    public DLLNode<E> getNode(int index) {
        if (size <= index || index < 0)
            throw new IndexOutOfBoundsException();

        int i = 0;
        DLLNode<E> target = head;
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

        DLLNode<E> node = getNode(index);
        return node.data;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void reverse() {
        DLLNode<E> target = head.next;
        if (target.next == null)
            return;

        tail = head;
        do
        {
            DLLNode<E> temp = target.next;
            target.next = target.prev;
            target.prev = temp;

            target = temp;
        } while(target.next != null);

        target.next = target.prev;
        target.prev = null;
        head = target;
    }
}
