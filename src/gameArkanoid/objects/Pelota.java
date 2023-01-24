package gameArkanoid.objects;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JOptionPane;

import gameArkanoid.Arkanoid;

public class Pelota extends Actor{
	//Propiedades del objeto

	private int alto, ancho;
	

	/**
	 * Constructor por defecto
	 */
	public Pelota() {
		super();
	}

	/**
	 * Costructor avanzado
	 * @param ancho 
	 * @param alto
	 * @param ancho
	 * @param alto 
	 */
	public Pelota(int x, int y) {
		super(x, y);
		this.ancho = 10;
		this.alto = 10;
		this.velocidadX = -5;
		this.velocidadY = -5;
		this.setSpriteActual(ResourcesCache.getInstance().getImagen(ResourcesCache.BALL_IMAGE));
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(this.spriteActual, this.x, this.y, null);
	}

	@Override
	public void actua() {
		super.actua();
		//Configuramos el movimiento horizontal.
		this.x += this.velocidadX;
		//Añadimos colisiones a las paredes
		if (this.x < 0 || (this.x + this.ancho) > Arkanoid.getInstance().getCanvas().getWidth()) {
			this.velocidadX = - this.velocidadX;
		}
		
		//Configuramos el movimiento horizontal.
		this.y += this.velocidadY;
		//Añadimos colisiones a las paredes
		if (this.y < 0) {
			this.velocidadY = - this.velocidadY;
		}
		
		// Si el disparo se pierde por el borde inferior, elimino el actor del juego
		if ((this.y + this.alto) > Arkanoid.getInstance().getCanvas().getHeight()) {
			Arkanoid.getInstance().eliminaActor(this);
			JOptionPane.showMessageDialog(null, "¡Has perdido!");
			System.exit(0);
			
		}
		
	}
	
	/*
	 * Rebota al colisionar
	 */
	public void colisionaCon(Actor a) {
		super.colisionaCon(a);
		// Si colisionamos con monstruo, eliminamos el disparo
		if (a instanceof Ladrillo || a instanceof Nave) {
			this.velocidadY = - this.velocidadY;
		}
		this.y += this.velocidadY;
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
