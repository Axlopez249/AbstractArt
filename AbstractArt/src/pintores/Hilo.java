package pintores;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import pintoresInterface.*;
import ui.ControllerLienzo;
import ui.Lienzo;

public class Hilo implements Runnable{
	private GeneradorPintor generador = new GeneradorPintor();
	
	
	Random random = new Random();
	private int cantidadPintores;//Cantidad de pintores
	private int cantidadMovimientos;//Estos son los valores que se especifican para llevar el control de los movimientos
	
	private ArrayList<IPintorProduct> listaPintores = new ArrayList<>();//Lista de pintores a utilizar
	private String colores[]= {"Red", "Black", "Blue"}; //Lista de colores a utilizar
	
	private Iterador iterador;//Iterador que me itera sobre cada printor
	private SujetoObserver sujeto; //Me informa de los estados activos y no activos de los objetos y los actualizaz
	
	private int contadorLocal = 0;//Contador
	
	public Hilo(int pcanttidadPintores, int pcantidadMovimientos, Lienzo lienzo) {
		cantidadPintores = pcanttidadPintores;
		cantidadMovimientos = pcantidadMovimientos;
		
		//aqui genero la lista que va a contener todos los pintores y la lleno para poder hacer uso de next()
		String pintores[]= {"PintorPoligono", "PintorPunto", "PintorRaya"};
		int contador = 0;
		for (int i = 0; i < pcanttidadPintores; i++) {
			
			if (contador==3) {contador = 0;}
			
			if (pintores[contador].equals("PintorPoligono")) {
				
				IPintorProduct pintorPoli = generador.getPintorPoligono();
				pintorPoli.setMovimientos(pcantidadMovimientos);
				pintorPoli.setLienzo(lienzo);
				listaPintores.add(pintorPoli);
				
			}if (pintores[contador].equals("PintorPunto")) {
				
				IPintorProduct pintorPun = generador.getPintorPunto();
				pintorPun.setMovimientos(pcantidadMovimientos);
				pintorPun.setLienzo(lienzo);
				listaPintores.add(pintorPun);
				
			}
			if (pintores[contador].equals("PintorRaya")) {
				
				IPintorProduct pintorRay = generador.getPintorRaya();
				pintorRay.setMovimientos(pcantidadMovimientos);
				pintorRay.setLienzo(lienzo);
				listaPintores.add(pintorRay);
			}
			contador ++;
			
		}
		
		iterador = new Iterador(listaPintores);
		sujeto = new SujetoObserver(listaPintores);

	}
	@Override
	public void run() {
	    while (true) {
	    	//Verificar la cantidad de movimientos que tiene el objeto para que sea detenido y que no continue
	    	IPintorProduct pintor = iterador.next();
	    	while (pintor.getMovimientos() < 0) {
				pintor = iterador.next();
			}
	        

	        if (contadorLocal != 0) {
	            IPintorProduct pintorAnterior = iterador.last();
	            
	       
	            int minX = pintorAnterior.getX();
	            int maxX = minX+100;
	            int newX = random.nextInt(maxX - minX + 1) + minX;
	            
	            int minY = pintorAnterior.getY();
	            int maxY = minX+90;
	            int newY = random.nextInt(maxX - minX + 1) + minX;
	            
	            int minGrosor = pintorAnterior.getGrosor();
	            int maxGrosor = minX+5;
	            int newGrosor = random.nextInt(maxX - minX + 1) + minX;
	            
	            int minAlto = pintorAnterior.getAlto();
	            int maxAlto = minX+40;
	            int newAlto = random.nextInt(maxX - minX + 1) + minX;
	            
	            int minAncho = pintorAnterior.getAncho();
	            int maxAncho = minX+70;
	            int newAncho = random.nextInt(maxX - minX + 1) + minX;

	            pintorAnterior.actualizar(false);
	            // Asegura que contador sea al menos 1
	            
	            
	            while (true) {
	            	int i = Math.abs(random.nextInt(colores.length));
	            	if (colores[i].equals("Blue")) {
	            		if (Color.blue != pintorAnterior.getColor()) {
			                pintor.actualizar(true);
			                pintor.pintar(newGrosor, newX, newY, newAlto, newAncho, Color.blue);
			                pintor.actualizarMovimientos();
			                break;
			            } 
					}if (colores[i].equals("Black")) {
	            		if (Color.black != pintorAnterior.getColor()) {
			                pintor.actualizar(true);
			                pintor.pintar(newGrosor, newX, newY, newAlto, newAncho, Color.black);
			                pintor.actualizarMovimientos();
			                break;
			            } 
					}if (colores[i].equals("Red")) {
	            		if (Color.red != pintorAnterior.getColor()) {
			                pintor.actualizar(true);
			                pintor.pintar(newGrosor, newX, newY, newAlto, newAncho, Color.red);
			                pintor.actualizarMovimientos();
			                break;
			            } 
					}
				}  
	        } else {
	            int x = 100;
	            int y = 300;
	            int grosor = 8;
	            int alto = 50;
	            int ancho = 90;

	            int contador = Math.abs(random.nextInt(colores.length));
	            if (colores[contador].equals("Blue")) {
	            	pintor.pintar(grosor, x, y, alto, ancho, Color.blue);
		            pintor.actualizarMovimientos();
		            pintor.actualizar(true);
				}if (colores[contador].equals("Black")) {
	            	pintor.pintar(grosor, x, y, alto, ancho, Color.black);
		            pintor.actualizarMovimientos();
		            pintor.actualizar(true);
				}if (colores[contador].equals("Red")) {
	            	pintor.pintar(grosor, x, y, alto, ancho, Color.red);
		            pintor.actualizarMovimientos();
		            pintor.actualizar(true);
				}
				
	            
	        }

	        contadorLocal++;
	        

	        try {
	            Thread.sleep(300);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
	}

	
}
