package Treap;

import java.time.Clock;
import java.util.Random;

public class Node<T extends Comparable<T>> implements Comparable<Node<T>> {
    private final T value;
    private int pri;
    private Node<T> left;
    private Node<T> right;
    private Node<T> parent;

    public Node(T value) {
        this.value = value;
        Random r = new Random(Clock.systemUTC().instant().toEpochMilli());
        this.pri = Math.abs(r.nextInt());
        this.left = null;
        this.right = null;
        this.parent = null;
    }

    public Node(T value, int pri) {
        this.value = value;
        this.pri = pri;
        this.left = null;
        this.right = null;
        this.parent = null;
    }

    public Node(T value, Node<T> left, Node<T> right) {
        this(value);
        this.left = left;
        this.right = right;
    }

    public Node(T value, Node<T> left, Node<T> right, Node<T> parent) {
        this(value, left, right);
        this.parent = parent;
    }

    public Node(T value, int pri, Node<T> left, Node<T> right) {
        this(value, pri);
        this.left = left;
        this.right = right;
    }

    public Node(T value, int pri, Node<T> left, Node<T> right, Node<T> parent) {
        this(value, left, right, parent);
        this.pri = pri;
    }

    public T getValue() {
        return value;
    }

    public int getPri() {
        return pri;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    public Node<T> getParent() {
        return parent;
    }

    public void setParent(Node<T> parent) {
        this.parent = parent;
    }

    public boolean hasLeft() {
        return this.getLeft() != null;
    }

    public boolean hasRight() {
        return this.getRight() != null;
    }

    public boolean hasChild() {
        return this.hasLeft() || this.hasRight();
    }

    public boolean hasTwoChildren() {
        return this.hasLeft() && this.hasRight();
    }

    public boolean isLeftChild(Node<T> parent) {
        if (parent == null)
            return false;

        else
            return parent.getLeft() == this;
    }

    public boolean isRightChild(Node<T> parent) {
        if (parent == null)
            return false;

        else
            return parent.getRight() == this;
    }

    @Override
    public int compareTo(Node<T> o) {
        return Integer.compare(this.pri, o.pri);
    }
}
