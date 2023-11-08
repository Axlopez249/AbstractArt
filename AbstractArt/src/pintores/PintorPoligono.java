package pintores;
import java.awt.Color;
import java.util.Random;

import pintoresInterface.*;
import ui.ControllerLienzo;
import ui.Lienzo;

public class PintorPoligono implements IPintorProduct{
	private int grosor;
	private int xPosition;
	private int yPosition;
	private int ancho;
	private int alto;
	private Color color;
	private int cantMovimientos;
	private Lienzo lienzo;
	private boolean estado = false;
	private int k;
	
	public PintorPoligono(int k) {
		this.k = k;
	}
	@Override
	public void pintar(int grosor, int xPosition, int yPosition, int ancho, int alto, Color color) {
		this.grosor = grosor;
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.color = color;
		this.ancho = ancho;
		this.alto = alto;
		getPoligono();
		
	}


	@Override
	public void actualizar(boolean estado) {
		this.estado = estado;
		
	}

	@Override
	public void setMovimientos(int pmovimientos) {
		this.cantMovimientos = pmovimientos;
		
	}
	public void setLienzo(Lienzo plienzo) {
		this.lienzo = plienzo;
	}
	
	public void getPoligono() {

		String[] figuras = {"Cuadrado", "Triangulo"};

        Random random = new Random();
        int contador = random.nextInt(figuras.length); // Genera un índice aleatorio
        ControllerLienzo controller = new ControllerLienzo(lienzo);
        if (figuras[contador].equals("Cuadrado")) {
        	controller.crearCuadrado( grosor,  xPosition,  yPosition,  ancho,  alto,  color);
        }else if (figuras[contador].equals("Triangulo")) {
            controller.crearTriangulo(grosor,  xPosition,  yPosition,  ancho,  alto,  color);
        }
			
		
	}

	@Override
	public Color getColor() {
		return color;
	}

	@Override
	public int getGrosor() {
		return grosor;
	}


	@Override
	public int getAncho() {
		return ancho;
	}


	@Override
	public int getAlto() {
		return alto;
	}

	@Override
	public int getX() {
		
		return xPosition;
	}

	@Override
	public int getY() {
		return yPosition;
	}

	@Override
	public void actualizarMovimientos() {
		cantMovimientos--;
	}

	@Override
	public int getMovimientos() {
		return cantMovimientos;
	}

}