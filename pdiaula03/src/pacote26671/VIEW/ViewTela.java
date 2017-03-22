package pacote26671.VIEW;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;

import pacote26671.CONTROL.CtrlGeral;
import pacote26671.MODEL.Matriz;
import pacote26671.MODEL.Pixel;

public class ViewTela{
	private JFrame janela;
	private JFrame janelaRtd;
	private CtrlGeral ctrl;
	JPanel matriz = new JPanel();
	JPanel template = new JPanel();
    JPanel botoesM = new JPanel();
    JPanel botoesP = new JPanel();
    JPanel botoesP2 = new JPanel();
    JPanel botao = new JPanel();
    JPanel botao2 = new JPanel();
    JSlider sliderMX = new JSlider(JSlider.HORIZONTAL, 0, 35, 0);
    JSlider sliderMY = new JSlider(JSlider.HORIZONTAL, 0, 35, 0);    
    JButton setM = new JButton("Gerar Matiz");
    JButton setP = new JButton("Aumentar");
    JButton setCM = new JButton("Cor Matriz");
    JButton setCP = new JButton("Reduzir");
    JButton espH = new JButton("Espelhar Horizontalmente");
    JButton espV = new JButton("Espelhar Verticalmente");
    JButton movE = new JButton();
    JButton movD = new JButton();
    JButton movC = new JButton();
    JButton movB = new JButton();
    JButton svI = new JButton("Salvar");
    JButton crgI = new JButton("Carregar");
    JButton rotH = new JButton();
    JButton rotAH = new JButton();
    JButton aplMod = new JButton("Aplicar Modificacões");
    JButton descMod = new JButton("Descartar Modificacões");
    Color corM = new Color(0,0,0);
    Color corP = new Color(0,0,0);
    
    MouseListener mlOpcoes = new MouseListener(){ 
		public void mouseClicked(MouseEvent e)
		{
			int x = e.getX()-10;
			int y = e.getY()-10;
			int posx = (int) ((x+16)/16.0);
			int posy = (int) ((y+16)/16.0);			
			ctrl.pinta(posx-1, posy-1,corM, 1);
			
		}
		public void mousePressed(MouseEvent e) 
		{
			
			
		}
		public void mouseReleased(MouseEvent e) 
		{
			
			
		}
		public void mouseEntered(MouseEvent e) 
		{
			
			
		}
		public void mouseExited(MouseEvent e) 
		{
			
			
		}		
	};
	
	MouseListener mlOpcoes2 = new MouseListener(){ 
		public void mouseClicked(MouseEvent e)
		{
			int x = e.getX()-10;
			int y = e.getY()-10;
			int posx = (int) ((x+16)/16.0);
			int posy = (int) ((y+16)/16.0);			
			ctrl.pinta(posx-1, posy-1,corP, 2);
			
		}
		public void mousePressed(MouseEvent e) 
		{
			
			
		}
		public void mouseReleased(MouseEvent e) 
		{
			
			
		}
		public void mouseEntered(MouseEvent e) 
		{
			
			
		}
		public void mouseExited(MouseEvent e) 
		{
			
			
		}		
	};
    
    public ViewTela(CtrlGeral c)
    {
    	ctrl = c;    	
    	janela = new JFrame("26671 - Transformações Geométricas");
	    janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.mostraJanela();
    }
    
