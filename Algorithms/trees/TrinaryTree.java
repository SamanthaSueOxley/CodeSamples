/*
   Samantha Oxley
   Creates a trinary tree
*/
public class TrinaryTree{
   TrinaryNode root;
   public TrinaryTree(){
      root = null;   }
   /*
      static Node class with three child nodes and one data
   */
   static class TrinaryNode{
      //initialize child nodes to null
      int data;
      TrinaryNode midChild = null; 
      TrinaryNode rightChild = null;
      TrinaryNode leftChild = null;
      //created 
      public TrinaryNode(int data){
         this.data = data;
      }
   }
   public TrinaryNode getRoot(){
      return root;
   }
   /*
      addNode method
      @param TrinaryNode tNode - current node to compare
      @param int data - value trying to insert
   */
   public void addNode( TrinaryNode tNode, int data ){
      if(root == null){ 
         TrinaryNode newroot = new TrinaryNode(data);
         root = newroot; 
         return;
      }
      // logic here is that you have a value, 'data' that you are trying to 
      // insert into this trinaryTree. The method recursively checks for
      // where it should insert the data until it comes to a null object
      // a new object with the data is then constructed and added at this 
      // location
      if( data > tNode.data ){ // id data is larger
         if(tNode.rightChild == null ){
            TrinaryNode newNode = new TrinaryNode( data );
            tNode.rightChild = newNode; 
         }else{
            addNode(tNode.rightChild, data);
         }
      }else if( data < tNode.data ){// if data is smaller
         if(tNode.leftChild == null ){
            TrinaryNode newNode = new TrinaryNode( data );
            tNode.leftChild = newNode; 
         }else{
            addNode(tNode.leftChild, data);
         }
      }else{ // data must be equal
         if(tNode.midChild == null){
            TrinaryNode newNode = new TrinaryNode( data );
            tNode.midChild = newNode;
         }else{
            addNode(tNode.midChild, data);
         }
      }
   }
   /*
      deleteNode method
      @param TrinaryNode tNode - current node to compare
      @param int data - value trying to delete
      @return TrinaryNode the current node
   */
   public TrinaryNode deleteNode( TrinaryNode tNode, int data ){
      // if data is larger, call delete node on child and return this node
      if( data > tNode.data ){ 
         tNode.rightChild = deleteNode(tNode.rightChild, data); 
         return tNode;
      }else if( data < tNode.data ){
         tNode.leftChild = deleteNode(tNode.leftChild, data);
         return tNode;
      //if data is equal BUT has a midchild, call deleteNode, otherwise
      // return null to delet the current node!
      }else{ 
         if(tNode.midChild != null){
            tNode.midChild = deleteNode(tNode.midChild, data);
            return tNode;
         }else{
            return null;
         }
      }
   }
   // adding my own function to print entire tree...
   // for testing
   // uses recursion to print node, then all child nodes
   public void print(TrinaryNode node){
      if(node != null){
         System.out.println( node.data );
         print( node.leftChild );
         print( node.midChild );
         print( node.rightChild );
      }
   }
}