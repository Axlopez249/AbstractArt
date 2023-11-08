package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import figuras.Cuadrado;
import figuras.Linea;
import figuras.Punto;
import figuras.Triangulo;

public class Lienzo extends JFrame{
	
	
	
	
	
	public Lienzo(int tamanox, int tamanoy) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 1200);
        setLocationRelativeTo(null); // Centra la ventana en la pantalla
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);

	}
	
	public void AgregarTriangulo(int x, int y, int alto, int ancho, int grosor, Color color) {
		Triangulo triangulo = new Triangulo(color, x, y);
        triangulo.setBounds(x, y, alto, ancho);
        triangulo.setVisible(true);
        triangulo.repaint();
        add(triangulo);
    }
	
	public void AgregarCuadrado(int lado, Color color, int x, int y) {
		
		Cuadrado cuadrado = new Cuadrado(lado, color);
        cuadrado.setBounds(x, y, lado, lado); // Establece las coordenadas y el tamaño del cuadrado
        add(cuadrado); // Agrega el cuadrado al lienzo
        repaint(); // Vuelve a dibujar el lienzo para mostrar el cuadrado
    }
	
	public void AgregarPunto(Color color, int radio, int x, int y, int alto, int ancho) {
		Punto punto = new Punto(radio, color);
        punto.setRadio(radio); // Establece el radio del círculo
        punto.setBounds(x, y, alto, ancho);
        add(punto);
        repaint(); // Vuelve a dibujar el círculo en el lienzo
    }
	
	public void AgregarLinea(int grosor, Color color, int x, int y, int alto, int ancho) {
		Linea linea = new Linea(x, y, x+200, y+200, color, grosor); // Grosor de la línea es 5
	    linea.setBounds(x, y, alto, ancho);
	    linea.setVisible(true);
	    add(linea);
	}
	


}
