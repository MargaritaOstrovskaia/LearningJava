package LinkedList;

import java.util.ArrayList;

public interface SLLInterface<E> {
    SLLNode<E> getNode(int index);
    E getData(int index);

    void add(E data);
    void add(E data, int index);

    void set(E data, int index);
    void removeByIndex(int index);
    void removeFirstElementByData(E data);
    void removeAllElementsByData(E data);

    void reverse();
    int getSize();
    void print(String str);
}
