package gameArkanoid.objects;

import java.awt.Color;
import java.awt.Graphics;

public class Pelota extends Actor{
	//Propiedades del objeto

	private int alto, ancho, velX, velY;
	public static String BALL_IMAGE = "ball.img";

	@Override
	public void paint(Graphics g) {
		g.setColor(Color.RED);
		g.fillOval(this.x, this.y, this.ancho, this.alto);		
	}

	@Override
	public void actua() {
		//Configuramos el movimiento horizontal.
		this.x += velX;
		//Añadimos colisiones a las paredes
		if (this.x < 0 || this.x < 475) {
			this.velX = - this.velX;
		}
		
		//Configuramos el movimiento horizontal.
		this.y += velY;
		//Añadimos colisiones a las paredes
		if (this.y < 0 || this.y < 750) {
			this.velY = - this.velY;
		}
		
	}

	/**
	 * Constructor por defecto
	 */
	public Pelota() {
		super();
	}

	/**
	 * @param alto
	 * @param ancho
	 */
	public Pelota(int x, int y, String img) {
		super(x, y, img);

	}

	/**
	 * @return the alto
	 */
	public int getAlto() {
		return alto;
	}

	/**
	 * @param alto the alto to set
	 */
	public void setAlto(int alto) {
		this.alto = alto;
	}

	/**
	 * @return the ancho
	 */
	public int getAncho() {
		return ancho;
	}

	/**
	 * @param ancho the ancho to set
	 */
	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	@Override
	public String toString() {
		return "Pelota [alto=" + alto + ", ancho=" + ancho + "]";
	}
	
}
