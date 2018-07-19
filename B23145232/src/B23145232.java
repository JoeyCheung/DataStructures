// Joey Cheung
import java.util.Scanner;

public class B23145232 {
	public static void main(String args[]) {
		System.out.println("Homework B by Joey Cheung"); // fill in your name here
		Deque<String> q = new ArrayDeque<>();
		Deque<String> qLink = new LinkedDeque<>();
		testDeque(q, qLink); // test both together
	}

	public static void testDeque(Deque<String> q, Deque<String> qLink) {
		boolean done = false;
		Scanner sc = new Scanner(System.in);
		while (!done) {
			try {
				System.out.println(" Array queue: " + q + "  ");
				System.out.print("Linked queue: " + qLink + "      ");
				System.out.println("\ncmds are a r A R Q: >>");
				String cmd = sc.next();
				String entry = null;
				char command = cmd.charAt(0);
				if (command == 'a' || command == 'A')
					entry = sc.next();
				switch (cmd.charAt(0)) {
				case 'Q':
					done = true;
					break;
				case 'a':
					q.addFront(entry);
					qLink.addFront(entry);
					break;
				case 'A':
					q.addRear(entry);
					qLink.addRear(entry);
					break;
				case 'r':
					q.removeFront();
					qLink.removeFront();
					break;
				case 'R':
					q.removeRear();
					qLink.removeRear();
					break;
				}
			} catch (Exception e) {
				System.out.println("Error " + e.toString());
			}
		}
		sc.close();
	}
}

interface Deque<T> {
	public T removeFront() throws Exception;

	public T removeRear() throws Exception;

	public void addFront(T x) throws Exception;

	public void addRear(T x) throws Exception;

	public boolean empty();

	public int size();
}

class ArrayDeque<T> implements Deque<T> {
	private T data[];
	private int front, rear, size, capacity;

	public ArrayDeque() {
		capacity = 1000;
		data = (T[]) new Object[capacity];
		front = size = 0;
		rear = 1;
	}

	public ArrayDeque(int c) {
		capacity = c;
		data = (T[]) new Object[capacity];
		front = size = 0;
		rear = 1;
	}

	public int size() {
		return size;
	}

	public boolean empty() {
		return size == 0;
	}

	public void addFront(T x) throws Exception {
		if (size() == capacity)
			throw new Exception("Deque Full");
		data[front--] = x;
		if (front < 0)
			front = capacity - 1;
		size++;
	}

	public void addRear(T x) throws Exception {
		if (size() == capacity)
			throw new Exception("Deque Full");
		data[rear++] = x;
		if (rear == capacity)
			rear = 0;
		size++;
	}

	public T removeFront() throws Exception {
		if (empty())
			throw new Exception("Deque Empty");
		front = front + 1;
		if (front == capacity)
			front = 0;
		size--;
		return data[front];
	}

	public T removeRear() throws Exception {
		if (empty())
			throw new Exception("Deque Empty");
		rear = rear - 1;
		if (rear == -1)
			rear = capacity - 1;
		size--;
		return data[rear];
	}

	// methods for testing purposes
	public String toString() {
		int i, j;
		String ans = "";
		for (i = 0, j = front + 1; i < size; i++, j++) {
			if (j == capacity)
				j = 0;
			ans += data[j];
			if (i < size - 1) ans += " -> ";
		}
		return ans;
	}

}

class DNode<T> {
	private T data;
	private DNode<T> prev, next;

	public DNode(T x, DNode<T> p, DNode<T> n) {
		data = x;
		prev = p;
		next = n;
	}

	public T getData() {
		return data;
	}

	public DNode<T> getNext() {
		return next;
	}

	public DNode<T> getPrev() {
		return prev;
	}

	public void setData(T x) {
		data = x;
	}

	public void setNext(DNode<T> n) {
		next = n;
	}

	public void setPrev(DNode<T> p) {
		prev = p;
	}
}

class LinkedDeque<T> implements Deque<T> {
	private DNode<T> front;
	private DNode<T> rear;
	private int size;

	// add implementations for the following methods
	// your code should perform in exactly the same way as the corresponding
	// ArrayDeque<T> methods
	// you should not add any extra instance variables to the class and must
	// use a doubly linked list implementation.

	public LinkedDeque() {
		// add implementation
		front = rear = null;
		size = 0;
	}

	public int size() {
		// add implementation
		return size;
	}

	public boolean empty() {
		// add implementation
		return size == 0;
	}

	public T removeFront() throws Exception {
		// add implementation
		if (empty()) throw new Exception("Invalid");
		T data = front.getData();
		front = front.getNext();
		size--;
		if (front == null) rear = front;
		return data;
	}

	public T removeRear() throws Exception {
		// add implementation
		if (empty()) throw new Exception("Invalid");
		T data = rear.getData();
		rear = rear.getPrev();
		size--;
		if (rear == null) front = rear;
		return data;
	}

	public void addRear(T x) throws Exception {
		// add implementation
		DNode<T> r = new DNode<>(x, null, null);
		if (empty()) {
			front = r;
		}
		else {
			rear.setNext(r);
			r.setPrev(rear);
		}
		rear = r;
		size++;
	}

	public void addFront(T x) throws Exception {
		DNode<T> f = new DNode<>(x, null, null);
		if (empty()) {
			rear = f;
		}
		else {
			f.setNext(front);
			front.setPrev(f);
		}
		front = f;
		size++;
	}

	public String toString() {
		// add implementation
		String ans = "";
		DNode<T> n = front;
		while (n != null) {
			ans += n.getData();
			if (n == rear) break;
			if (size > 1) ans += " -> ";
	        n = n.getNext();
	    }
		return ans;
	}
}