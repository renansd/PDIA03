package pacote26671.MODEL;

import java.awt.Color;

public class Pixel {
	private double x;
	private double y;
	private Color c;
	
	public Pixel(int a, int b, Color cor)
	{
		x = a;
		y = b;
		c = cor;
	}
	
	public Pixel(double a, double b, Color cor)
	{
		x = a;
		y = b;
		c = cor;
	}
	
	public Color getCor()
	{
		return c;
	}
	public void setPos(double x1, double y1)
	{
		x=x1;
		y=y1;
	}
	public double getX()
	{
		return x;
	}
	public double getY()
	{
		return y;
	}
	public void setColor(Color cor)
	{
		c=cor;
	}
}