    public void mostraJanela()
    {
    	janela.setSize(1366, 768);
    	janela.setLayout(null);	    
	    matriz.setBackground(new Color(255,255,255));
	    template.setBackground(new Color(255,255,255));	    
	    janela.add(matriz);
	    janela.add(template);
	    janela.add(botoesM);
	    janela.add(botoesP);
	    janela.add(botoesP2);
	    janela.add(botao);
	    janela.add(botao2);
	    matriz.setSize(new Dimension(680,600));
	    template.setSize(new Dimension(680,600));	
	    botoesM.setSize(new Dimension(683,68)); 
	    botoesP.setSize(new Dimension(683,34));
	    botoesP2.setSize(new Dimension(683,34));
	    botao.setSize(new Dimension(683,100));
	    botao2.setSize(new Dimension(683,100));
	    matriz.setLocation(0, 0);
	    template.setLocation(686, 0);
	    botoesM.setLocation(0, 600);
	    botoesP.setLocation(683, 600);
	    botoesP2.setLocation(683, 634);
	    botao.setLocation(0, 668);
	    botao2.setLocation(683, 668);
	    botoesM.add(sliderMX);
	    botoesM.add(sliderMY);
	    botoesM.add(setM);
	    botoesM.add(setCM);	    
	    botoesP.add(setP);
	    botoesP.add(setCP);
	    botoesP.add(espH);
	    botoesP.add(espV);
	    botoesP2.add(movE);
	    botoesP2.add(movD);
	    botoesP2.add(movC);
	    botoesP2.add(movB);
	    botoesP2.add(rotH);
	    botoesP2.add(rotAH);
	    botao2.add(descMod);
	    botao2.add(aplMod);
	    botao.add(crgI);
	    botao.add(svI);
	    Image right_arrow;
		try {
			right_arrow = ImageIO.read(getClass().getResource("right_arrow.bmp"));
			movD.setIcon(new ImageIcon(right_arrow));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	    
	    Image left_arrow;
		try {
			left_arrow = ImageIO.read(getClass().getResource("left_arrow.bmp"));
			movE.setIcon(new ImageIcon(left_arrow));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	    
	    Image up_arrow;
		try {
			up_arrow = ImageIO.read(getClass().getResource("up_arrow.bmp"));
			 movC.setIcon(new ImageIcon(up_arrow));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	   
	    Image down_arrow;
		try {
			down_arrow = ImageIO.read(getClass().getResource("down_arrow.bmp"));
			movB.setIcon(new ImageIcon(down_arrow));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Image horario;
		try {
			horario = ImageIO.read(getClass().getResource("horario.bmp"));
			rotH.setIcon(new ImageIcon(horario));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Image antihorario;
		try {
			antihorario = ImageIO.read(getClass().getResource("antihorario.bmp"));
			rotAH.setIcon(new ImageIcon(antihorario));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	    setM.addActionListener(ctrl.new drawM());
	    setP.addActionListener(ctrl.new almI());
	    setCM.addActionListener(ctrl.new corM());
	    setCP.addActionListener(ctrl.new dimI());
	    espH.addActionListener(ctrl.new espH());
	    espV.addActionListener(ctrl.new espV());
	    crgI.addActionListener(ctrl.new crgI());
	    svI.addActionListener(ctrl.new svI());
	    descMod.addActionListener(ctrl.new descMod());
	    aplMod.addActionListener(ctrl.new aplMod());
	    movD.addActionListener(ctrl.new movD());
	    movE.addActionListener(ctrl.new movE());
	    movC.addActionListener(ctrl.new movC());
	    movB.addActionListener(ctrl.new movB());
	    rotH.addActionListener(ctrl.new rotH());
	    rotAH.addActionListener(ctrl.new rotAH());
	    sliderMX.setMinorTickSpacing(1);
	    sliderMX.setMajorTickSpacing(5);
	    sliderMX.setPaintTicks(true);
	    sliderMX.setPaintLabels(true);
	    sliderMY.setMinorTickSpacing(1);
	    sliderMY.setMajorTickSpacing(5);
	    sliderMY.setPaintTicks(true);
	    sliderMY.setPaintLabels(true);	    
	    matriz.addMouseListener(mlOpcoes);
	    template.addMouseListener(mlOpcoes2);
	    janela.setVisible(true);
    }
    
    public void limpa(int i)
    {
    	Graphics g;
    	if(i==1) 
		{
    		g = matriz.getGraphics();
    		g.setColor(new Color(255,255,255));
		}
    	else 
    	{
    		g = template.getGraphics();
    		g.setColor(new Color(255,255,255));
    	}    	
    	g.fillRect(0,0, 680, 600);
    }
    
    public void sctCor(int i) {
		if(i==1)this.corM = JColorChooser.showDialog(new JFrame(), "Selecione a cor", corM);
		else this.corP = JColorChooser.showDialog(new JFrame(), "Selecione a cor", corP);
    }
    
    //Desenha as bordas da matriz
    public void desenhaM(Matriz m, int c)
    {
    	Graphics g = matriz.getGraphics();
    	if (c==1) g = matriz.getGraphics();
    	else if(c==2) g = template.getGraphics();      	
    	Graphics2D g2 = (Graphics2D) g;
    	g2.setStroke(new BasicStroke(1));
    	int x = m.getH();
    	int y = m.getW();    	
    	int px=10;
    	int py=10;
    	int tamx = x*16;
    	int tamy = y*16;    	
    	
    	for(int i = 0; i<x+1; i++)
    	{
    		g2.drawLine(px,py, px, tamy+py);  
    		px+=16;
    	}
    	px=10;
    	py=10;
    	for(int i = 0; i<y+1; i++)
    	{
    		g2.drawLine(px,py, tamx+px, py);  
    		py+=16;
    	}
    }
    
    //Desenha as células da matriz
    public void desenhaRect(Matriz m, int x)
    {
    	int h = m.getH();
    	int w = m.getW();
    	Graphics g = matriz.getGraphics();
    	if(x==1)g = matriz.getGraphics();    	
    	else if(x==2) g = template.getGraphics();    	
    	for(int i=0; i<h; i++)
    	{
    		for(int j=0; j<w; j++)
    		{
    			g.setColor(m.getPixel(i, j));
    			Pixel p = m.getP(i, j);
    			if(p.getX()>=0 && p.getX()<h && p.getY()>=0 && p.getY()<w)
    			{
    				g.fillRect((int)(10+(p.getX()*16)), (int)(10+(p.getY()*16)), 16, 16);
    			}    			  			
    		}
    	}
    	
    	desenhaM(m,x);    	
    }    
    
    public int getSMX()
    {
    	return sliderMX.getValue();
    }
    public int getSMY()
    {
    	return sliderMY.getValue();    }
    

}
