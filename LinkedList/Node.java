public class Node<T> {
    private T data;
    private Node<T> next;

    public Node() {
        data = null;
        next = null;
    }

    public Node(T d, Node<T> n) {
        data = d;
        next = n;
    }

    public void setNext(Node<T> n) { next = n; }

    public Node<T> getNext() { return next; }

    public void setData(T d) { data = d; }

    public T getData() { return data; }

    public String toString() {
      Node<T> seenBefore = this;
      String ans = "";
      int count = 0;
      Node<T> node = this;
      while (node != null) {
         ans += node.getData();
         ans += "-->";
         node = node.getNext();
         if (++count % 2 == 0) seenBefore = seenBefore.getNext();
         if (node == seenBefore) {
            ans += " ... ";
            break;
         }
      }
      return ans + "=";
   }
}
