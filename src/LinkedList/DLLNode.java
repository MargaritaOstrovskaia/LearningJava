package LinkedList;

public class DLLNode<E> {
    DLLNode<E> next;
    DLLNode<E> prev;
    E data;

    public DLLNode(E data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
