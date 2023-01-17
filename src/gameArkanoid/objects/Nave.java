package gameArkanoid.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import gameArkanoid.Arkanoid;

public class Nave extends Actor {
	//Propiedades del objeto
	public static String SHIP_IMAGE = "ship.png";
	// Propiedades que indican si se está produciendo un movimiento en una dirección
	private boolean izquierda = false, derecha = false;
	// Velocidad de la nave, expresada en píxeles por cada frame
	public static int VELOCIDAD = 8;

	//Métodos del objeto

	/**
	 * Esto nos servira para pintar el jugador en la escena y determinar su comportamiento.
	 */
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.CYAN);
		g.fillRect(this.x, this.y, this.ancho, this.alto);
	}

	@Override
	public void actua() {
		// Compruebo las variables booleanas que determinan el movimiento
		if (izquierda) this.x -= VELOCIDAD;
		if (derecha) this.x += VELOCIDAD;

		// Compruebo si el player sale del canvas por cualquiera de los cuatro márgenes
		mover(this.x, this.y);
	}
	
	public void mover(int x, int y) {
		this.x = x;
		// Controlo los casos en los que el jugador pueda salir del Canvas
		MyCanvas canvas = Arkanoid.getInstance().getCanvas(); // Referencia al objeto Canvas usado

		// Compruebo si el ratón sale por la derecha
		if (this.x > (canvas.getWidth() - this.ancho)) {
			this.x = canvas.getWidth() - this.ancho;
		}
			
		// Compruebo si el jugador sale por la derecha
		if (this.x > (canvas.getWidth() - this.ancho)) {
			this.x = canvas.getWidth() - this.ancho;
		}

		// Compruebo si el jugador sale por la izquierda
		if (this.x < 0) {
			this.x = 0;
		}

		// Compruebo si el jugador sale por abajo
		if (this.y > (canvas.getHeight() - this.alto)) {
			this.y = canvas.getHeight() - this.alto;
		}

		// Compruebo si el jugador sale por arriba
		if (this.y < 0) {
			this.y = 0;
		}
	}


	/**
	 * Se ejecuta al recibir un evento del teclado: tecla presionada
	 * @param e
	 */
	public void keyPressed (KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			izquierda = true; break;
		case KeyEvent.VK_RIGHT:
			derecha = true; break;
		}
	}
	
	/**
	 * Se ejecuta al recibir un evento del teclado: tecla liberada
	 * @param e
	 */
	public void keyReleased (KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
			izquierda = false; break;
		case KeyEvent.VK_RIGHT:
			derecha = false; break;
		}
	}
	
	/**
	 * Constructor por defecto "default constructor"
	 */
	public Nave() {
		super();
	}

	/**
	 * Constructor que inicializa las propiedades del objeto
	 * @param x
	 * @param y
	 * @param img
	 */
	public Nave(int x, int y, String img) {
		super(x, y, img);
		alto = 20;
		ancho = 80;
	}

	/**
	 * Obtención de un String con todos los datos de un objeto Nave
	 */
	public String toString() {
		return "Nave [getX()=" + getX() + ", getY()=" + getY() + ", getImg()=" + getImg() + "]";
	}

}
