
public interface PriorityQueue<K extends Comparable<K>> {
   public void insert(K x) throws Exception;
   public K removeMin() throws Exception;
}
