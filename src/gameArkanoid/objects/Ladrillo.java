package gameArkanoid.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Arrays;

import gameArkanoid.Arkanoid;

public class Ladrillo extends Actor {
	//Propiedades del objeto
	public String color;
	
	//Metodos del objeto

	/**
	 * Constructor por defecto
	 */
	public Ladrillo() {
		super();
	}

	/*
	 * Constructor avanzado
	 */
	public Ladrillo(int x, int y) {
		super(x, y);
		this.setSpriteActual(ResourcesCache.getInstance().getImagen(ResourcesCache.BRICK_IMAGE));
	}
	
	@Override
	public void paint(Graphics g) {
		alto = 20;
		ancho = 30;
		g.drawImage(this.spriteActual, this.x, this.y, null);
	}
	
	/**
	 * Este método elimina el ladrillo una vez la pelota colisiona con el.
	 */
	@Override
	public void colisionaCon(Actor a) {
		super.colisionaCon(a);
		// Si colisionamos con un player o un disparo, eliminamos al monstruo
		if (a instanceof Pelota || a instanceof Ladrillo) {
			Arkanoid.getInstance().eliminaActor(this);
			ResourcesCache.getInstance().playSonido("explosion.wav");
			Arkanoid.getInstance().incorporaNuevoActor(new Explosion(this.x, this.y));
		}
	}

	@Override
	public void actua() {
		super.actua();
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Ladrillo [color=" + color + "]";
	}
	
}
