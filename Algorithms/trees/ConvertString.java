/*
   Samantha Oxley
   Hi Zillow!
   Class to convert string to long
*/

public class ConvertString{
   private String origString;
   private int length;
   private long newLong;
   private long exponent;
   /*
      Unparameterized constructor, initialize values
   */
   public ConvertString(){
      origString = "";
      length = 0;
      newLong = 0;
      exponent = 1;
   }
   /*
      Calculates and returns long value of string
   */
   public long stringToLong(String _origString){
      if( _origString == null || _origString == "" ){
         return 0;
      }
      origString = _origString;
      length = origString.length();
      for( int i=length-1 ; i>=0 ; i-- ){
         int ascii = (int) origString.charAt(i);
         ascii -= 48;
         System.out.println(ascii);
         newLong += ascii * exponent;
         exponent *= 10;
         
      }
      return newLong;
   }
   /*
      Resets value of variables
   */
   public void reset(){
      origString = "";
      length = 0;
      newLong = 0;
      exponent = 1;
   }
}