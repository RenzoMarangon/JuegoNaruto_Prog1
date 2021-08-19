package proyecto;


import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import entorno.Entorno;

import entorno.InterfaceJuego;
import proyecto.Colision;



public class Juego extends InterfaceJuego
{
	// El objeto Entorno que controla el tiempo y otros

	
	private Entorno entorno;
	private Sakura sakura;
	
	
	//
	private EnemigoNinja EnemigoNinjaV [];
	private EnemigoNinja EnemigoNinjaH [];
	
	private Calle calleA;
	private Calle calle1;
	
	private Calle calleB;
	private Calle calle2;
	
	private Calle calleC;
	private Calle calle3;
	
	private Calle calleD;
	
	private int inicioXCalleA;
	private int finXCalleA;
	private int inicioXCalleB;
	private int finXCalleB;
	private int finXCalleC;
	private int inicioXCalleC;
	private int inicioXCalleD;
	private int finXCalleD;
	private int finYCalle1;
	private int inicioYCalle1;
	private int inicioYCalle2;
	private int finYCalle2;
	private int finYCalle3;
	private int inicioYCalle3;
	
	private Rasengan rasengan;
	
	private boolean  activarDisparo=false;
	
	private String direccionRasengan;
	private String ultimaDireccionRasengan;	
	
	private Consumible consumible;
	private int tiempoConsumible;
	private boolean empezarTiempoConsumible=false;
	private boolean consumiblePrimeraAparicion=true;           // Para generar la primera posicion ramdom
	int cantConsumible;
	
	private Florero florero[];
	private Florero floreroSeleccionado;
	private int seleccionarFlorero;
	private boolean floresEntregadas;
	
	private int puntajex;
	
	private Casa casa[];
	private Casa casaSeleccionada;
	private int seleccionarCasa;
	
	//VENTANA INSTRUCCIONES
	private JFrame ventanaInstrucciones;
	private JButton iniciar;
	private JButton instrucciones;
	private JLabel etiquetaInstrucciones;
	private JLabel etiquetaBienvenido;
	
	//VENTANA GAME OVER
	private JFrame ventana;
	private JButton reiniciar;
	private JButton salir;
	private JLabel etiqueta;
	private JLabel etiquetaPuntaje;
	
	private Image manzana;
	private Image flor;
	private Image rasen;
	
	private int tiempo=0;
	private boolean EmpezarTiempo=false;	
	
	private int tiempoNinja=0;
	private boolean EmpezarTiempoNinja=false;
	
	// Variables y mÃ©todos propios de cada grupo
	// ...
	
