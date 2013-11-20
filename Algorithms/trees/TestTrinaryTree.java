public class TestTrinaryTree{
   public static void main(String [] args){
      TrinaryTree tree = new TrinaryTree();
      tree.addNode(tree.getRoot(), 5);
      tree.addNode(tree.getRoot(), 4);
      tree.addNode(tree.getRoot(), 9);
      tree.addNode(tree.getRoot(), 5);
      tree.addNode(tree.getRoot(), 7);
      tree.addNode(tree.getRoot(), 2);
      tree.addNode(tree.getRoot(), 2);
      System.out.println("first print");
      tree.print(tree.getRoot());
      tree.deleteNode(tree.getRoot(), 2);
      System.out.println("two" );
      tree.print(tree.getRoot());


   }
}