public class BinNode<T> extends BinaryNode {

   T data;

   public BinNode() {
      super();
   }
   public BinNode(BinNode<T> p, BinNode<T> l, BinNode<T> r, T d) {
      super(p, l, r);
      data = d;
   }
   @Override
   public String printData() {
      return data.toString();
   }
   public T getData() {
      return data;
   }
   public void setData(T newData) {
      data = newData;
   }
}