	Juego()
	{
		
		
		
		// Inicializa el objeto entorno
		this.entorno = new Entorno(this, "Boss Rabbit Rabber - Grupo ... - v1", 800, 600);
		
		
		
		// Inicializar lo que haga falta para el juego
		// ...
		///              (int x, int y, int alto, int ancho)
		
		//INICIALIZAR PERSONAJE
		
		this.sakura = new Sakura(100,580,30,30);
		
		//INICIALIZAR IMAGENES
		this.manzana = new ImageIcon("manzanas.jpg").getImage();
		this.flor = new ImageIcon("flor.png").getImage();
		this.rasen = new ImageIcon("rasengan.png").getImage();
		
		//INICIALIZAR ENEMIGOS
		EnemigoNinjaV = new EnemigoNinja[4];
		EnemigoNinjaH = new EnemigoNinja[3];
	
		this.EnemigoNinjaV[0] = new EnemigoNinja(100,200,30,30,2);    // Ninja Vertical
		this.EnemigoNinjaV[1] = new EnemigoNinja(300,100,30,30,2);    // Ninja Vertical
		this.EnemigoNinjaV[2] = new EnemigoNinja(500,500,30,30,2);    // Ninja Vertical
		this.EnemigoNinjaV[3]= new EnemigoNinja(700,300,30,30,2);    // Ninja Vertical
		
		this.EnemigoNinjaH [0] = new EnemigoNinja(500,100,30,30,2);   // Ninja Horizontal
		this.EnemigoNinjaH [1] = new EnemigoNinja(750,300,30,30,2);   // Ninja Horizontal
		this.EnemigoNinjaH [2]= new EnemigoNinja(100,500,30,30,2);   // Ninja Horizontal
		
		
		//INICIALIZAR CALLES
		this.calleA = new Calle(100,0,1200,50);
		this.calle1 = new Calle(100,100,50,1500);
		
		this.calleB = new Calle(300,20,1200,50);
		this.calle2 = new Calle(100,300,50,1500);
		
		this.calleC = new Calle(500,20,1200,50);
		this.calle3 = new Calle(100,500,50,1500);
		
		this.calleD = new Calle(700,20,1200,50);
		
		this.rasengan = new Rasengan(0,0,30,30,5);
		
		
		this.inicioXCalleA = this.calleA.getX()-((this.calleA.getAncho()-this.sakura.getAncho())/2 );
		this.finXCalleA = this.calleA.getX()+((this.calleA.getAncho()-this.sakura.getAncho())/2 );
		
		this.inicioXCalleB = this.calleB.getX()-((this.calleA.getAncho()-this.sakura.getAncho())/2);
		this.finXCalleB = this.calleB.getX()+((this.calleA.getAncho()-this.sakura.getAncho())/2 );
		
		this.inicioXCalleC = this.calleC.getX()-((this.calleA.getAncho()-this.sakura.getAncho())/2);
		this.finXCalleC = this.calleC.getX()+((this.calleA.getAncho()-this.sakura.getAncho())/2 );
		
		this.inicioXCalleD = this.calleD.getX()-((this.calleA.getAncho()-this.sakura.getAncho())/2);
		this.finXCalleD = this.calleD.getX()+((this.calleA.getAncho()-this.sakura.getAncho())/2 );
		 
		this.inicioYCalle1 = this.calle1.getY()-((this.calleA.getAncho()-this.sakura.getAncho())/2);
		this.finYCalle1 = this.calle1.getY()+((this.calleA.getAncho()-this.sakura.getAncho())/2);
		
		this.inicioYCalle2 = this.calle2.getY()-((this.calleA.getAncho()-this.sakura.getAncho())/2);
		this.finYCalle2 = this.calle2.getY()+((this.calleA.getAncho()-this.sakura.getAncho())/2);
		
		this.inicioYCalle3 = this.calle3.getY()-((this.calleA.getAncho()-this.sakura.getAncho())/2);
		this.finYCalle3 = this.calle3.getY()+((this.calleA.getAncho()-this.sakura.getAncho())/2);
		
		
		
		/*INICIALIZAR CONSUMIBLES*/
		
		this.consumible = new Consumible (100,20,30,30) ;
		
		/*INICIALIZAR FLOREROS*/
		this.florero = new Florero[14];
		
		this.florero[0] = new Florero(15,87,30,30); //FILA 1 COLUMNA 2
		this.florero[1] = new Florero(15,287,30,30);//FILA 1 COLUMNA 3
		this.florero[2] = new Florero(15,487,30,30);//FILA 1 COLUMNA 4
		
		this.florero[3] = new Florero(100,15,30,30);//FILA 2 COLUMNA 1
		this.florero[4] = new Florero(100,560,30,30);//FILA 2 COLUMNA 5
		
		
		this.florero[5] = new Florero(300,15,30,30);//FILA 3 COLUMNA 1
		this.florero[6] = new Florero(300,560,30,30);//FILA 3 COLUMNA 5
		
		this.florero[7] = new Florero(500,15,30,30); //FILA 4 COLUMNA 1
		this.florero[8] = new Florero(500,560,30,30); //FILA 4 COLUMNA 5
		
		this.florero[9] = new Florero(700,15,30,30); //FILA 5 COLUMNA 1
		this.florero[10] = new Florero(700,560,30,30);//FILA 5 COLUMNA 5
		
		this.florero[11] = new Florero(760,487,30,30);// FILA 6 COLUMNA 4
		this.florero[12] = new Florero(760,287,30,30);//FILA 6 COLUMNA 3
		this.florero[13] = new Florero(760,87,30,30);//FILA 6 COLUMNA 2
		
		
		this.seleccionarFlorero = (int) (Math.random()*florero.length);
		this.floresEntregadas = false;
		
		
		
		
		/*INICIALIZAR CASAS*/
		this.casa = new Casa[41];
		
		
		//manzana 1 fila 1
		this.casa[0] = new Casa(62,38,30,30,false);
		this.casa[1] = new Casa(15,62,30,30,false);
		//manzana 2 fila 1
		this.casa[2] = new Casa(62,138,30,30,false);
		this.casa[3] = new Casa(62,262,30,30,false);
		//manzana 3 fila 1
		this.casa[4] = new Casa(62,338,30,30,false);
		this.casa[5] = new Casa(62,412,30,30,false);
		//manzana 4 fila 1
		this.casa[6] = new Casa(62,562,30,30,false);
		
		//manzana 1 fila 2
		this.casa[7] = new Casa(138,38,30,30,false);
		this.casa[8] = new Casa(215,62,30,30,false);
		//manzana 2 fila 2
		this.casa[9] = new Casa(162,138,30,30,false);
		this.casa[10] = new Casa(162,262,30,30,false);
		//manzana 3 fila 2
		this.casa[11] = new Casa(162,338,30,30,false);
		this.casa[12] = new Casa(138,412,30,30,false);
		//manzana 4 fila 2
		this.casa[13] = new Casa(162,538,30,30,false);
		
		//manzana 1 fila 3
		this.casa[14] = new Casa(262,38,30,30,false);
		this.casa[15] = new Casa(338,62,30,30,false);
		//manzana 2 fila 3
		this.casa[16] = new Casa(262,138,30,30,false);
		this.casa[17] = new Casa(262,262,30,30,false);
		//manzana 3 fila 3
		this.casa[18] = new Casa(262,338,30,30,false);
		this.casa[19] = new Casa(238,412,30,30,false);
		//manzana 4 fila 3
		this.casa[20] = new Casa(262,538,30,30,false);
		
		//manzana 1 fila 4
		this.casa[14] = new Casa(338,38,30,30,false);
		this.casa[15] = new Casa(538,62,30,30,false);
		//manzana 2 fila 4
		this.casa[16] = new Casa(362,138,30,30,false);
		this.casa[17] = new Casa(362,262,30,30,false);
		//manzana 3 fila 4
		this.casa[18] = new Casa(362,338,30,30,false);
		this.casa[19] = new Casa(338,412,30,30,false);
		//manzana 4 fila 4
		this.casa[20] = new Casa(362,462,30,30,false);
		
		
		//manzana 1 fila 5
		this.casa[21] = new Casa(662,38,30,30,false);
		this.casa[22] = new Casa(738,62,30,30,false);
		//manzana 2 fila 5
		this.casa[23] = new Casa(562,138,30,30,false);
		this.casa[24] = new Casa(562,262,30,30,false);
		//manzana 3 fila 5
		this.casa[25] = new Casa(562,338,30,30,false);
		this.casa[26] = new Casa(538,412,30,30,false);
		//manzana 4 fila 5
		this.casa[27] = new Casa(562,538,30,30,false);
		
		//manzana 1 fila 6
		this.casa[28] = new Casa(662,38,30,30,false);
		this.casa[29] = new Casa(615,62,30,30,false);
		//manzana 2 fila 6
		this.casa[30] = new Casa(662,138,30,30,false);
		this.casa[31] = new Casa(662,262,30,30,false);
		//manzana 3 fila 6
		this.casa[32] = new Casa(662,338,30,30,false);
		this.casa[33] = new Casa(662,412,30,30,false);
		//manzana 4 fila 6
		this.casa[34] = new Casa(662,562,30,30,false);
		
		//manzana 1 fila 6
		this.casa[35] = new Casa(738,138,30,30,false);
		this.casa[36] = new Casa(738,562,30,30,false);
		//manzana 2 fila 6
		this.casa[37] = new Casa(738,138,30,30,false);
		this.casa[38] = new Casa(738,262,30,30,false);
		
		this.casa[39] = new Casa(738,338,30,30,false);
		this.casa[40] = new Casa(738,462,30,30,false);
		
		this.seleccionarCasa = (int) (Math.random()*casa.length);
		
		
		
		
		/*INICIALIZAR VENTANA INSTRUCCIONES*/
		this.ventanaInstrucciones = new JFrame();
		this.iniciar = new JButton("Iniciar");
		this.instrucciones = new JButton("Instrucciones");
		this.etiquetaBienvenido = new JLabel("<html>Toque el botón 'Iniciar' si desea jugar o 'Instrucciones'</html>");
		this.etiquetaInstrucciones = new JLabel("<html><br><br><br><br><br><center>Instrucciones:</center> Shift: Utilizala para comprarle una flor al vendedor y luego para entregarla a la casa <br><br> Barra espaciadora: Utilizala para usar el rasengan <br><br> Iconos: cuando aparezcan el rasengan y/o la flor es que los podes utilizar <br><br> Si juntas 3 hongos podes activar de nuevo el rasengan</html>");
		
		
		/*INICIALIZAR VENTANA INSTRUCCIONES*/
		this.ventanaInstrucciones.setBounds(800, 300, 400, 300);
		this.iniciar.setBounds(50,50,100,30);
		this.instrucciones.setBounds(250, 50, 120,30);
		
		this.ventanaInstrucciones.add(this.instrucciones);
		this.ventanaInstrucciones.add(this.iniciar);
		this.ventanaInstrucciones.add(this.etiquetaBienvenido);
		this.ventanaInstrucciones.add(this.etiquetaInstrucciones);
		this.ventanaInstrucciones.setTitle("Iniciar Juego");
		this.etiquetaBienvenido.setBounds(50, -15, 400, 100);
		this.etiquetaInstrucciones.setBounds(10, 0, 380, 500);
		this.etiquetaInstrucciones.setVisible(false);
		
		
		
		
		/*INICIALIZAR VENTANA GAME OVER*/
		this.ventana=new JFrame();
		this.salir=new JButton("Salir");
		this.reiniciar=new JButton("Reiniciar");
		this.etiqueta = new JLabel("Fin del juego. ¿Qué desea hacer?");
		
		
		/*INICIALIZAR VENTANA GAME OVER*/
		this.ventana.setBounds(800, 300, 400, 300);
		this.reiniciar.setBounds(50, 200, 100,30);
		this.salir.setBounds(250, 200, 100,30);
		
		this.ventana.add(this.reiniciar);
		this.ventana.add(this.salir);
		this.ventana.add(this.etiqueta);
		
		this.etiquetaPuntaje = new JLabel("");
		this.ventana.add(this.etiquetaPuntaje);
		this.etiquetaPuntaje.setBounds(90, 10, 400, 100);
		this.etiqueta.setBounds(90, 110, 400, 100);
		
		this.ventana.setTitle("GAME OVER");
		
		
		ventana.setLayout(null);
		
		
		
		//BOTON SALIR
		salir.addActionListener(new ActionListener(){
			public void actionPerformed (){
				entorno.dispose();
				ventana.dispose();
			}

			@Override
			public void actionPerformed(ActionEvent e) {
				entorno.dispose();
				ventana.dispose();
				
			}
		});
		
		//BOTON REINICIAR
		reiniciar.addActionListener(new ActionListener(){
			public void actionPerformed (){
				//SETEAR EN 0 TODOS LOS ENEMIGOS NINJA
				for (int v=0 ; v < EnemigoNinjaV.length; v++) {
					EnemigoNinjaV[v].setY(-50);
					EnemigoNinjaV[v].setDetener(true);
					

				}
				for (int h=0 ; h < EnemigoNinjaH.length; h++) {
						EnemigoNinjaH[h].setX(-50);
						EnemigoNinjaH[h].setDetener(true);
				}
				
				//PONER EN 0 LOS PUNTOS
				puntajex=0;
				
				//APAGAR ESTA VENTANA
				ventana.dispose();
				
				//SETEAR EN 0 EL PERSONAJE
				sakura.setX(100);
				sakura.setY(585);
				
				//SETEAR CASA SELECCIONADA FLORERO Y CONSUMIBLE
				seleccionarCasa=(int) (Math.random()*casa.length);
				//seleccionarConsumible=(int) (Math.random()*casa.length);
				seleccionarFlorero=(int) (Math.random()*casa.length);
				empezarTiempoConsumible=false;
				EmpezarTiempo=false;
				cantConsumible=0;
				tiempo=0;
				sakura.setEnabledDisparar(false);
				
				//APARECER VENTANA
				entorno.setVisible(true);
				
			}
				
			
			

			@Override
			public void actionPerformed(ActionEvent e) {
				//SETEAR EN 0 TODOS LOS ENEMIGOS NINJA
				for (int v=0 ; v < EnemigoNinjaV.length; v++) {
					EnemigoNinjaV[v].setY(0);

				}
				for (int h=0 ; h < EnemigoNinjaH.length; h++) {
						EnemigoNinjaH[h].setX(0);
				}
				
				//PONER EN 0 LOS PUNTOS
				puntajex=0;
				
				//APAGAR ESTA VENTANA
				ventana.dispose();
				
				//SETEAR EN 0 EL PERSONAJE
				sakura.setX(100);
				sakura.setY(585);
				
				//SETEAR CASA SELECCIONADA FLORERO Y CONSUMIBLE
				seleccionarCasa=(int) (Math.random()*casa.length);
				//seleccionarConsumible=(int) (Math.random()*consumible.length);
				seleccionarFlorero=(int) (Math.random()*florero.length);
				empezarTiempoConsumible=false;
				EmpezarTiempo=false;
				cantConsumible=0;
				tiempo=0;
				sakura.setEnabledDisparar(false);
				
				//APARECER VENTANA
				entorno.setVisible(true);
			}
		});
		
		
		//BOTON INICIAR
				iniciar.addActionListener(new ActionListener(){
					public void actionPerformed (){
						//SETEAR EN 0 TODOS LOS ENEMIGOS NINJA
						for (int v=0 ; v < EnemigoNinjaV.length; v++) {
							EnemigoNinjaV[v].setY(0);

						}
						for (int h=0 ; h < EnemigoNinjaH.length; h++) {
								EnemigoNinjaH[h].setX(0);
						}
						
						//PONER EN 0 LOS PUNTOS
						puntajex=0;
						
						//APAGAR ESTA VENTANA Y PRENDER VENTANA ENTORNO
						ventanaInstrucciones.dispose();
						entorno.setVisible(true);
						
						//SETEAR EN 0 EL PERSONAJE
						sakura.setX(100);
						sakura.setY(585);
						
						//SETEAR CASA SELECCIONADA FLORERO Y CONSUMIBLE
						seleccionarCasa=(int) (Math.random()*casa.length);
						//seleccionarConsumible=(int) (Math.random()*consumible.length);
						seleccionarFlorero=(int) (Math.random()*florero.length);
						empezarTiempoConsumible=false;
						EmpezarTiempo=false;
						cantConsumible=0;
						tiempo=0;
						sakura.setEnabledDisparar(false);
						
					}
						
					
					

					@Override
					public void actionPerformed(ActionEvent e) {
						//SETEAR EN 0 TODOS LOS ENEMIGOS NINJA
						for (int v=0 ; v < EnemigoNinjaV.length; v++) {
							EnemigoNinjaV[v].setY(0);

						}
						for (int h=0 ; h < EnemigoNinjaH.length; h++) {
								EnemigoNinjaH[h].setX(0);
						}
						
						//PONER EN 0 LOS PUNTOS
						puntajex=0;
						
						//APAGAR ESTA VENTANA Y PRENDER VENTANA ENTORNO
						ventanaInstrucciones.dispose();
						entorno.setVisible(true);
						
						//SETEAR EN 0 EL PERSONAJE
						sakura.setX(100);
						sakura.setY(585);
						
						//SETEAR CASA SELECCIONADA FLORERO Y CONSUMIBLE
						seleccionarCasa=(int) (Math.random()*casa.length);
						//seleccionarConsumible=(int) (Math.random()*consumible.length);
						seleccionarFlorero=(int) (Math.random()*florero.length);
						empezarTiempoConsumible=false;
						EmpezarTiempo=false;
						cantConsumible = 0;
						tiempo=0;
						sakura.setEnabledDisparar(false);
					}
				});
				
				//BOTON INSTRUCCIONES
				instrucciones.addActionListener(new ActionListener(){
					public void actionPerformed (){
						if (etiquetaInstrucciones.isVisible()) {
							etiquetaInstrucciones.setVisible(false);
						}else {
							etiquetaInstrucciones.setVisible(true);
						}
						
					}
						
					
					

					@Override
					public void actionPerformed(ActionEvent e) {
						if (etiquetaInstrucciones.isVisible()) {
							etiquetaInstrucciones.setVisible(false);
						}else {
							etiquetaInstrucciones.setVisible(true);
						}
					}
				});
		
		// Inicia el juego!
		
		this.entorno.iniciar();
		
		ventanaInstrucciones.setVisible(true);
		
		
		
		
	}

public boolean estaEnRangoX(int posicionX, String direccion) {
		
		boolean valorAretornar = false ;
		
			if ((( posicionX == inicioXCalleA || posicionX == inicioXCalleB || posicionX == inicioXCalleC || posicionX == inicioXCalleD  ) && direccion!="Izquierda"   ) 
				 || ( ( posicionX == finXCalleA || posicionX == finXCalleB || posicionX == finXCalleC || posicionX == finXCalleD )  && (direccion!="Derecha"  )) )  {
				
			valorAretornar = true;
		}
		
		
		if ( ( posicionX > inicioXCalleA && posicionX < finXCalleA ) || (posicionX > inicioXCalleB  && posicionX < finXCalleB ) 
				|| (posicionX > inicioXCalleC  && posicionX < finXCalleC) || (posicionX > inicioXCalleD  && posicionX < finXCalleD )){
			
			valorAretornar = true;
		}

		return valorAretornar;
		
		
	}
	

