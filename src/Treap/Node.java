package Treap;

import java.time.Clock;
import java.util.Random;

public class Node<T extends Comparable<T>> implements Comparable<Node<T>> {
    private T value;
    private int pri;
    private Node<T> left;
    private Node<T> right;
    private Node<T> parent;
    private final Random r = new Random(Clock.systemUTC().instant().toEpochMilli());

    public Node(T value) {
        this.value = value;
        this.pri = r.nextInt();
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

    public void setValue(T value) {
        this.value = value;
    }

    public int getPri() {
        return pri;
    }

    public void setPri(int pri) {
        this.pri = pri;
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

    @Override
    public int compareTo(Node<T> o) throws ClassCastException {
        return Integer.compare(this.pri, o.pri);
    }
}
