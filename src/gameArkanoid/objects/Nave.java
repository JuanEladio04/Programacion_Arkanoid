package gameArkanoid.objects;

import java.awt.Color;
import java.awt.Graphics;

public class Nave extends Actor {
	//Propiedades del objeto
	public static String SHIP_IMAGE = "ship.png";

	//Métodos del objeto

	/**
	 * Esto nos servira para pintar el jugador en la escena y determinar su comportamiento.
	 */
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(this.x, this.y, this.ancho, this.alto);
	}

	@Override
	public void actua() {
		
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
	}

	/**
	 * Obtención de un String con todos los datos de un objeto Nave
	 */
	public String toString() {
		return "Nave [getX()=" + getX() + ", getY()=" + getY() + ", getImg()=" + getImg() + "]";
	}

}
