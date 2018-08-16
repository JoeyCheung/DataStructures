import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        GTNode<Integer> tree = new GTNode<>(13, null);
        GTNode<Integer> b1 = new GTNode<>(2354, tree);
        GTNode<Integer> b2 = new GTNode<>(1243, tree);
        GTNode<Integer> b3 = new GTNode<Integer>(5423, b1);
        GeneralTree<Integer> root = new GeneralTree<>();
        tree.add(b1);
        tree.add(b2);
        b2.add(b3);
        root.add(tree, null);
        System.out.println(tree.numberChildren());
        System.out.println(tree.printData());
        System.out.println(tree.children().next().printData());
    }
}
