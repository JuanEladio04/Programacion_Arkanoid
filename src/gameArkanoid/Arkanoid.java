package gameArkanoid;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Rectangle;
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
	private List<Actor> actoresParaEliminar = new ArrayList<Actor>();
	
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
	 * Meotod principal del juego
	 */
	public Arkanoid() {
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
	}	
	
	/**
	 * Método main
	 * @param args
	 */
	public static void main(String[] args) {
		Arkanoid.getInstance().game();
	}
	
	/*
	 * Metodo para inciar el juego
	 */
	public void game() {
		do {
			//Hacemos que el elemento canva tenga el focus para que podamos utilizar el teclado directamente sin necesidad de hacer click.
				if (ventana.getFocusOwner() != null && 
				!ventana.getFocusOwner().equals(canvas)) {
					canvas.requestFocus();
				}
				
			long millisAntesDeProcesarEscena = new Date().getTime();
			//Redibujamos la escena tantas veces como indique la variable fps
			canvas.paintScene();
			
			//Recorremos los diferentes antores para que cada uno de ellos actúe.
			for (Actor a : actores) {
				a.actua();
			}
			
			// Tras hacer que cada actor actúe y antes de agregar y eliminar actores, detecto colisiones
			detectaColisiones();
			
			// Acualizo los actores, eliminando los que ya no se quieren
			actualizaActores();
			
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
	
	public void eliminaActor (Actor a) {
		this.actoresParaEliminar.add(a);
	}
	
	/**
	 * Elimina los que corresponden
	 */
	private void actualizaActores () {
		// Elimino los actores que se deben eliminar
		for (Actor a : this.actoresParaEliminar) {
			this.actores.remove(a);
		}
		this.actoresParaEliminar.clear(); // Limpio la lista de actores a eliminar, ya los he eliminado
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
		actores.addAll(ladrillos);
		
		return actores;
	}
	
	//Creamos los ladrillos
	public static List<Ladrillo> creaYColocaLadrillos() {
		List<Ladrillo> bricks = new ArrayList<Ladrillo>();
		int y = 30, x = 10;
		String colors[] = new String[]{"red", "orange", "yellow", "green", "cyan", "magenta"};

		for (int i = 0; i < 6; i++) { //Bucle que crea cada fila de ladrillos
			for (int j = 0; j < 12; j++) { //con este bucle creamos cada ladrillo.
				Ladrillo brick = new Ladrillo(x, y, Ladrillo.BRICK_IMAGE, colors[i]);
				bricks.add(brick);
				x = x + 37; //Creamos un incremento que solo esté presente en cada fila.
			}
			x = 10; //Reiniciamos la x.
			y = y + 30; //Creamos un incremento para la y.
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
	
	/**
	 * Detecta colisiones entre actores e informa a los dos
	 */
	
	private  void detectaColisiones() {
		for (Actor actor1 : this.actores) {
			// Creo un rectángulo para este actor.
			Rectangle rect1 = new Rectangle(actor1.getX(), actor1.getY(), actor1.getAncho(), actor1.getAlto());
			// Compruebo un actor con cualquier otro actor
			for (Actor actor2 : this.actores) {
				// Evito comparar un actor consigo mismo, ya que eso siempre provocaría una colisión y no tiene sentido
				if (!actor1.equals(actor2)) {
					// Formo el rectángulo del actor 2
					Rectangle rect2 = new Rectangle(actor2.getX(), actor2.getY(), actor2.getAncho(), actor2.getAlto());
					// Si los dos rectángulos tienen alguna intersección, notifico una colisión en los dos actores
					if (rect1.intersects(rect2)) {
						actor1.colisionaCon(actor2); // El actor 1 colisiona con el actor 2
						actor2.colisionaCon(actor1); // El actor 2 colisiona con el actor 1
					}
				}
			}
		}
	}
	
}
