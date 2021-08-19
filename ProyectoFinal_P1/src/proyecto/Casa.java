	package proyecto;


import java.awt.Image;

import javax.swing.ImageIcon;

import entorno.Entorno;

public class Casa {
	private int x;
	private int y;
	private int ancho;
	private int alto;
	private boolean seleccionar;
	private Image imagenSeleccionada;
	private Image imagen;
	private Image flecha;
	
	Casa(int x, int y, int ancho, int alto,boolean seleccionar){
		this.x=x;
		this.y=y;
		this.ancho=ancho;
		this.alto=alto;
		this.seleccionar = seleccionar;
		this.flecha = new ImageIcon("flecha.png").getImage();
		this.imagenSeleccionada = new ImageIcon("casaSeleccionada.png").getImage();
		this.imagen = new ImageIcon("casa.png").getImage();
		
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
	
	
	public boolean getSeleccionar() {
		return seleccionar;
	}

	public void setSeleccionar(boolean seleccionar) {
		this.seleccionar = seleccionar;
	}


	
	public void dibujarseSeleccionado(Entorno entorno) {
		entorno.dibujarImagen(imagenSeleccionada, x, y, 0, 0.5);
		entorno.dibujarImagen(flecha, x, y-35, 205.8, 0.04);
	}
	
	
	public void dibujarse(Entorno entorno) {
		entorno.dibujarImagen(imagen, x, y, 0, 0.5);
		
	}
	
	
}
