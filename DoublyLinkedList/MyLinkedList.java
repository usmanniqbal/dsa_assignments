public class MyLinkedList<T> {

    private int _size;
    private Node<T> first;
    private Node<T> last;

    public int size() {
        return _size;
    }

    public boolean isEmpty() {
        return _size == 0;
    }

    public Node<T> getNode(int index) {
        if (index < 0 || index >= _size) {
            return null;
        }
        Node<T> cur = first;
        for (int i = 0; i <= index; i++) {
            if (i == index) {
                break;
            } else if (cur.NextNode != null) {
                cur = cur.NextNode;
            } else {
                break;
            }
        }
        return cur;
    }

    public Node<T> getNode(T value) {
        Node<T> cur = first;
        for (int i = 0; i < _size; i++) {
            if (cur.Value == value) {
                break;
            } else if (cur.NextNode != null) {
                cur = cur.NextNode;
            } else {
                break;
            }
        }
        return cur;
    }

    public boolean addFirst(T value) {
        var oldFirst = first;
        first = new Node<T>(value, null, oldFirst);
        if (oldFirst != null) {
            oldFirst.PreviousNode = first;
            first.NextNode = oldFirst;
        }
        if (last == null) {
            last = first;
        }
        _size++;
        return true;
    }

    public boolean addLast(T value) {
        var oldLast = last;
        last = new Node<>(value, oldLast, null);
        if (oldLast != null) {
            oldLast.NextNode = last;
            last.PreviousNode = oldLast;
        }
        if (first == null) {
            first = oldLast;
        }
        _size++;
        return true;
    }

    public boolean addAt(T value, int index) {
        if (index == 0) {
            return this.addFirst(value);
        } else if (index == _size) {
            return this.addLast(value);
        }
        var oldNode = getNode(index);
        if (oldNode == null) {
            return false;
        }
        var newNode = new Node<T>(value, oldNode.PreviousNode, oldNode);
        if (oldNode.PreviousNode != null) {
            oldNode.PreviousNode.NextNode = newNode;
        }
        oldNode.PreviousNode = newNode;
        _size++;
        return true;
    }

    public boolean remove(int index) {
        var node = getNode(index);
        return remove(node);
    }

    public boolean remove(T value) {
        var node = getNode(value);
        return remove(node);
    }

    private boolean remove(Node<T> node) {
        if (node != null) {
            if (node == first) {
                first = node.NextNode;
            }
            if (node == last) {
                last = node.PreviousNode;
            }
            if (node.PreviousNode != null) {
                node.PreviousNode.NextNode = node.NextNode;
            }
            if (node.NextNode != null) {
                node.NextNode.PreviousNode = node.PreviousNode;
            }
            _size--;
            return true;
        } else {
            return false;
        }
    }

    public void display() {
        var cur = first;
        for (int i = 0; i < _size; i++) {
            System.out.println(i + " - " + cur.Value);
            cur = cur.NextNode;
        }
    }
}