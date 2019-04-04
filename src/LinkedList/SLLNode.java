package LinkedList;

public class SLLNode<E> {
    SLLNode<E> next;
    E data;

    public SLLNode() {
        this.next = null;
        this.data = null;
    }

    public SLLNode(E theData) {
        this.data = theData;
    }

    public SLLNode(E theData, SLLNode<E> prevNode) {
        this(theData);
        this.next = prevNode.next;
        prevNode.next = this;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
