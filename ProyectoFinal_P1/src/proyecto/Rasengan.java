package proyecto;


import java.awt.Image;

import javax.swing.ImageIcon;

import entorno.Entorno;

public class Rasengan {
	
	private int x;
	private int y;
	private int ancho;
	private int alto;
	private int velocidad;
	Image imagen;
	
	public Rasengan(int x, int y, int alto, int ancho , int velocidad) {
		
		this.x = x;
		this.y = y;
		this.ancho = ancho;
		this.alto = alto;
		this.velocidad = velocidad;
		this.imagen = new ImageIcon("rasengan.png").getImage();
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
	
	public void setY(int y) {
		
		this.y=y;
	}
	public void setX(int x) {
		
		this.x=x;
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
	
	
	
	
	public void dibujarse(Entorno entorno) {
		//entorno.dibujarRectangulo(this.x, this.y, this.ancho, this.alto, 0, Color.YELLOW);
		entorno.dibujarImagen(imagen, x, y, 0, 0.3);
		
	}
	
	public boolean colision(EnemigoNinja ninja ) {
		
		int minimoRanseganX =  this.x - ( this.ancho/2 ) ;
		int maximoRanseganX =  this.x + ( this.ancho/2 ) ;
		
		int minimoRanseganY =  this.y - ( this.alto/2 )  ;
		int maximoRanseganY =  this.y + ( this.alto/2 )   ;
		
		
		
		boolean x = minimoRanseganX >= ( ninja.getX() - ninja.getAncho()/2 ) && minimoRanseganX <= ( ninja.getX() + ninja.getAncho()/2 ) ||
				maximoRanseganX >= ( ninja.getX() - ninja.getAncho()/2 ) && maximoRanseganX <= ( ninja.getX() + ninja.getAncho()/2 );
			
		boolean y= 	(minimoRanseganY >= (ninja.getY() - ninja.getAlto()/2 ) && minimoRanseganY < (ninja.getY() + ninja.getAlto()/2 ) ) ||
					(maximoRanseganY >= (ninja.getY() - ninja.getAlto()/2 ) && maximoRanseganY <= (ninja.getY()+ ninja.getAlto()/2));
		
        return  x && y ;
		
		
	}
	

}

