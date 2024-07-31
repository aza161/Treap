import Treap.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Node<Integer>> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            list.add(new Node<Integer>(x, y));
        }
        //10 10 35 20 10 30 56 40 42 50 25 60 17 70 80 80 65 90 15 95 32
        Treap<Integer> tree = new Treap<Integer>(list);
        tree.printTreap();
        System.out.printf("Treap size before insertion: %d\n", tree.getSize());
        tree.insert(new Node<Integer>(45, 67));
        System.out.println("\nAfter inserting (45, 67):\n");
        tree.printTreap();
        System.out.printf("Treap size after insertion: %d\n", tree.getSize());
        while (tree.getSize() > 0) {
            System.out.println(tree.remove().getPri());
        }

    }
}