package ui;

import java.awt.Color;

public class ControllerLienzo {
	private Lienzo lienzo;
	
	public ControllerLienzo(Lienzo lienzo) {
		this.lienzo = lienzo;
	}
	
	public void crearTriangulo(int grosor, int xPosition, int yPosition, int ancho, int alto, Color color) {
		lienzo.AgregarTriangulo(xPosition, yPosition, alto, ancho, grosor, color);
	}
	public void crearCuadrado(int grosor, int xPosition, int yPosition, int ancho, int alto, Color color) {
		lienzo.AgregarCuadrado(alto, color, xPosition, yPosition);
	}
	public void crearLinea(int grosor, int xPosition, int yPosition, int ancho, int altura, Color color) {
		lienzo.AgregarLinea(grosor, color, xPosition, yPosition, altura, ancho);
	}
	public void crearPunto(int grosor, int xPosition, int yPosition, int ancho, int alto, Color color) {
		lienzo.AgregarPunto(color, grosor, xPosition, yPosition, alto, ancho);
	}
}
