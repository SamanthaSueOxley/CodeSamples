import java.util.*;

public class Box2
{
	private int height;
	private int volume;
	private int area;
	private Rectangle rect;
	
	public Box2(int length, int width, int height)
	{
		rect = new Rectangle(length, width);
		this.height = height;
	}
	public int getHeight()
	{
		return height;
	}
	public void setHeight(int height)
	{
		this.height = height;
	}
	public int area()
	{
		area = (2 * rect.getLength() * rect.getWidth())+(2 * height * rect.getWidth())+(2 * height * rect.getLength());
		return area;
	}
	public int volume()
	{
		volume = rect.getLength() * rect.getWidth() * height;
		return volume;
	}
}