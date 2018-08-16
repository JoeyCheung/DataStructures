import java.util.Scanner;
import Node.java;

public class LinkedList<T> {
    private Node<T> head, tail;
    private int size;

    public LinkedList() {
        head = tail = null;
        size = 0;
    }

    public int size() { return size; }

    public boolean isEmpty() { return size == 0; }

    public void addHead(T d) {
        Node<T> fun = new Node<>(d, head);
        head = n;
        size++;
        if (tail == null) { tail = head; }

    }

    public void addTail(T d) {
        Node<T> fun = new Node<>(d, null);
        if (tail == null) head = tail = fun;
        else {
            tail.setNext(fun);
            tail = fun;
        }
        size++;
    }

    public T removeHead() throws Exception {

    }

    public T removeTail() throws Exception {

    }

}
