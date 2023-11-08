package figuras;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class Triangulo extends JPanel{
	private int xPosition;
	private int yPosition;
	Color color;
	
    public Triangulo(Color color, int xPosition, int yPosition) {
    	this.color = color;
    	this.xPosition = xPosition;
    	this.yPosition = yPosition;
    }
	@Override
    protected void paintComponent(Graphics g) {
		int[] xPoints = {100, xPosition, 300};
	    int[] yPoints = {yPosition, 100, 300};
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        // Dibuja el triángulo con los puntos especificados
        g2d.setColor(color);
        g2d.fillPolygon(xPoints, yPoints, 3);
        g2d.setColor(Color.BLACK);
        g2d.drawPolygon(xPoints, yPoints, 3);
    }
}
