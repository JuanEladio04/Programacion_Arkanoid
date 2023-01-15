package gameArkanoid;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import gameArkanoid.objects.Actor;
import gameArkanoid.objects.Ladrillo;
import gameArkanoid.objects.MyCanvas;
import gameArkanoid.objects.Nave;
import gameArkanoid.objects.Pelota;

public class Arkanoid {
	private static int FPS = 60;
	private static JFrame ventana = null;
	private static int millisPorCadaFrame = 1000 / FPS; // Creamos una variable para calcular los millis por cada frame
	private static Nave player = null;
	private static List<Actor> actores = creaActores(); //Creamos los actores
	private static MyCanvas canvas = new MyCanvas(actores); //Creamos un objeto mi canvas para poder pintar nuestros actores en el juego
	private static Arkanoid instance = null;

	/**
	 * Método main
	 * @param args
	 */
	public static void main(String[] args) {
		ventana = new JFrame("Arkanoid"); //Creamos la ventana.
		ventana.setBounds(0, 0, 475, 700); //Damos los valores a la ventana.
		ventana.getContentPane().setLayout(new BorderLayout()); // Asignamos un layout a la ventana para poder colocar objetos encima.
		
		canvas.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				super.mouseMoved(e);
				player.mover(e.getX(), e.getY());
			}			
		});
		
		// Desvío los eventos de teclado hasta el jugador
		canvas.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				super.keyPressed(e);
				player.keyPressed(e);
			}

			@Override
			public void keyReleased(KeyEvent e) {
				super.keyReleased(e);
				player.keyReleased(e);
			}
		});
		
		ventana.getContentPane().add(canvas, BorderLayout.CENTER);
		//Hacemos que Windows no redibuje la ventana para poder hacerlo nosotros
		ventana.setIgnoreRepaint(true);
		//Hacemos que la ventana sea visible
		ventana.setVisible(true);
		//Comenzamos con el juego
		// Control del evento de cierre de ventana
		ventana.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		ventana.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				cerrarAplicacion();
				}
			});
		//Iniciamos el juego
		game();
	}	
	
	/*
	 * Necesario para el Singletone
	 */
	public static Arkanoid getInstance () {
		if (instance == null) { // Si no está inicializada, se inicializa
			instance = new Arkanoid();
		}
		return instance;
	}
	
	/*
	 * Metodo para inciar el juego
	 */
	public static void game() {
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
		player = new Nave(260, 500, Nave.SHIP_IMAGE);
		actores.add(player);
		//Añadimos la pelota
		Pelota ball = new Pelota(200, player.getY() - 50, Pelota.BALL_IMAGE);
		actores.add(ball);
		
		//Luego creamos los diferentes ladrillos del juego
		List<Ladrillo> ladrillos = creaYColocaLadrillos();
		for (Ladrillo brick : ladrillos) {
			actores.add(brick);
		}
		
		return actores;
	}
	
	//Creamos los ladrillos
	public static List<Ladrillo> creaYColocaLadrillos() {
		List<Ladrillo> bricks = new ArrayList<Ladrillo>();
		int y = 10, x = 10;

		for(int  i = 0, j = 0; i < 72; i++, j++) {
			if(j == 12) { //Creamos un if que haga que cada 12 bloques bajemos una posición
				y = bricks.get(i - 1).getY() + bricks.get(i - 1).getAlto();
				x = 10; //Devolvemos la x a su posición inicial
				j = 0;
			}
			else { //En caso de la que sea el primer ladrillo no aplicaremos el incremento a la x.
				if ( i != 0) x = ((bricks.get(i - 1).getX()) + bricks.get(i - 1).getAncho()) + 7;
			}

			if(i == 0) { //Configuramos el primer ladrillo
				Ladrillo brick = new Ladrillo(x, y, Ladrillo.BRICK_IMAGE);
				bricks.add(brick);
			}
			else { // Configuramos el resto de ladrillos
				Ladrillo brick = new Ladrillo(x, y, Ladrillo.BRICK_IMAGE);
				bricks.add(brick);
			}
			//Damos color a los ladrillos
		}
		return bricks;
	}
	
	/**
	 * Al cerrar la aplicación preguntaremos al usuario si está seguro de que desea salir.
	 */
	private static void cerrarAplicacion() {
		String [] opciones ={"Aceptar","Cancelar"};
		int eleccion = JOptionPane.showOptionDialog(ventana,"¿Desea cerrar la aplicación?","Salir de la aplicación",
		JOptionPane.YES_NO_OPTION,
		JOptionPane.QUESTION_MESSAGE, null, opciones, "Aceptar");
		if (eleccion == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
	
	/**
	 * @return the canvas
	 */
	public MyCanvas getCanvas() {
		return canvas;
	}

}
