//Joey Cheung
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

class BSTPQ<K extends Comparable<K>> extends BST<K> implements PriorityQueue<K> {

	public void insert(K x) throws Exception {
		// TODO add this code
		add(x);
		return;
	}
	
	public K removeMin() throws Exception {
		// TODO add this code
		if (root() == null) throw new Exception("Empty");
		BinaryNode lower = (BinaryNode) root;
		while(lower.getLeft() != null) {
			lower = lower.getLeft();
		}
		K data = (K) lower;
		removeNode(lower);
		return data;
	}
}

// ---- main program to test priority queue methods

class E23145232 {
   public static Iterator<Integer> PQsort(Iterator<Integer> x) throws Exception {
      PriorityQueue<Integer> q = new BSTPQ<Integer>();
      while (x.hasNext()) {
         q.insert(x.next());
         System.out.println(q);
      }
      ArrayList<Integer> temp = new ArrayList<>();
      try {
         while (true) temp.add(q.removeMin());
      } catch (Exception e) {}
      return temp.iterator();
  }

  public static void main(String args[]) throws Exception {
     Random r = new Random();
     ArrayList<Integer> v = new ArrayList<>();
     for (int i = 0; i < 20; i++)
        v.add(r.nextInt(30));
     System.out.print("Unsorted: ");
     for (Integer x:v) System.out.print("" + x + " ");
     System.out.print("\n  Sorted: ");
     Iterator<Integer> sorted = PQsort(v.iterator());
     while (sorted.hasNext())  
        System.out.print("" + sorted.next() + " ");
     System.out.println();
  }
}
