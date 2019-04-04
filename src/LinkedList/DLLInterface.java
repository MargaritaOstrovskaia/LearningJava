package LinkedList;

import java.util.ArrayList;

public interface DLLInterface<E> {
    DLLNode<E> getNode(int index);
    E getData(int index);
    int getFirstIndexByData(E data);
    ArrayList<Integer> getAllIndexesByData(E data);
    DLLNode<E> getNodeByData(E data);
    ArrayList<DLLNode<E>> getAllNodesByData(E data);

    DLLNode<E> add(E data);
    DLLNode<E> add(E data, int index);

    DLLNode<E> set(E data, int index);
    DLLNode<E> removeByIndex(int index);
    DLLNode<E> removeFirstElementByData(E data);
    ArrayList<DLLNode<E>> removeAllElementsByData(E data);

    void reverse();
    int getSize();
    void print(String str);
}
