package proyecto;

import java.awt.Image;

import javax.swing.ImageIcon;

import entorno.Entorno;

public class Sakura {
	
	private int x;
	private int y;
	private int ancho;
	private int alto;
	
	private Image img1;
	private Image img2;
	private Image img3;
	private Image img4;
	private Image img5;
	
	
	private boolean EnabledDisparar ;
	
	
	public Sakura(int x, int y, int alto, int ancho) {
		this.x = x;
		this.y = y;
		this.ancho = ancho;
		this.alto = alto;
		
		this.img1 = new ImageIcon("Mov abajo.gif").getImage();
		this.img2 = new ImageIcon("Mov arriba.gif").getImage();
		this.img3 = new ImageIcon("Mov de.gif").getImage();
		this.img4 = new ImageIcon("Mov iz.gif").getImage();
		this.img5 = new ImageIcon("quieta.png").getImage();
	
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
	
	public void moverIzquierda() {
		this.x = this.x-5;
	}
	
	public void moverDerecha() {
		this.x = this.x+5;
	}
	
	
	public void moverArriba() {
		this.y = this.y-5;
	}
	
	public void moverAbajo() {
		this.y = this.y+5;
	}
	
	
	public void setY(int y) {
		this.y = y;
	}
	public void setX(int x) {
		this.x = x;
	}
	
	public  boolean  getEnabledDisparar() {
		
		return EnabledDisparar;
	}
	public void  setEnabledDisparar(boolean disparar) {
		
		this.EnabledDisparar = disparar ;
		
	}
	
	

	
	public void dibujarse(Entorno entorno) {
		if(entorno.estaPresionada(entorno.TECLA_ARRIBA)) {
			entorno.dibujarImagen(this.img2, this.x, this.y, 0,0.6);
		}else if(entorno.estaPresionada(entorno.TECLA_DERECHA)) {
			entorno.dibujarImagen(this.img3, this.x, this.y, 0,0.6);
		}else if(entorno.estaPresionada(entorno.TECLA_IZQUIERDA)) {
			entorno.dibujarImagen(this.img4, this.x, this.y, 0,0.6);
		}else if(entorno.estaPresionada(entorno.TECLA_ABAJO)) {
			entorno.dibujarImagen(this.img1, this.x, this.y,0,0.6);}
		else {
			entorno.dibujarImagen(this.img5, this.x, this.y,0,1.1);
		
		}
	}

}
