package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<E extends Comparable<? super E>> {
    BSTNode<E> root;

    /*** Insert new node in tree */

    public boolean insert(E value) {
        BSTNode<E> node = root;
        int comp = value.compareTo(node.getValue());

        while ( (comp < 0 && node.getLeftChild() != null) ||
                (comp > 0 && node.getRightChild() != null) )
        {
            if(comp > 0)
                node = node.getRightChild();
            else
                node = node.getLeftChild();

            comp = value.compareTo(node.getValue());
        }

        if (comp > 0)
            node.setRightChild(value);
        else if (comp < 0)
            node.setLeftChild(value);
        else
            return false;

        return true;
    }

    /*** Searching in Binary Search Tree */

    public boolean search(E value) {
        BSTNode<E> node = root;
        int comp;
        while (node != null) {
            comp = value.compareTo(node.getValue());

            if(comp < 0)
                node = node.getLeftChild();
            else if(comp > 0)
                node = node.getRightChild();
            else
                return true;
        }

        return  false;
    }

    /*** Breadth First Traversal */

    // level-order traversal
    public void levelOrder() {
        Queue<BSTNode<E>> queue = new LinkedList<BSTNode<E>>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BSTNode<E> node = queue.remove();
            if(node != null) {
                node.visit();
                queue.add(node.getLeftChild());
                queue.add(node.getRightChild());
            }
        }
    }

    /*** Deep First Traversals */

    // in-order traversal: visit left subtree / visit yourself / visit right subtree
    public void inOrder() {
        this.inOrder(root);
    }

    private void inOrder(BSTNode<E> node) {
        if(node != null) {
            preOrder(node.getLeftChild());
            node.visit();
            preOrder(node.getRightChild());
        }
    }

    // post-order traversal: visit left subtree / visit right subtree / visit yourself
    public void postOrder() {
        this.postOrder(root);
    }

    private void postOrder(BSTNode<E> node) {
        if(node != null) {
            preOrder(node.getLeftChild());
            preOrder(node.getRightChild());
            node.visit();
        }
    }

    // pre-order traversal: visit yourself / visit left subtree / visit right subtree
    public void preOrder() {
        this.preOrder(root);
    }

    private void preOrder(BSTNode<E> node) {
        if(node != null) {
            node.visit();
            preOrder(node.getLeftChild());
            preOrder(node.getRightChild());
        }
    }

    /*** Getters & Setters */

    public BSTNode<E> getRoot() {
        return root;
    }
}
