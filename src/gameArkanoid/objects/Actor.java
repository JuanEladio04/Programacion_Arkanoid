package gameArkanoid.objects;

import java.awt.Graphics;

public abstract class Actor {
	//Propiedades
	protected int x, y; //Ubicación del actor en la pantalla
	protected int ancho = 30, alto = 30; // Lo que ocupa el actor en la pantalla
	protected String img; // Imagen del actor
	
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
	public Actor(int x, int y, String img) {
		super();
		this.x = x;
		this.y = y;
		this.img = img;
	}
	
	/**
	 * 
	 * @param g
	 */
	public abstract void paint(Graphics g); 

	/**
	 * 
	 */
	public abstract void actua ();

	
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
	public String getImg() {
		return img;
	}
	/**
	 * @param img the img to set
	 */
	public void setImg(String img) {
		this.img = img;
	}
	
	@Override
	public String toString() {
		return "Actor [x=" + x + ", y=" + y + ", ancho=" + ancho + ", alto=" + alto + ", img=" + img + "]";
	}
	
	

	
}
