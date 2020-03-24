import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();

        linkedList.addFirst(50);
        linkedList.addFirst(40);
        linkedList.addFirst(30);
        linkedList.addFirst(20);
        linkedList.addFirst(10);

        linkedList.addLast(60);
        linkedList.addLast(70);
        linkedList.addLast(80);

        linkedList.addAt(45, 4);

        linkedList.addAt(90, 9);
        linkedList.addAt(5, 0);

        linkedList.remove(0);
        linkedList.remove(9);
        linkedList.remove((Integer) 45);

        linkedList.display();
        // LinkedList l;
        // l.size();
        // l.get(index);
        // l.add
    }
}