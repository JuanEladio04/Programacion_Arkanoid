package gameArkanoid.objects;

import java.util.Arrays;

public class Ladrillo {
	//Propiedades del objeto
	
	private int x, y, ancho, alto, puntosVida;
	private static String COLOR[] = new String [] {"RED", "GREEN", "BLUE"}; 

	//Metodos del objeto
	
	/**
	 * Método constructor por defecto
	 */
	public Ladrillo() {
		super();
	}

	/**
	 * @param x
	 * @param y
	 * @param ancho
	 * @param alto
	 * @param puntosVida
	 * @param COLOR
	 */
	public Ladrillo(int x, int y, int ancho, int alto, int puntosVida, String[] COLOR) {
		super();
		this.x = x;
		this.y = y;
		this.ancho = ancho;
		this.alto = alto;
		this.puntosVida = puntosVida;
		this.COLOR = COLOR;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}

	public int getPuntosVida() {
		return puntosVida;
	}

	public void setPuntosVida(int puntosVida) {
		this.puntosVida = puntosVida;
	}

	public String[] getCOLOR() {
		return COLOR;
	}

	public void setCOLOR(String[] COLOR) {
		this.COLOR = COLOR;
	}

	@Override
	public String toString() {
		return "Ladrillo [x=" + x + ", y=" + y + ", ancho=" + ancho + ", alto=" + alto + ", puntosVida=" + puntosVida
				+ ", COLOR=" + Arrays.toString(COLOR) + "]";
	}
	
	
	
}
