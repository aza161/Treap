package Treap;

import java.util.Collections;
import java.util.List;

public class Treap<T extends Comparable<T>> implements Comparable<Treap<T>> {
    Node<T> head = null;
    private int size;

    public Treap(List<Node<T>> nodeList) {
        this.size = nodeList.size();
        nodeList.sort(Collections.reverseOrder());
        Node<T> prev, curr;
        for (Node<T> node : nodeList) {
            if (this.head == null) {
                this.head = node;
            } else {
                curr = this.head;
                prev = curr;
                while (curr != null) {
                    prev = curr;
                    curr = (curr.getValue().compareTo(node.getValue())) <= 0 ?
                            (curr.getRight()) :
                            (curr.getLeft());
                }
                node.setParent(prev);
                if (prev.getValue().compareTo(node.getValue()) <= 0)
                    prev.setRight(node);
                else
                    prev.setLeft(node);
            }
        }
    }

    public void insert(Node<T> node) {
        if (node == null) return;

        if (this.head == null)
            this.head = node;

        else {
            Node<T> curr = this.head, prev = null;
            while (curr != null) {
                prev = curr;
                curr = (curr.getValue().compareTo(node.getValue())) <= 0 ?
                        (curr.getRight()) :
                        (curr.getLeft());
            }
            node.setParent(prev);
            if (prev.getValue().compareTo(node.getValue()) <= 0)
                prev.setRight(node);
            else
                prev.setLeft(node);

            while (node.getParent() != null && node.compareTo(node.getParent()) > 0) {

                if (node.isLeftChild(node.getParent()))
                    rightRotate(node.getParent());
                else
                    leftRotate(node.getParent());

            }
        }
        ++this.size;
    }

    private void rightRotate(Node<T> node) {
        if (node == null || !node.hasLeft()) return;

        Node<T> leftChild = node.getLeft();
        Node<T> parent = node.getParent();
        leftChild.setParent(parent);

        if (parent == null)
            this.head = leftChild;

        else if (parent.getRight() == node)
            parent.setRight(leftChild);

        else
            parent.setLeft(leftChild);

        if (leftChild.hasRight()) {
            Node<T> temp = leftChild.getRight();
            temp.setParent(node);
            node.setLeft(temp);
        } else
            node.setLeft(null);

        leftChild.setRight(node);
        node.setParent(leftChild);
    }

    private void leftRotate(Node<T> node) {
        if (node == null || !node.hasRight()) return;
        Node<T> rightChild = node.getRight();
        Node<T> parent = node.getParent();

        rightChild.setParent(parent);

        if (parent == null)
            this.head = rightChild;

        else if (parent.getRight() == node)
            parent.setRight(rightChild);

        else
            parent.setLeft(rightChild);

        if (rightChild.hasLeft()) {
            Node<T> temp = rightChild.getLeft();
            temp.setParent(node);
            node.setRight(temp);
        } else
            node.setRight(null);

        rightChild.setLeft(node);
        node.setParent(rightChild);
    }

    public int getSize() {
        return size;
    }

    @Override
    public int compareTo(Treap<T> o) {
        return 0;
    }

    public void printTreap() {
        inOrder(this.head);
    }

    private void inOrder(Node<T> node) {
        if (node != null) {
            inOrder(node.getLeft());
            System.out.print("Value: \"" + node.getValue() + "\"" + " " + "Priority: \"" + node.getPri() + "\"\n");
            inOrder(node.getRight());
        }
    }
}
