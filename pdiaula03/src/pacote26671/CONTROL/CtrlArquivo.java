package pacote26671.CONTROL;

import java.awt.Color;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

import javax.swing.JFileChooser;

import pacote26671.MODEL.Matriz;

public class CtrlArquivo {
    public CtrlArquivo() {
	
    }
    
    public void salvaMatriz(Matriz m) {
		JFileChooser abrirArquivo;
		abrirArquivo = new JFileChooser();
		int returnVal = abrirArquivo.showSaveDialog(abrirArquivo);
	
		if (returnVal == JFileChooser.APPROVE_OPTION) {
		    File arquivo = abrirArquivo.getSelectedFile();
		    try {
			BufferedWriter file = new BufferedWriter(new OutputStreamWriter(
						new FileOutputStream(arquivo.getPath()), "utf-8"));
			file.write(m.getH() + " " + m.getW() + "\n");
			for(int i = 0; i < m.getH(); ++i) {
			    for(int j = 0; j < m.getW(); ++j) {
					Color color = m.getPixel(i, j);
					if(j > 0) file.write(" ");
						file.write(color.getRed() + " " + color.getGreen() + " " + color.getBlue());
				}
				file.write("\n");
			}
			file.close();
		    }
		    catch (IOException ex) {
			    
		    }
		}
    }
    
    public Matriz carregaMatriz() {
		JFileChooser abrirArquivo;
		abrirArquivo = new JFileChooser();
		int returnVal = abrirArquivo.showOpenDialog(abrirArquivo);
		Matriz m = null;
		
		if (returnVal == JFileChooser.APPROVE_OPTION) {
		    File arquivo = abrirArquivo.getSelectedFile();
    		Scanner sc;
			try {
				sc = new Scanner(arquivo, "utf-8");
				
	    		int h = sc.nextInt(), w = sc.nextInt();
	    		m = new Matriz(h, w);
	    		for(int i = 0; i < m.getH(); ++i) {
	    		    for(int j = 0; j < m.getW(); ++j) {
		    			int r = sc.nextInt();
		    			int g = sc.nextInt();
		    			int b = sc.nextInt();
		    			Color color = new Color(r, g, b);
		    			m.setPixel(i, j, color);
	    		    }
	    		}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		return m;
    }
}

