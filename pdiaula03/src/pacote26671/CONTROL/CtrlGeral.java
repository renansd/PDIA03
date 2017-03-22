package pacote26671.CONTROL;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import pacote26671.MODEL.Matriz;
import pacote26671.VIEW.ViewTela;



public class CtrlGeral {
	ViewTela view;
	Matriz m;
	Matriz p;
	Matriz c;
	CtrlMatriz cm;
	CtrlArquivo ca;	
	
	public CtrlGeral()
	{
		cm = new CtrlMatriz();
		ca = new CtrlArquivo();
	}
	
	public void view(ViewTela v)
	{
		view = v;
	}
	
	public void pinta(int x, int y, Color c, int i)
	{
		if(i==1)
		{
			m.setPixel(x, y, c);
			view.desenhaRect(m,i);
		}
		else 
		{
			p.setPixel(x, y, c);
			view.desenhaRect(p,i);
		}
		
	}
	
	public class drawM implements ActionListener {
		public void actionPerformed(ActionEvent event)
		{
			try {
				view.limpa(1);
			}
			catch(Exception e) {
			 System.out.println("Fail");
			}
			finally {
				m = new Matriz(view.getSMX(), view.getSMY());
				p = new Matriz(m);
				view.desenhaRect(m,1);
				view.desenhaRect(p,2);
			}			
		}
	}
	public class almI implements ActionListener {
		public void actionPerformed(ActionEvent event)
		{
			try {
				view.limpa(2);
			}
			catch(Exception e) {
			 System.out.println("Fail");
			}
			finally {				
				//p = cm.espelhaHorizontal(m);
				p = cm.escalaAumenta(p);
				view.desenhaRect(p,2);
			}			
		}
	}
	public class corM implements ActionListener {
		public void actionPerformed(ActionEvent event)
		{
			view.sctCor(1);
		}
	}
	public class aplMod implements ActionListener {
		public void actionPerformed(ActionEvent event)
		{
			try {
				view.limpa(1);
			}
			catch(Exception e) {
			 System.out.println("Fail");
			}
			finally {				
				m = new Matriz(p);
				view.desenhaRect(m,1);
			}
		}
	}
	public class descMod implements ActionListener {
		public void actionPerformed(ActionEvent event)
		{
			try {
				view.limpa(2);
			}
			catch(Exception e) {
			 System.out.println("Fail");
			}
			finally {				
				p = new Matriz(m);
				view.desenhaRect(p,2);
			}
		}
	}
	public class dimI implements ActionListener {
		public void actionPerformed(ActionEvent event)
		{
			try {
				view.limpa(2);
			}
			catch(Exception e) {
			 System.out.println("Fail");
			}
			finally {				
				//p = cm.espelhaVertical(m);
				p = cm.escalaDiminui(p);
				view.desenhaRect(p,2);
			}
		}
	}
	
	public class svI implements ActionListener {
		public void actionPerformed(ActionEvent event)
		{
			ca.salvaMatriz(m);				
		}
	}
	public class crgI implements ActionListener {
		public void actionPerformed(ActionEvent event)
		{
			try {
				view.limpa(1);
				view.limpa(2);
			}
			catch(Exception e) {
			 System.out.println("Fail");
			}
			finally {				
				m = ca.carregaMatriz();
				p = new Matriz(m);				
				view.desenhaRect(m,1);
				view.desenhaRect(p,2);
			}			
		}
	}
	public class espH implements ActionListener {
		public void actionPerformed(ActionEvent event)
		{
			try {
				view.limpa(2);
			}
			catch(Exception e) {
			 System.out.println("Fail");
			}
			finally {				
				p = cm.espelhaHorizontal(p);
				view.desenhaRect(p,2);
			}
		}
	}
	public class espV implements ActionListener {
		public void actionPerformed(ActionEvent event)
		{
			try {
				view.limpa(2);
			}
			catch(Exception e) {
			 System.out.println("Fail");
			}
			finally {				
				p = cm.espelhaVertical(p);
				view.desenhaRect(p,2);
			}
		}
	}
	
	public class movE implements ActionListener {
		public void actionPerformed(ActionEvent event)
		{
			try {
				view.limpa(2);
			}
			catch(Exception e) {
			 System.out.println("Fail");
			}
			finally {				
				p = cm.movMatriz(p, 4);		
				view.desenhaRect(p,2);
			}
		}
	}
	public class movD implements ActionListener {
		public void actionPerformed(ActionEvent event)
		{
			try {
				view.limpa(2);
			}
			catch(Exception e) {
			 System.out.println("Fail");
			}
			finally {				
				p = cm.movMatriz(p, 3);		
				view.desenhaRect(p,2);
			}
		}
	}
	public class movC implements ActionListener {
		public void actionPerformed(ActionEvent event)
		{
			try {
				view.limpa(2);
			}
			catch(Exception e) {
			 System.out.println("Fail");
			}
			finally {				
				p = cm.movMatriz(p, 1);		
				view.desenhaRect(p,2);
			}
		}
	}
	public class movB implements ActionListener {
		public void actionPerformed(ActionEvent event)
		{
			try {
				view.limpa(2);
			}
			catch(Exception e) {
			 System.out.println("Fail");
			}
			finally {				
				p = cm.movMatriz(p, 2);		
				view.desenhaRect(p,2);
			}
		}
	}
	public class rotAH implements ActionListener {
		public void actionPerformed(ActionEvent event)
		{
			try {
				view.limpa(2);
			}
			catch(Exception e) {
			 System.out.println("Fail");
			}
			finally {				
				p = cm.rotMatriz(p, 2);						
				view.desenhaRect(p,2);
			}
		}
	}
	public class rotH implements ActionListener {
		public void actionPerformed(ActionEvent event)
		{
			try {
				view.limpa(2);
			}
			catch(Exception e) {
			 System.out.println("Fail");
			}
			finally {				
				p = cm.rotMatriz(p, 1);						
				view.desenhaRect(p,2);
			}
		}
	}
		
}
