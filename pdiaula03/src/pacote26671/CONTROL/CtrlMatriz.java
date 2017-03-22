package pacote26671.CONTROL;

import java.awt.Color;

import pacote26671.MODEL.Matriz;

public class CtrlMatriz {
	
	public Matriz escalaAumenta(Matriz m)
	{
		int escala = 2;		
		Matriz s = new Matriz(m.getH()*escala,m.getW()*escala);
		for(int i=0; i<m.getH(); i++)
		{
			for(int j=0; j<m.getW(); j++)
			{
				Color cor = m.getPixel(i, j);
				s.setPixel(i*escala, j*escala, cor);
				s.setPixel((i*escala)+1, j*escala, cor);
				s.setPixel(i*escala, (j*escala)+1, cor);
				s.setPixel((i*escala)+1, (j*escala)+1, cor);
			}
		}		
		return s;
	}
	
	public Matriz escalaDiminui(Matriz m)
	{
		int escala = 2;
		int x,y;
		Matriz s = new Matriz(m.getH()/escala, m.getW()/escala);
		x=0;
		y=0;
		for(int i=0; i<m.getH(); i+=escala)
		{
			y=0;
			for(int j=0; j<m.getW(); j+=escala)
			{
				Color cor = m.getPixel(i, j);				
				if(i+1==m.getH())
				{
					if(j+1==m.getW())
					{
						s.setPixel(x, y, cor);
					}
					else
					{
						Color med = media2(cor, m.getPixel(i, j+1));
						s.setPixel(x, y, med);
					}
				}
				else
				{
					if(j+1==m.getW())
					{
						Color med = media2(cor, m.getPixel(i+1, j));
						s.setPixel(x, y, med);
					}
					else
					{
						Color med = media4(cor, m.getPixel(i+1, j), m.getPixel(i, j+1), m.getPixel(i+1, j+1));
						s.setPixel(x, y, med);
					}
				}
				y++;
			}
			x++;
		}
		
		return s;
	}
	
	public Matriz espelhaVertical(Matriz m)
	{
		Matriz s = new Matriz(m.getH(), m.getW());
		int x,y;		
		
		x=0;		
		for(int i=m.getH()-1; i>=0; i--)
		{
			y=0;
			for(int j=0; j<m.getW(); j++)
			{
				s.setPixel(x, y, m.getPixel(i, j));
				y++;
			}
			x++;
		}
		
		return s;
	}
	
	public Matriz espelhaHorizontal(Matriz m)
	{
		Matriz s = new Matriz(m.getH(), m.getW());
		int x,y;		
		
		x=0;		
		for(int i=0; i<m.getH(); i++)
		{
			y=0;
			for(int j=m.getW()-1; j>=0; j--)
			{
				s.setPixel(x, y, m.getPixel(i, j));
				y++;
			}
			x++;
		}
		
		return s;
	}
	
	public Color media2(Color c1, Color c2)
	{
		
		int c1r = c1.getRed();
		int c1g = c1.getGreen();
		int c1b = c1.getBlue();
		int c2r = c2.getRed();
		int c2g = c2.getGreen();
		int c2b = c2.getBlue();
		int medr, medg, medb;
		
		medr = (c1r+c2r)/2;
		medg = (c1g+c2g)/2;
		medb = (c1b+c2b)/2;
		
		System.out.println("2 " + medr + " " + medg + " " + medb);
		
		Color med = new Color(medr,medg,medb);
		return med;
	}
	
	public Color media4(Color c1, Color c2, Color c3, Color c4)
	{
		
		int c1r = c1.getRed();
		int c1g = c1.getGreen();
		int c1b = c1.getBlue();
		int c2r = c2.getRed();
		int c2g = c2.getGreen();
		int c2b = c2.getBlue();
		int c3r = c3.getRed();
		int c3g = c3.getGreen();
		int c3b = c3.getBlue();
		int c4r = c4.getRed();
		int c4g = c4.getGreen();
		int c4b = c4.getBlue();
		int medr, medg, medb;
		
		medr = (c1r+c2r+c3r+c4r)/4;
		medg = (c1g+c2g+c3g+c4g)/4;
		medb = (c1b+c2b+c3b+c4b)/4;
		
		System.out.println("4 " + medr + " " + medg + " " + medb);
		
		Color med = new Color(medr,medg,medb);
		return med;
	}
	
	public Matriz movMatriz(Matriz p, int i)
	{
		Matriz s = p;
		
		s.offSet(i);
		
		return s;
	}
	
	public Matriz rotMatriz(Matriz p, int d)
	{
		Matriz s = p;
		
		for(int i=0; i<s.getH()/2; i++)
		{
			s = movMatriz(s, 1);
		}
		for(int i=0; i<s.getW()/2; i++)
		{
			s = movMatriz(s, 4);
		}
		
		double rad;
		
		if(d==1)
		{
			rad = ((Math.PI/180)*5);
		}else
		{
			rad = ((Math.PI/180)*(360-5));
		}
		
		double x,y;
		
		for(int i=0; i<s.getH(); i++)
		{
			for(int j=0; j<s.getW(); j++)
			{
				x = Math.cos(rad)*s.getP(i, j).getX() + (-1*Math.sin(rad)*s.getP(i, j).getY());
				y = Math.sin(rad)*s.getP(i, j).getX() + Math.cos(rad)*s.getP(i, j).getY();				
				s.getP(i, j).setPos(x, y);
			}
		}
		
		for(int i=0; i<s.getH()/2; i++)
		{
			s = movMatriz(s, 2);
		}
		for(int i=0; i<s.getW()/2; i++)
		{
			s = movMatriz(s, 3);
		}
		
		return s;
	}	
}
