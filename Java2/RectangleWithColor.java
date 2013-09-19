import java.awt.Color;

public class RectangleWithColor implements Rectangular
{
   private int length;
   private int width;
   private Color color;

   public RectangleWithColor(int length, int width, Color color)
   {
      this.length = length;
      this.width = width;
      this.color = color;
   }

   public int getLength()
   {
      return length;
   }

   public int getWidth()
   {
      return width;
   }

   public Color getColor()
   {
       return color;
   }

   public void setLength(int length)
   {
      this.length = length;
   }

   public void setWidth(int width)
   {
      this.width = width;
   }

   public void setColor(Color color)
   {
      this.color = color;
   }

   public int area()
   {
      return length * width;
   }
   public String toString()
   {
      return "Length: " + length + " Width: " + width + " Color: " + color;
   }
}

