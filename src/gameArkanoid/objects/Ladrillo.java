package gameArkanoid.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Arrays;

import gameArkanoid.Arkanoid;

public class Ladrillo extends Actor {
	//Propiedades del objeto
	public String color;
	
	//Metodos del objeto

	@Override
	public void paint(Graphics g) {
//		alto = 20;
//		ancho = 30;
//		
//		if (color == "red") {
//			g.setColor(Color.RED);
//			g.fillRect(this.x, this.y, ancho, alto);	
//		}
//		if (color == "orange") {
//			g.setColor(Color.ORANGE);
//			g.fillRect(this.x, this.y, ancho, alto);	
//		}
//		if (color == "yellow") {
//			g.setColor(Color.YELLOW);
//			g.fillRect(this.x, this.y, ancho, alto);
//		}
//		if (color == "green") {
//			g.setColor(Color.GREEN);
//			g.fillRect(this.x, this.y, ancho, alto);	
//		}
//		if (color == "cyan") {
//			g.setColor(Color.CYAN);
//			g.fillRect(this.x, this.y, ancho, alto);	
//		}
//		if (color == "magenta") {
//			g.setColor(Color.MAGENTA);
//			g.fillRect(this.x, this.y, ancho, alto);	
//		}
		g.drawImage(this.img, this.x, this.y, null);
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
		}
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
	public Ladrillo(int x, int y) {
		super(x, y, ImagesCache.getInstance().getImagen(ImagesCache.BRICK_IMAGE));
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
		return "Ladrillo [x=" + x + ", y=" + y + ", ancho=" + ancho + ", alto=" + alto + ", img=" + img
				+ ", velocidadX=" + velocidadX + ", velocidadY=" + velocidadY + ", getX()=" + getX() + ", getY()="
				+ getY() + ", getAncho()=" + getAncho() + ", getAlto()=" + getAlto() + ", getImg()=" + getImg()
				+ ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ "]";
	}

	
}
