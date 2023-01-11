package gameArkanoid.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Arrays;

public class Ladrillo extends Actor {
	//Propiedades del objeto
	private int alto, ancho;
	public static String BRICK_IMAGE = "brik.png";
	
	//Metodos del objeto

	@Override
	public void paint(Graphics g) {
		g.setColor(Color.YELLOW);
		g.fillRect(this.x, this.y, this.ancho, this.alto);		
	}

	@Override
	public void actua() {
		
	}

	/**
	 * Constructor por defecto
	 */
	public Ladrillo() {
		super();
	}

	/*
	 * Constructor avanzado
	 */
	public Ladrillo(int x, int y, String BRICK_IMAGE) {
		super(x, y, BRICK_IMAGE);

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

	/**
	 * @return the BRICK_IMAGE
	 */
	public static String getBRICK_IMAGE() {
		return BRICK_IMAGE;
	}

	/**
	 * @param BRICK_IMAGE the BRICK_IMAGE to set
	 */
	public static void setBRICK_IMAGE(String BRICK_IMAGE) {
		BRICK_IMAGE = BRICK_IMAGE;
	}

	@Override
	public String toString() {
		return "Ladrillo [alto=" + alto + ", ancho=" + ancho + "]";
	}
	
}
