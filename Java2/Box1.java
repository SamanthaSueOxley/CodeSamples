/*
Samantha Oxley
Java 218
Lab 09- Exercise 3

inheritance vs aggregation
demonstrate aggregation produces classes that have more flexibility than classes designed with inheritance
*/
import java.util.*;

public class Box1 extends Rectangle
{
	//attributes
	private int height;
	private int volume;
	private int area;
	
	public Box1(int length, int width, int height)
	{
		super(length, width);
		this.height = height;
	}
	public int getHeight()
	{
		return height;
	}
	public void setHeight(int _height)
	{
		height = _height;
	}
	public int area()
	{
		area = (2 * super.getLength() * super.getWidth())+(2 * height * super.getWidth())+(2 * height * super.getLength());
		return area;
	}
	public int volume()
	{
		volume = super.getLength() * super.getWidth() * height;
		return volume;
	}
}