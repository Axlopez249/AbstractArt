package pintores;
import java.awt.Color;

import pintoresInterface.*;
import ui.ControllerLienzo;
import ui.Lienzo;

public class PintorRaya implements IPintorProduct{
	private int grosor;
	private int xPosition;
	private int yPosition;
	private Color color;
	private int cantMovimientos;
	private Lienzo lienzo;
	private boolean estado;
	private int alto;
	private int ancho;
	private int k;
	
	public PintorRaya(int k) {
		this.k = k;
	}
	
	@Override
	public void pintar(int grosor, int xPosition, int yPosition, int ancho, int altura, Color color) {
		ControllerLienzo controller = new ControllerLienzo(lienzo);
		
		this.grosor = grosor;
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.color = color;
		this.alto = alto;
		this.ancho = ancho;
		
		controller.crearLinea( grosor,  xPosition,  yPosition,  ancho,  altura,  color);
	}
	

	@Override
	public void actualizar(boolean estado) {
		this.estado = estado;
		
	}

	@Override
	public void setMovimientos(int pmovimientos) {
		cantMovimientos = pmovimientos;
		
	}

	@Override
	public void setLienzo(Lienzo plienzo) {
		lienzo = plienzo;
		
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
