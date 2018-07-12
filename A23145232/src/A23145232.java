import java.util.Scanner;

// doubly linked list, uses a cursor and no sentinels.

public class A23145232<T> {
	private DNode<T> cursor;
	private int size;

	public A23145232() {
		size = 0;
		cursor = null;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public void advance() { // CHANGE CODE HERE
		if (cursor == null || cursor.getNext() == null) {
			throw new IllegalArgumentException("Invalid");
		}
		else 
			cursor = cursor.getNext();
	}

	public void goBack() { // CHANGE CODE HERE
		if (cursor == null || cursor.getPrev() == null) {
			throw new IllegalArgumentException("Invalid");
		}
		else 
			cursor = cursor.getPrev();
	}

	public void addBefore(T d) { // CHANGE CODE HERE
		DNode <T> p;
		if (cursor == null) {
			 p = new DNode<T>(d, null, null);
			cursor = p;
		}
		else {
			p = new DNode<T>(d, null, cursor);
			cursor.setPrev(p);
		}
	}

	public void addAfter(T d) { // CHANGE CODE HERE
		DNode <T> n;
		if (cursor == null) {
			n = new DNode<T>(d, null, null);
			cursor = n;
		}
		else {
			n = new DNode<T>(d, cursor, null);
			cursor.setNext(n);
		}
	}

	public T remove() { // CHANGE CODE HERE
		if (cursor == null) throw new RuntimeException("Empty");
		T data = cursor.getData();
		if (cursor.getNext() == cursor) {
			cursor = null;
			return data;
		}
		cursor.setNext(cursor.getNext().getNext());
		return data;
	}

	// LinkedList testing methods:
	public String toString() {
		String ans = "List status (cursor marked as ^^):  ";
		DNode<T> n = cursor;
		ans += "(^^)<-->";
		for (int i = 0; i < size; i++, n = n.getNext())
			ans += (n.getData() + "<-->");
		ans += "(^^)";
		return ans;
	}

	public static void main(String args[]) {
		
		A23145232<String> l = new A23145232<>();
		boolean done = false;
		Scanner s = new Scanner(System.in);
		while (!done) {
			try {
				System.out.println(l);
				System.out
						.println("\ncmds are H(elp) B(efore) A(fter) R(emove) + - Q(uit): >>");
				String cmd = s.next();
				String entry = null;
				char command = cmd.trim().toUpperCase().charAt(0);
				if (command == 'B' || command == 'A')
					entry = s.next();
				switch (command) {
				case 'H':
					giveHelp();
					break;
				case 'Q':
					done = true;
					break;
				case 'R':
					l.remove();
					break;
				case '+':
					l.advance();
					break;
				case '-':
					l.goBack();
					break;
				case 'B':
					l.addBefore(entry);
					break;
				case 'A':
					l.addAfter(entry);
					break;
				}
			} catch (Exception e) {
				System.out.println("Error " + e.toString());
			}
		}
		s.close();
	}

	private static void giveHelp() {
		String help = "Commands are:  H for help, Q to quit\n"
				+ " + or - to move the cursor forwards of backwards in the list\n"
				+ " A data, B data to insert data After or Before the cursor \n"
				+ " R to remove the cursor node from the list.";
		System.out.println(help);
	}
}

class DNode<T> {
	private T data;
	private DNode<T> prev, next;

	public DNode(T d, DNode<T> p, DNode<T> n) {
		data = d;
		next = n;
		prev = p;
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

	public void setData(T d) {
		data = d;
	}

	public void setNext(DNode<T> n) {
		next = n;
	}

	public void setPrev(DNode<T> p) {
		prev = p;
	}
}
