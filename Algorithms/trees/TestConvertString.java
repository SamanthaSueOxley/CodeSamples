/*
   Samantha Oxley
   Test the convert string to long class
*/
import java.util.Scanner;

public class TestConvertString{
   public static void main(String []args){
      String input = "";
      long output = 0;
      Scanner scan = new Scanner(System.in);
      ConvertString convert = new ConvertString();
      
      while(input != "exit"){
         System.out.println("Type in some numbers. \nI'll convert it into type long!");
         input = scan.nextLine();
         output = convert.stringToLong(input);
         System.out.println( "It's a long! " + output );
         convert.reset();
      }
   }
}