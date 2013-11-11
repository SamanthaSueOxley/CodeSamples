public class TestString{
   public static void main(String [] args){
      // char str[] = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
//       ReverseString rev = new ReverseString( str );
//       rev.print();
//       rev.reverseString();
//       rev.print();
      String str = "abcdafgh";
      RemoveDouplicates remove = new RemoveDouplicates(str);
      remove.print();
      remove.removeDouplicate();
      remove.print();
   }
}