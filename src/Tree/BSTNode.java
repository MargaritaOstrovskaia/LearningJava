package Tree;

public class BSTNode<E> {
    private E value;

    private BSTNode<E> parent;   // parent node
    private BSTNode<E> left;     // left child node
    private BSTNode<E> right;    // right child node

    public BSTNode(E value, BSTNode<E> parent) {
        this.value = value;
        this.parent = parent;
        this.left = null;
        this.right = null;
    }

    public BSTNode<E> addLeftChild(E value) {
        this.left = new BSTNode<E>(value, this);
        return this.left;
    }

    public BSTNode<E> addRightChild(E value) {
        this.right = new BSTNode<E>(value, this);
        return this.right;
    }

    public void visit() {
        System.out.print(value.toString() + " ");
    }

    /*** Getters & Setters */

    public E getValue() {
        return value;
    }

    public BSTNode<E> getLeftChild() {
        return this.left;
    }

    public BSTNode<E> getRightChild() {
        return this.right;
    }

    public void setLeftChild(E value) {
        BSTNode<E> node = new BSTNode<E>(value, this);
        this.left = node;
    }

    public void setRightChild(E value) {
        BSTNode<E> node = new BSTNode<E>(value, this);
        this.right = node;
    }
}
