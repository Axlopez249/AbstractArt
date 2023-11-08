package pintores;

import java.awt.Color;

import ui.Lienzo;

public class Main {
	public static void main(String[] args) {
		int cantidadPintores = 3;
		int cantidadMovimientos = 1;

		int x = 900;
		int y = 500;
		Lienzo panel = new Lienzo(x , y);
		
		//panel.AgregarPunto( Color.BLUE, 10, 10, 10, 10, 10);
		//panel.AgregarTriangulo(400, 600, 200, 100, 10, Color.BLUE);
		//panel.AgregarLinea(50, Color.black, 300, 700, 120, 43);
		//panel.AgregarCuadrado(98, Color.BLACK, 100, 89);
		panel.setVisible(true);
        Hilo miRunnable = new Hilo(cantidadPintores, cantidadMovimientos, panel);
        Thread miHilo = new Thread(miRunnable);
        miHilo.start(); // Inicia el hilo
    }
}
