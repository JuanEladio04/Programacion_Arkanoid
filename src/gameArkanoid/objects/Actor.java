package gameArkanoid.objects;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class Actor {
	//Propiedades
	protected int x, y; //Ubicación del actor en la pantalla
	protected int ancho = 30, alto = 30; // Lo que ocupa el actor en la pantalla
	protected BufferedImage img;// Imagen del actor
	protected int velocidadX = 0; // Velocidades en cada eje
	protected int velocidadY = 0;
	
	//Metodos
	
	/**
	 *Método constructor por defecto 
	 */
	public Actor() {
		super();
	}
	
	/**
	 * @param x
	 * @param y
	 * @param ancho
	 * @param alto
	 * @param img
	 */
	public Actor(int x, int y, BufferedImage img) {
		super();
		this.x = x;
		this.y = y;
		this.setImg(img);
	}
	
	/**
	 * 
	 * @param g
	 */
	public void paint(Graphics g) {
		g.drawImage(this.img, this.x, this.y, null);
	}

	/**
	 * 
	 */
	public abstract void actua ();

	/*
	 * 
	 */
	public void colisionaCon(Actor a) {
	}
	
	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}
	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}
	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}
	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
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
	 * @return the img
	 */
	public BufferedImage getImg() {
		return img;
	}
	/**
	 * @param img the img to set
	 */
	public void setImg(BufferedImage img) {
		this.img = img;
		this.ancho = this.img.getWidth();
		this.alto = this.img.getHeight();
	}
	
	@Override
	public String toString() {
		return "Actor [x=" + x + ", y=" + y + ", ancho=" + ancho + ", alto=" + alto + ", img=" + img + "]";
	}
	

}
