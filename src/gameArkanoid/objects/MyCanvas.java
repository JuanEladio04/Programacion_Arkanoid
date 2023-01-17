package gameArkanoid.objects;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.util.List;

/*
 * Con esta clase pintaremos los diferentes objetos en la pantalla.
 */
public class MyCanvas extends Canvas{
	
	List<Actor> actores = null;
	
	private BufferStrategy stragety = null;

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
	public void paintScene() {
		//Iniciamos el objeto "stragety" una sola vez.
		if(this.stragety == null) {
			//Creamos un doble buffer de video.
			this.createBufferStrategy(2);
			stragety = getBufferStrategy();
			//Resolvemos el problema de memoria en Linux.
			Toolkit.getDefaultToolkit().sync();
		}
		
		Graphics2D g = (Graphics2D)stragety.getDrawGraphics();
		// Pinto un rectángulo negro que ocupe toda la escena
		g.setColor(Color.black);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		// Pinto cada uno de los actores
		for (Actor a : this.actores) {
			a.paint(g);
		}
			//Mostramos en pantalla en nuevo buffer.
			stragety.show();
	}
	
}
