package gameArkanoid.objects;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.List;


/*
 * Con esta clase pintaremos los diferentes objetos en la pantalla.
 */
public class MyCanvas extends Canvas{
	
	List<Actor> actores = null;

	/**
	 * @param actores
	 */
	public MyCanvas(List<Actor> actores) {
		super();
		this.actores = actores;
	}
	
	/**
	 * Sobrescritura del méotod paint(), aquí tengo el control sobre aquello que se va a pintar en pantalla.
	 */
	@Override
	public void paint(Graphics g) {
		// Pinto el fondo
		this.setBackground(Color.BLACK);
		
		// Pinto cada uno de los actores
		for (Actor a : this.actores) {
			a.paint(g);
		}
	}
	
	
	
}
