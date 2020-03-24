/**
 * Node
 */
public class Node<T> {
    T Value;
    Node<T> PreviousNode;
    Node<T> NextNode;

    public Node(T value) {
        Value = value;
    }

    public Node(T value, Node<T> prevNode, Node<T> nextNode) {
        this(value);
        PreviousNode = prevNode;
        NextNode = nextNode;
    }
}