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
