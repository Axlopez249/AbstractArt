package pintoresInterface;

import java.awt.Color;

import ui.Lienzo;

public interface IPintorProduct {
	void pintar(int grosor, int xPosition, int yPosition, int ancho, int altura, Color color);
	void setMovimientos(int pmovimientos);
	void setLienzo(Lienzo plienzo);
	void actualizar(boolean estado);
	void actualizarMovimientos();
	Color getColor();
	int getGrosor();
	int getAncho();
	int getAlto();
	int getX();
	int getY();
	int getMovimientos();
	
}
