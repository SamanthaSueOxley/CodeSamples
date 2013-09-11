/*
Samantha Oxley
Java 218: Lab 09
main class
*/
import java.util.*;
import java.awt.*;

public class TestRectangle
{
	public static void main(String []args)
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Please enter the rectangle length: ");
		int length = scan.nextInt();
		
		System.out.print("Please enter the rectangle width: ");
		int width = scan.nextInt();
		
		System.out.print("Please enter the rectangle height: ");
		int height = scan.nextInt();
		
		Box1 firstBox = new Box1(length, width, height);
		System.out.print(firstBox.getHeight() +" "+ firstBox.area() +" "+ firstBox.volume()+" "+ firstBox.toString());
		System.out.println("\nEnd first box print \n");	
		
		Box2 secondBox = new Box2(length, width, height);
		System.out.print(secondBox.getHeight() +" "+ secondBox.area()+" "+secondBox.volume()); //+ " "+ secondBox.toString());
		System.out.println("\nEnd second box print \n");
		
		Box3 thirdBox = new Box3(new Rectangle(length, width));
		System.out.print(thirdBox.toString( ));
		System.out.print("\nEnd third box-rectangle print \n");
		
		Box3 box2 = new Box3(new RectangleWithColor(4, 5, new Color(10,10,10)));
		
	}
}