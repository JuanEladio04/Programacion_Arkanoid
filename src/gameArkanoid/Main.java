package gameArkanoid;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import gameArkanoid.objects.Actor;
import gameArkanoid.objects.Ladrillo;
import gameArkanoid.objects.MyCanvas;
import gameArkanoid.objects.Nave;
import gameArkanoid.objects.Pelota;

public class Main {
	private static int FPS = 60;

	/**
	 * Método main
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame ventana = new JFrame("Arkanoid"); //Creamos la ventana.
		int millisPorCadaFrame = 1000 / FPS; // Creamos una variable para calcular los millis por cada frame
		List<Actor> actores = creaActores(); //Creamos los actores
		MyCanvas canvas = new MyCanvas(actores); //Creamos un objeto mi canvas para poder pintar nuestros actores en el juego

		ventana.setBounds(0, 0, 475, 700); //Damos los valores a la ventana.
		ventana.getContentPane().setLayout(new BorderLayout()); // Asignamos un layout a la ventana para poder colocar objetos encima.
		ventana.getContentPane().add(canvas, BorderLayout.CENTER);
		//Hacemos que Windows no redibuje la ventana para poder hacerlo nosotros
		ventana.setIgnoreRepaint(true);
		//Hacemos que la ventana sea visible
		ventana.setVisible(true);
		
		//Comenzamos con el juego
		do {
			long millisAntesDeProcesarEscena = new Date().getTime();
			//Redibujamos la escena tantas veces como indique la variable fps
			canvas.repaint();
			
			//Recorremos los diferentes antores para que cada uno de ellos actúe.
			for (Actor a : actores) {
				a.actua();
			}
			
			// Calculo los millis que debemos parar el proceso.
			long millisDespuesDeProcesarEscena = new Date().getTime();
			int millisDeProcesamientoDeEscena = (int) (millisDespuesDeProcesarEscena - millisAntesDeProcesarEscena);
			int millisPausa = millisPorCadaFrame - millisDeProcesamientoDeEscena;
			millisPausa = (millisPausa < 0)? 0 : millisPausa;
			// Dormimos el proceso principal durante los milllis calculados.
			try {
				Thread.sleep(millisPausa);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		} while (true);
	}
	
	
	public static List<Actor> creaActores() { //Método para crear los diferentes actores.
		List<Actor> actores = new ArrayList<Actor>();
		
		//Primero debemos añadir al jugador a la lista.
		Nave nave = new Nave(300, 300, Nave.SHIP_IMAGE);
		actores.add(nave);
		//Añadimos la pelota
		Pelota ball = new Pelota(200, 200, Pelota.BALL_IMAGE);
		actores.add(ball);
		
		//Luego creamos los diferentes ladrillos del juego
		List<Ladrillo> ladrillos = new ArrayList<Ladrillo>();
		for(Ladrillo ladrillo : ladrillos) {
			ladrillo = new Ladrillo(100, 100, Ladrillo.BRICK_IMAGE);
			actores.add(ladrillo);
		}
		
		return actores;
	}

}