	public boolean estaEnRangoY(int posicionY,String direccion) {
		
		boolean valorAretornar=false;
		
		
		if ((posicionY == inicioYCalle1 || posicionY == inicioYCalle2  || posicionY == inicioYCalle3  ) && (direccion!="Arriba") 
				|| (posicionY == finYCalle1 || posicionY == finYCalle2  || posicionY == finYCalle3) && ( direccion!="Abajo")  ) {
			
			valorAretornar = true;
			
		}
		if (posicionY > inicioYCalle1 && posicionY < finYCalle1 || posicionY > inicioYCalle2 && posicionY < finYCalle2 || posicionY > inicioYCalle3 && posicionY < finYCalle3 ) {
			valorAretornar = true;
		}
		
		return valorAretornar;
		
	}

	public boolean estaEnRangoConsumibleX(int posicionX ) {
		
		boolean x;
		
		x = ( ( posicionX > inicioXCalleA+30 && posicionX <= finXCalleA ) || (posicionX > inicioXCalleB +30 && posicionX < finXCalleB ) 
				|| (posicionX > inicioXCalleC+30  && posicionX < finXCalleC) || (posicionX > inicioXCalleD  && posicionX < finXCalleD ));
		
		return x ;
		
		
	}
	
	public boolean estaEnRangoConsumibleY(int posicionY ) {
		
	
		boolean y;
		
		y = (posicionY > inicioYCalle1 && posicionY < finYCalle1 || posicionY > inicioYCalle2 && posicionY < finYCalle2 
				|| posicionY > inicioYCalle3 && posicionY < finYCalle3 ) ;
			
		
		return y ;
		
		
	}
	
