package proyecto;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;

import entorno.Entorno;

public class Florero {
	int x;
	int y;
	int ancho;
	int alto;
	Image imagen;
	
	boolean enabledEntregarFlores;
	Florero(int x, int y, int ancho, int alto){
		this.x=x;
		this.y=y;
		this.ancho=ancho;
		this.alto=alto;
		this.imagen = new ImageIcon("naruto.gif").getImage();
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getAncho() {
		return ancho;
	}

	public int getAlto() {
		return alto;
	}
	
	public boolean getEnabledEntregarFlores() {
		return enabledEntregarFlores;
	}
	
	public void  setEnabledEntregarFlores(boolean entregarFlores) {
		
		this.enabledEntregarFlores = entregarFlores ;
		
	}
	
	public void dibujarse(Entorno entorno) {
		entorno.dibujarImagen(imagen, this.x, this.y, 238.8, 0.5);
		
	}
	
}
