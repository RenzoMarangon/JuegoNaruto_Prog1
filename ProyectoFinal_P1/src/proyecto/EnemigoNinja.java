package proyecto;


import java.awt.Image;

import javax.swing.ImageIcon;

import entorno.Entorno;

public class EnemigoNinja {
	
	private int x;
	private int y;
	private int ancho;
	private int alto;
	private int velocidad;
	private Image imagen;
	private boolean enabled;
	private boolean detener;
	
	public EnemigoNinja(int x, int y, int alto, int ancho , int velocidad) {
		
		this.x = x;
		this.y = y;
		this.ancho = ancho;
		this.alto = alto;
		this.velocidad = velocidad;
		this.imagen = new ImageIcon("ninja.png").getImage();
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
	public boolean  Enabled( ) {
		
		return enabled;
		
	}
	
	public void  setY(int y) {
		
		this.y=y;
		
	}
	public void  setX(int x) {
		
		this.x=x;
		
	}
	
	public boolean getDetener() {
		return detener;
	}
	
	public void setDetener(boolean detener) {
		this.detener = detener;
	}
	
	public void  setEnabled( boolean enabled) {
		
		this.enabled = enabled;
		
	}
	
	
	
	public void moverIzquierda() {
		this.x = this.x-this.velocidad;
	}
	
	public void moverDerecha() {
		this.x = this.x+this.velocidad;
	}
	
	
	public void moverArriba() {
		this.y = this.y-this.velocidad;
	}
	
	public void moverAbajo() {
		this.y = this.y+this.velocidad;
	}
	
	public void iniciarVelocidad() {
		this.velocidad = -2;
	}
	
	
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
	
	
	
	public void dibujarse(Entorno entorno) {
		//entorno.dibujarRectangulo(this.x, this.y, this.ancho, this.alto, 0, Color.BLUE);
		entorno.dibujarImagen(imagen, x, y, 0,0.2);
	}
	
	
	
}
