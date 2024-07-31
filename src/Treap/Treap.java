package Treap;

import java.util.Collections;
import java.util.List;

public class Treap<T extends Comparable<T>> {
    private Node<T> head = null;
    private int size = 0;

    public Treap() {
    }

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

        /*for (Node<T> node : nodeList) {
            this.insert(node);
        }*/
    }

    public Node<T> getHead() {
        return this.head;
    }

    public int getSize() {
        return this.size;
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

    public Node<T> remove() {
        if (this.head == null) return null;

        if (!this.head.hasChild()) {
            Node<T> temp = this.head;
            this.head = null;
            --this.size;
            return temp;
        }


        Node<T> removed = this.head;

        while (removed.hasChild()) {

            if (removed.hasTwoChildren() && removed.getLeft().compareTo(removed.getRight()) >= 0)
                rightRotate(removed);

            else if (removed.hasTwoChildren() && removed.getLeft().compareTo(removed.getRight()) < 0)
                leftRotate(removed);

            else if (removed.hasLeft())
                rightRotate(removed);

            else
                leftRotate(removed);
        }

        Node<T> parent = removed.getParent();

        if (parent != null && parent.getLeft() == removed)
            parent.setLeft(null);

        else if (parent != null)
            parent.setRight(null);

        --this.size;

        return removed;
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