	/**
	 * Durante el juego, el mÃ©todo tick() serÃ¡ ejecutado en cada instante y 
	 * actualizar el estado interno del juego para simular el paso del tiempo 
	 * (ver el enunciado del TP para mayor detalle).
	 */
	
	
		

	public void tick()
	{		
		
		if(ventanaInstrucciones.isVisible()) {
			entorno.setVisible(false);
		}
		
		
		
		// Procesamiento de un instante de tiempo
		// ...
		
		
		//DIBUJAR MANZANAS
		entorno.dibujarImagen(this.manzana,50,40, 0,0.5);
		entorno.dibujarImagen(this.manzana,200,40, 0,0.8);
		entorno.dibujarImagen(this.manzana,400,40, 0,0.8);
		entorno.dibujarImagen(this.manzana,600,40, 0,0.8);
		entorno.dibujarImagen(this.manzana,770,40, 0,0.5);
		
		entorno.dibujarImagen(this.manzana,0,200, 0,0.9);
		entorno.dibujarImagen(this.manzana,200,200, 0,0.9);
		entorno.dibujarImagen(this.manzana,400,200, 0,0.9);
		entorno.dibujarImagen(this.manzana,600,200, 0,0.9);
		entorno.dibujarImagen(this.manzana,810,200, 0,0.9);
		
		entorno.dibujarImagen(this.manzana,0,400, 0,0.9);
		entorno.dibujarImagen(this.manzana,200,400, 0,0.9);
		entorno.dibujarImagen(this.manzana,400,400, 0,0.9);
		entorno.dibujarImagen(this.manzana,600,400, 0,0.9);
		entorno.dibujarImagen(this.manzana,810,400, 0,0.9);
		
		entorno.dibujarImagen(this.manzana,0,600, 0,0.9);
		entorno.dibujarImagen(this.manzana,200,600, 0,0.9);
		entorno.dibujarImagen(this.manzana,400,600, 0,0.9);
		entorno.dibujarImagen(this.manzana,600,600, 0,0.9);
		entorno.dibujarImagen(this.manzana,810,600, 0,0.9);
		
		//DIBUJAR CALLES
		calleA.dibujarse(entorno);
		calle1.dibujarse(entorno);
		
		calleB.dibujarse(entorno);
		calle2.dibujarse(entorno);
		
		calleC.dibujarse(entorno);
		calle3.dibujarse(entorno);
		
		calleD.dibujarse(entorno);
		
		
		
			
		
		//DIBUJAR CASAS
		for(int c=0; c<casa.length;c++) {
			if(c==seleccionarCasa) {
				casaSeleccionada=casa[c];
				casaSeleccionada.dibujarseSeleccionado(entorno);
				casaSeleccionada.setSeleccionar(true);
				
			}
			else {
				casa[c].dibujarse(entorno);
			}
		}
		
		
		
		//DIBUJAR FONDO CON STRINGS DE PUNTAJE
		
		entorno.dibujarRectangulo(400, 567,150, 85, 0, Color.gray);
		entorno.cambiarFont("Times-New-Roman", 22, Color.black);
		String pje = String.valueOf(puntajex);
		entorno.escribirTexto("Puntaje: "+pje, 350, 550);
		
		
		
		//DIBUJAR VENDEDORES DE FLORES
				for(int f=0; f<florero.length;f++) {
					if(f==seleccionarFlorero) {
						floreroSeleccionado = florero[f];
						floreroSeleccionado.dibujarse(entorno);
				}
						
					}
		
		//DIBUJAR PERSONAJE
		sakura.dibujarse(entorno);
		
		
		//MOVER PERSONAJE
		if(this.entorno.estaPresionada(this.entorno.TECLA_IZQUIERDA) && this.sakura.getX()-(this.sakura.getAncho()/2) > 0) {
			
			if ( estaEnRangoY(this.sakura.getY(),"Izquierda") || estaEnRangoX(this.sakura.getX(),"Izquierda") )  {
				
				sakura.moverIzquierda();
				ultimaDireccionRasengan = "Izquierda";
				
			}
			
			
		}
		
		if(this.entorno.estaPresionada(this.entorno.TECLA_DERECHA)&& this.sakura.getX() < this.entorno.getWidth()-35)  {
			
			
			if ( estaEnRangoY(this.sakura.getY(),"Izquierda")  || estaEnRangoX(this.sakura.getX(),"Derecha")     ) {
				
				sakura.moverDerecha();
				ultimaDireccionRasengan = "Derecha";
			}
			
		}
		
		
		
		
		if(this.entorno.estaPresionada(this.entorno.TECLA_ARRIBA)&& this.sakura.getY()- (this.sakura.getAlto()/2) > 0 ) {
			
			if (estaEnRangoY(this.sakura.getY(),"Arriba") || estaEnRangoX(this.sakura.getX(),"Arriba") )   {
				
				sakura.moverArriba();
				ultimaDireccionRasengan = "Arriba";
			}
		}
		
		if(this.entorno.estaPresionada(this.entorno.TECLA_ABAJO) && this.sakura.getY() < this.entorno.getHeight()-54 ) {
			
			if ( estaEnRangoY(this.sakura.getY(),"Abajo") || estaEnRangoX(this.sakura.getX(),"Abajo")   )  {
				
				sakura.moverAbajo();
				ultimaDireccionRasengan = "Abajo";
			}
		}
		
		//PRESIONAR ESPACIO PARA QUE SAKURA DISPARE
		
		if (this.entorno.estaPresionada(this.entorno.TECLA_ESPACIO) && !(this.sakura.getEnabledDisparar())  ) {
			
			this.rasengan.setX(this.sakura.getX());
			this.rasengan.setY(this.sakura.getY());
			
			activarDisparo=true ;
			
			direccionRasengan = ultimaDireccionRasengan ; 
			
			
		}
		
		//DIBUJAR RASENGAN EN EL INVENTARIO
		if(!this.sakura.getEnabledDisparar())
			entorno.dibujarImagen(rasen, 420, 575, 0, 0.3);
		
		//COLISION VENDEDOR DE FLORES - SAKURA
		if (Colision.colisionFloreroSakura(floreroSeleccionado, sakura)) {
			floresEntregadas = true;
			//SI PRESIONO SHIFT EL FLORERO ME DA UNA FLOR
			if(this.entorno.estaPresionada(this.entorno.TECLA_SHIFT) && !(this.floreroSeleccionado.getEnabledEntregarFlores())) {
				this.floreroSeleccionado.setEnabledEntregarFlores(true);
			}
		}else {
			floresEntregadas = false;
		}
		
		
		
		//DIBUJAR FLOR EN EL INVENTARIO
		if(this.floreroSeleccionado.enabledEntregarFlores) {
			entorno.dibujarImagen(flor, 370, 575, 0, 0.1);
		}
		
		
		
		//COLISION CASA - SAKURA
		
			if (Colision.colisionCasaSakura(casaSeleccionada, sakura)) {
				
				//SI PRESIONO SHIFT ENTREGO FLORES A LA CASA
				
					if(this.entorno.estaPresionada(this.entorno.TECLA_SHIFT) && this.floreroSeleccionado.getEnabledEntregarFlores() && casaSeleccionada.getSeleccionar()) {
								this.puntajex=this.puntajex+50;
								this.floreroSeleccionado.setEnabledEntregarFlores(false);
								this.seleccionarCasa = (int)(Math.random()*this.casa.length);
								this.seleccionarFlorero = (int)(Math.random()*this.florero.length);
						}
						
					}
							
							
			// DIBUJAR CONSUMIBLE 
			if(empezarTiempoConsumible==false)
				consumible.dibujarse(entorno);  
										
				//COLISION CONSUMIBLE - SAKURA
					if(Colision.colisionConsumibleSakura(consumible, sakura) || consumiblePrimeraAparicion) {
							
					int x=0;
					int y=0;
							
					consumiblePrimeraAparicion=false;
					consumible.setEnabled(true);
					empezarTiempoConsumible=true;
					puntajex=puntajex+10;
					cantConsumible++;
					
							
					boolean salirX=true;
					boolean salirY=true;
							
					while(salirX && salirY) {
						
						salirX= !estaEnRangoConsumibleX(x = (int) (Math.random()*(this.entorno.getWidth()-35)));
						salirY=	!estaEnRangoConsumibleY(y = (int) (Math.random()*this.entorno.getHeight()-54 ));							
					}
							
					this.consumible.setX(x);
					this.consumible.setY(y);	
					System.out.println(x);
					System.out.println(y);
					}
					// TIEMPO PARA QUE APAREZCA OTRO CONSUMBILE
					if (empezarTiempoConsumible) {
							
						if (tiempoConsumible++ == 150) {
							consumible.setEnabled(false);
							tiempoConsumible = 0;	
							empezarTiempoConsumible = false ;
								
						}
							
					}
		
			
		
		
		//DIBUJAR Y MOVER NINJAS VERTICALES
		
		for (int v=0 ; v < EnemigoNinjaV.length; v++) {
			
			if ( !(EnemigoNinjaV[v].Enabled())   ) {
				EnemigoNinjaV[v].dibujarse(entorno);
				
				if (this.EnemigoNinjaV[v].getY() <= this.entorno.getHeight()) {
			
					EnemigoNinjaV[v].moverAbajo();
			
				}else {
					
					this.EnemigoNinjaV[v].setY(0);
			
				}
			}
			//COLISION NINJA VERTICAL - SAKURA
			
			if ( Colision.colisionSakura(EnemigoNinjaV[v],sakura,false) &&  !EnemigoNinjaV[v].Enabled() ) {
				
				ventana.setVisible(true);
				entorno.setVisible(false);
				
				}
			
			
			
		}
		
		//DIBUJAR Y MOVER NINJAS HORIZONTALES
		
		for (int h=0 ; h < EnemigoNinjaH.length; h++) {
			
			if ( !(EnemigoNinjaH[h].Enabled()) ) {
				
				EnemigoNinjaH[h].dibujarse(entorno);
				
				
				
				if (this.EnemigoNinjaH[h].getX() <= this.entorno.getWidth()) {
			
					EnemigoNinjaH[h].moverDerecha();
			
				}else {
					
					this.EnemigoNinjaH[h].setX(0);
					
				}
		
			}
			
			//COLISION NINJA HORIZONTAL - SAKURA
			if (  Colision.colisionSakura(EnemigoNinjaH[h],sakura,false) &&  !EnemigoNinjaH[h].Enabled() ) {
				ventana.setVisible(true);
				entorno.setVisible(false);
			}
				
				
		}
			
		
		//DIBUJAR RASENGAN SI ESTA ACTIVADO
		
		if (activarDisparo ) {
			rasengan.dibujarse(entorno);
			
			if( direccionRasengan == "Arriba") {
				rasengan.moverArriba();
			}else if( direccionRasengan == "Abajo") {
				rasengan.moverAbajo();
			}else if( direccionRasengan == "Izquierda") {
				rasengan.moverIzquierda();
			}else if( direccionRasengan == "Derecha") {
				rasengan.moverDerecha();
			}
			
			
			//COLISION RASENGAN - NINJA VERTICAL
			for (int v=0 ; v < EnemigoNinjaV.length; v++) {
				
					if(  Colision.colisionRasegan(EnemigoNinjaV[v],rasengan) ) {
				
						this.EnemigoNinjaV[v].setEnabled(true);
						this.EnemigoNinjaV[v].setY(0);
				
						this.sakura.setEnabledDisparar(true);
						activarDisparo = false ;
				
						EmpezarTiempo = true ;
						
						this.puntajex=this.puntajex+25;
					}
					}
			
			//COLISION RASENGAN - NINJA HORIZONTAL
			for (int h=0 ; h < EnemigoNinjaH.length; h++) {
						
					if(  Colision.colisionRasegan(EnemigoNinjaH[h],rasengan) ) {
					
						this.EnemigoNinjaH[h].setEnabled(true);
						this.EnemigoNinjaH[h].setX(0);
					
						this.sakura.setEnabledDisparar(true);
						activarDisparo = false ;
				
						EmpezarTiempo = true ;
						this.puntajex=this.puntajex+25;
					}
			}
			
			//RASENGAN FUERA DE LA PANTALLA
			if (rasengan.getX() < 0 ||  rasengan.getX() > this.entorno.getWidth()  || rasengan.getY() < 0 || rasengan.getY() > this.entorno.getHeight()  ) {
				
				this.sakura.setEnabledDisparar(true);
				activarDisparo = false ;
				EmpezarTiempo = true ;
				
					}
			
			
		
		}
		
		
		
		if (EmpezarTiempo) {
			if (tiempo++ == 500) {
				tiempo = 0;
				EmpezarTiempo = false ;
				
				//DIBUJAR NINJA QUE DESAPARECIO POR EL RASENGAN
				
				for (int v=0 ; v < EnemigoNinjaV.length; v++) {
					
					this.EnemigoNinjaV[v].setEnabled(false);
				}
				
				for (int h=0 ; h < EnemigoNinjaH.length; h++) {
					
					this.EnemigoNinjaH[h].setEnabled(false);
				}
				
				
			}
		}
		//SI LA CANTIDAD DE CONSUMIBLES ES 3 ACTIVAR RASENGAN
		if(cantConsumible==3) {
			sakura.setEnabledDisparar(false);
			cantConsumible=0;
		}
		
		
		//COLISION ENTRE NINJAS
				for (int h=0 ; h < EnemigoNinjaH.length; h++) {
					for (int v=0 ; v < EnemigoNinjaV.length; v++) {
						
						if (Colision.colisionEntreNinja(this.EnemigoNinjaH[h],this.EnemigoNinjaV[v])) {
							this.EnemigoNinjaV[v].setDetener(true);
							
							EmpezarTiempoNinja=true;
						}
						
					}
					
					
				}
				
				for (int v=0 ; v < EnemigoNinjaV.length; v++) {
					if(this.EnemigoNinjaV[v].getDetener()) {
						this.EnemigoNinjaV[v].setVelocidad(0);
				}else {
					this.EnemigoNinjaV[v].setVelocidad(2);
					}
				}
				
				//TIEMPO PARA QUE SE MUEVA UN NINJA DESPUES DE COLISIONAR CONTRA OTRO
				if (EmpezarTiempoNinja) {
					if (tiempoNinja++ == 40) {
						tiempoNinja = 0;
						EmpezarTiempoNinja = false ;
						
						//APARECER NINJA QUE COLISIONO CON RASENGAN
						
						for (int v=0 ; v < EnemigoNinjaV.length; v++) {
							
							this.EnemigoNinjaV[v].setDetener(false);
						}
						
					}
				}
				
				
				
		
		iniciarPanel();
		
		//SETEO EL PUNTAJE A LO ULTIMO PARA QUE TOME LA VARIABLE PUNTAJE
		etiquetaPuntaje.setText("El puntaje obtenido es de "+pje+" puntos");
		}
	
	
	public void iniciarPanel() {
		
		
	}
	

	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		Juego juego = new Juego();
		
		
	}
}
