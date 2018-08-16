import java.util.ArrayList;
import java.util.Iterator;

import Tree.BinNode;

public class BinTree<T> extends BinaryTree {

   public void addRoot(T t) throws Exception {
      addRoot(new BinNode<T>(null, null, null, t));
   }

   public void addLeft(BinNode<T> position, T t) throws Exception {
      addLeft(position, new BinNode<T>(null, null, null, t));
   }

   public void addRight(BinNode<T> position, T t) throws Exception {
      addRight(position, new BinNode<T>(null, null, null, t));
   }

   @Override
   protected void promote(BinaryNode lower, BinaryNode node) {
      ((BinNode<T>) node).data = ((BinNode<T>) lower).data;
   }

   @Override
   protected BinaryNode descendant(BinaryNode node) {
      if (node.left != null) return node.left;
      return node.right;
   }
}
