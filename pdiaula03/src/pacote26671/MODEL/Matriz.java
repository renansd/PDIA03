package pacote26671.MODEL;

import java.awt.Color;

public class Matriz {
    private int h, w;
    private Pixel[][] pixels;
    
    public Matriz(int h, int w) {
		this.h = h;
		this.w = w;
		pixels = new Pixel[h][w];
		for(int i = 0; i < h; ++i) {
		    for(int j = 0; j < w; ++j) {
		    	pixels[i][j] = new Pixel(i, j, new Color(255,255,255));
		    }
		}
    }
    
    public Matriz(Matriz p)
    {
    	this.h = p.getH();
    	this.w = p.getW();
    	pixels = new Pixel[p.getH()][p.getW()];
    	for(int i=0; i<p.getH(); i++)
    	{
    		for(int j=0; j<p.getW(); j++)
    		{
    			Pixel x = new Pixel( p.getP(i, j).getX(), p.getP(i, j).getY(), p.getP(i, j).getCor());
    			pixels[i][j] = x;
    		}
    	}
    }
    
    public Color getPixel(int x, int y) {
    	return pixels[x][y].getCor();
    }
    
    public void setPixel(int x, int y, Color color) {
		if(x >= 0 && x < this.h && y >= 0 && y < this.w) {
		    pixels[x][y].setColor(color);
		}
    }
    
    public Pixel getP(int x, int y)
    {
    	return pixels[x][y];
    }
    
    public void offSet(int x)
    {
    	if(x==1)
    	{
    		for(int i=0; i<h; i++)
    		{
    			for(int j=0; j<w; j++)
    			{
    				pixels[i][j].setPos(pixels[i][j].getX(), pixels[i][j].getY()-1);
    			}
    		}
    	}
    	if(x==2)
    	{
    		for(int i=0; i<h; i++)
    		{
    			for(int j=0; j<w; j++)
    			{
    				pixels[i][j].setPos(pixels[i][j].getX(), pixels[i][j].getY()+1);
    			}
    		}
    	}
    	if(x==3)
    	{
    		for(int i=0; i<h; i++)
    		{
    			for(int j=0; j<w; j++)
    			{
    				pixels[i][j].setPos(pixels[i][j].getX()+1, pixels[i][j].getY());
    			}
    		}
    	}
    	if(x==4)
    	{
    		for(int i=0; i<h; i++)
    		{
    			for(int j=0; j<w; j++)
    			{
    				pixels[i][j].setPos(pixels[i][j].getX()-1, pixels[i][j].getY());
    			}
    		}
    	}
    }
    
    public int getH()
    {
    	return h;
    }
    public int getW()
    {
    	return w;
    }
}
