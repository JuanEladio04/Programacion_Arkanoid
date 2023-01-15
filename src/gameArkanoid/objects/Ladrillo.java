package gameArkanoid.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Arrays;

public class Ladrillo extends Actor {
	//Propiedades del objeto
	public static String BRICK_IMAGE = "brick.png";
	public static Color colors;
	
	//Metodos del objeto

	@Override
	public void paint(Graphics g) {
		alto = 20;
		ancho = 30;
		g.setColor(colors);
		g.fillRect(this.x, this.y, ancho, alto);		
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
		super(x, y , BRICK_IMAGE);

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

	/**
	 * @return the color
	 */
	public static Color getColor() {
		return colors;
	}

	/**
	 * @param color the color to set
	 */
	public static void setColor(Color color) {
		Ladrillo.colors = color;
	}

	@Override
	public String toString() {
		return "Ladrillo [x=" + x + ", y=" + y + ", ancho=" + ancho + ", alto=" + alto + ", img=" + img + ", getX()="
				+ getX() + ", getY()=" + getY() + ", getAncho()=" + getAncho() + ", getAlto()=" + getAlto()
				+ ", getImg()=" + getImg() + ", toString()=" + super.toString() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}
	
}
