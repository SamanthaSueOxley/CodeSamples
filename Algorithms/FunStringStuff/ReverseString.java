public class ReverseString{
   char str[];
   
   public ReverseString(char [] aString){
      str = aString;
   }
   public void reverseString(){
      int size = str.length-1;
      int i=0;
      int j=size;
      while(j-i >= 1){
         char temp = str[i];
         str[i] = str[j];
         str[j] = temp;
         i++;
         j--;
      }
   }
   public void print(){
      for(int i=0; i < str.length; i++){
         System.out.println(str[i]);
      }

   }
}