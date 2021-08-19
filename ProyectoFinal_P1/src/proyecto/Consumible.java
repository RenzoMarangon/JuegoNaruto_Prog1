package proyecto;


import java.awt.Image;

import javax.swing.ImageIcon;

import entorno.Entorno;

public class Consumible {
	private int x;
	private int y;
	private int ancho;
	private int alto;
	private boolean enabled;
	private Image imagen;
	
	Consumible(int x, int y, int ancho, int alto){
		this.x=x;
		this.y=y;
		this.ancho=ancho;
		this.alto=alto;
		this.imagen = new ImageIcon("hongo.png").getImage();
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

	
	public boolean Enabled() {
		return enabled;
	}
	
	public void setEnabled(boolean enabled) {
		this.enabled=enabled;
	}
	
	
	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void dibujarse(Entorno entorno) {
		
		entorno.dibujarImagen(imagen, x, y, 0, 0.8);
	}
}
