package proyecto;



public class Colision {
	
	

	
	
public static boolean colisionRasegan(EnemigoNinja ninja , Rasengan rasengan ) {
		
		int minimoRanseganX =  rasengan.getX() - ( rasengan.getAncho()/2 ) ;
		int maximoRanseganX =  rasengan.getX() + ( rasengan.getAncho()/2 ) ;
		
		int minimoRanseganY =  rasengan.getY() - ( rasengan.getAlto()/2 ) ;
		int maximoRanseganY =  rasengan.getY() + ( rasengan.getAlto()/2 ) ;
		
		
		
		boolean x = minimoRanseganX >= ( ninja.getX() - ninja.getAncho()/2 ) && minimoRanseganX <= ( ninja.getX() + ninja.getAncho()/2 ) ||
				maximoRanseganX >= ( ninja.getX() - ninja.getAncho()/2 ) && maximoRanseganX <= ( ninja.getX() + ninja.getAncho()/2 );
			
		boolean y= 	(minimoRanseganY >= (ninja.getY() - ninja.getAlto()/2 ) && minimoRanseganY < (ninja.getY() + ninja.getAlto()/2 ) ) ||
				maximoRanseganY >= ( ninja.getY() - ninja.getAlto()/2 ) && maximoRanseganY <= ( ninja.getY() + ninja.getAlto()/2 );;
		
        return  x && y ;
		
		
	}

public static boolean colisionSakura(EnemigoNinja ninja ,  Sakura sakura ,boolean direccionNinjaHorizontal) {
	
	int minimoSakuraX =  sakura.getX() - ( sakura.getAncho()/2 ) ;
	int maximoSakuraX =  sakura.getX() + ( sakura.getAncho()/2 ) ;
	
	int minimoSakuraY =  sakura.getY() - ( sakura.getAlto()/2 ) ;
	int maximoSakuraY =  sakura.getY() + ( sakura.getAlto()/2 ) ;
	
	int horizontal=0;
	int vertical=0;
	
	if ( direccionNinjaHorizontal) {
		horizontal=5;
		
	}else {
		vertical=5;
	}
	
	boolean x = minimoSakuraX >= ( ninja.getX() - ninja.getAncho()/2 ) && minimoSakuraX <= ( ninja.getX() + ninja.getAncho()/2) - horizontal ||
			maximoSakuraX >= ( ninja.getX() - ninja.getAncho()/2 + horizontal ) && maximoSakuraX <= ( ninja.getX() + ninja.getAncho()/2 );
		
	boolean y= 	(minimoSakuraY >= (ninja.getY() - ninja.getAlto()/2 ) && minimoSakuraY <= (ninja.getY() + ninja.getAlto()/2 ) + horizontal - vertical ) ||
				(maximoSakuraY >= (ninja.getY() - ninja.getAlto()/2 + vertical) && maximoSakuraY <= (ninja.getY()+ ninja.getAlto()/2) );
	
    return  x && y ;
	
	
}

public static boolean colisionFloreroSakura(Florero florero, Sakura sakura) {
	int minimoFloreroX = florero.getX() - florero.getAncho()/2;
	int maximoFloreroX = florero.getX() + florero.getAncho()/2;
	
	int minimoFloreroY = florero.getY() - florero.getAlto()/2;
	int maximoFloreroY = florero.getY() + florero.getAlto()/2;
	
	boolean x = minimoFloreroX >= (sakura.getX() - sakura.getAncho()/2) && minimoFloreroX <= (sakura.getX() + sakura.getAncho()/2) ||
			maximoFloreroX >= (sakura.getX()- sakura.getAncho()/2) && maximoFloreroX <= (sakura.getX() + sakura.getAncho()/2);
			
	boolean y = (minimoFloreroY >= (sakura.getY() - sakura.getAlto()/2) && minimoFloreroY <= (sakura.getY()+sakura.getAlto()/2) ||
			(maximoFloreroY >= (sakura.getY()-sakura.getAlto()/2)) && maximoFloreroY <= (sakura.getY()+sakura.getAlto()/2));
	
	return x && y;
}

public static boolean colisionCasaSakura(Casa casa, Sakura sakura) {
	int minimoCasaX = casa.getX() - casa.getAncho()/2;
	int maximoCasaX = casa.getX() + casa.getAncho()/2;
	
	int minimoCasaY = casa.getY() - casa.getAlto()/2;
	int maximoCasaY = casa.getY() + casa.getAlto()/2;
	
	boolean x = minimoCasaX >= (sakura.getX() - sakura.getAncho()/2) && minimoCasaX <= (sakura.getX() + sakura.getAncho()/2) ||
			maximoCasaX >= (sakura.getX()- sakura.getAncho()/2) && maximoCasaX <= (sakura.getX() + sakura.getAncho()/2);
			
	boolean y = (minimoCasaY >= (sakura.getY() - sakura.getAlto()/2) && minimoCasaY <= (sakura.getY()+sakura.getAlto()/2) ||
			(maximoCasaY >= (sakura.getY()-sakura.getAlto()/2)) && maximoCasaY <= (sakura.getY()+sakura.getAlto()/2));
	
	return x && y;
}

public static boolean colisionConsumibleSakura(Consumible consumible, Sakura sakura) {
	int minimoConsumibleX = consumible.getX() - consumible.getAncho()/2;
	int maximoConsumibleX = consumible.getX() + consumible.getAncho()/2;
	
	int minimoConsumibleY = consumible.getY() - consumible.getAlto()/2;
	int maximoConsumibleY = consumible.getY() + consumible.getAlto()/2;
	
	boolean x = minimoConsumibleX >= (sakura.getX() - sakura.getAncho()/2) && minimoConsumibleX <= (sakura.getX() + sakura.getAncho()/2) ||
			maximoConsumibleX >= (sakura.getX()- sakura.getAncho()/2) && maximoConsumibleX <= (sakura.getX() + sakura.getAncho()/2);
			
	boolean y = (minimoConsumibleY >= (sakura.getY() - sakura.getAlto()/2) && minimoConsumibleY <= (sakura.getY()+sakura.getAlto()/2) ||
			(maximoConsumibleY >= (sakura.getY()-sakura.getAlto()/2)) && maximoConsumibleY <= (sakura.getY()+sakura.getAlto()/2));
	
	return x && y;
}

public static boolean colisionEntreNinja(EnemigoNinja ninjaH ,  EnemigoNinja ninjaV  ) {
	
	int minimoNinjaHX =  ninjaH.getX() - ( ninjaH.getAncho()/2 ) ;
	int maximoNinjaHX =  ninjaH.getX() + ( ninjaH.getAncho()/2 ) ;
	
	int minimoNinjaHY =  ninjaH.getY() - ( ninjaH.getAlto()/2 ) ;
	int maximoNinjaHY =  ninjaH.getY() + ( ninjaH.getAlto()/2 ) ;
	
	
	
	boolean x = minimoNinjaHX >= ( ninjaV.getX() - ninjaV.getAncho()/2 ) && minimoNinjaHX <= ( ninjaV.getX() + ninjaV.getAncho()/2 ) ||
			maximoNinjaHX >= ( ninjaV.getX() - ninjaV.getAncho()/2 ) && maximoNinjaHX <= ( ninjaV.getX() + ninjaV.getAncho()/2 );
		
	boolean y = 	(minimoNinjaHY >= (ninjaV.getY() - ninjaV.getAlto()/2+20 ) && maximoNinjaHY < (ninjaV.getY() + ninjaV.getAlto()/2+20 ) ) ||
			maximoNinjaHY >= ( ninjaV.getY() - ninjaV.getAlto()/2+20) && maximoNinjaHY <= ( ninjaV.getY() + ninjaV.getAlto()/2+20 );
	
    return  x && y ;
	
	
}

}
