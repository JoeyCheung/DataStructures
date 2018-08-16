import java.util.Scanner;

public class BinApp {
   public static void main(String args[]) {
      BinTree<String> tree = new BinTree<>();
      BinNode<String> position = null;
      Scanner input = new Scanner(System.in);
      while (true) {
         try {
            System.out.println(tree.treePrint(position)
                        + "  commands act at the *cursor*:  l r X . > < ^ H S Q:");
            String command = input.next();
            if (command.charAt(0) == 'Q') break;
            if (command.charAt(0) == 'H') System.out.println("Height " + tree.height());
            if (command.charAt(0) == 'S') System.out.println("Size " + tree.size());
            if (command.charAt(0) == 'X' && position != null) {
               tree.removeNode(position);
               position = (BinNode<String>) tree.root();
            }
            if (command.charAt(0) == 'l') {
               String entry = input.next();
               if (tree.size() > 0) tree.addLeft(position, entry);
               else tree.addRoot(entry);
            }
            if (command.charAt(0) == 'r') {
               String entry = input.next();
               if (tree.size() > 0) tree.addRight(position, entry);
               else tree.addRoot(entry);
            }
            if (command.charAt(0) == '.') position = (BinNode<String>) tree.root();
            if (command.charAt(0) == '>') position = (BinNode<String>) position.getRight();
            if (command.charAt(0) == '<') position = (BinNode<String>) position.getLeft();
            if (command.charAt(0) == '^') position = (BinNode<String>) position.getParent();
         } catch (Exception e) {
            System.out.println(e);
         }
      }
      input.close();
   }
}
