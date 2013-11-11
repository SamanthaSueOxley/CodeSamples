public class RemoveDouplicates{
   String str;
   public RemoveDouplicates(String strang){
      str = strang;
   }
   public void removeDouplicate(){
      int size = str.length();
      if(size <= 1) return;
      int i=0;
      int j=0;
      while(i < size-1){
         j = i+1;
         while(j < size-1){
            if(str.charAt(i) == str.charAt(j)){
               str = str.substring(0, j) + str.substring(j, size-j);
            }
            j++;
         }//end while j
         i++;
      }//end while i
   }
   public void print(){
      System.out.println(str);
   }
}