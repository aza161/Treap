# Treap Implementation in Java

This project implements a Treap, a randomized binary search tree (BST) that maintains both the binary search tree property and the heap property. The nodes are ordered such that for any node, its left child's value is less than its value and its right child's value is greater, while the node's priority is greater than its children's priorities. This structure allows for efficient average-case operations.

## Features

- *Node Class*: Represents a single node in the Treap, holding a value, priority, and references to left, right, and parent nodes.
- *Treap Class*: Manages the Treap structure, providing methods to initialize the Treap with a list of nodes and retrieve the size and root of the Treap.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher

### Usage

1. Create a list of `Node` objects with values:
   ```java
   List<Node<Integer>> nodeList = new ArrayList<>();
   nodeList.add(new Node<>(10, 20));
   nodeList.add(new Node<>(5, 30));
   nodeList.add(new Node<>(15, 25));
   ```

2. Initialize the Treap with the list of nodes:
   ```java
   Treap<Integer> treap = new Treap<>(nodeList);
   ```

## Class Descriptions

### Node Class

#### Methods

- `T getValue()`: Returns the value of the node.
- `void setValue(T value)`: Sets the value of the node.
- `int getPri()`: Returns the priority of the node.
- `void setPri(int pri)`: Sets the priority of the node.
- `Node<T> getLeft()`: Returns the left child of the node.
- `void setLeft(Node<T> left)`: Sets the left child of the node.
- `Node<T> getRight()`: Returns the right child of the node.
- `void setRight(Node<T> right)`: Sets the right child of the node.
- `Node<T> getParent()`: Returns the parent of the node.
- `void setParent(Node<T> parent)`: Sets the parent of the node.

### Treap Class

#### Methods

- `Treap(List<Node<T>> nodeList)`: Initializes the Treap with a list of nodes, sorted by priority.
- `int getSize()`: Returns the size of the Treap.
- `void printTreap()`: Prints the Treap in order (Sorted in ascending order according to the nodes value).

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

### Contact

Ahmad - [ahmadalrabih3@gmail.com](mailto:ahmadalrabih3@gmail.com)

Project Link: [https://github.com/aza161/Treap](https://github.com/aza161/Treap)
