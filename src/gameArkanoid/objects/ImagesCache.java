package gameArkanoid.objects;

import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class ImagesCache {
	
	//Propiedades
	public static String BRICK_IMAGE = "ladrillo.gif";
	public static String SHIP_IMAGE = "nave.gif";
	public static String BALL_IMAGE = "pelota.gif";



	// HashMap que actúa como almacén de imágenes
	private HashMap<String, BufferedImage> sprites = new HashMap<String, BufferedImage>();

	// Instancia Singleton
	private static ImagesCache instance= null;


	/**
	 * Getter Singleton
	 * @return
	 */
	public static ImagesCache getInstance () {
		if (instance == null) {
			instance = new ImagesCache();
		}
		return instance;
	}


	/**
	 * Este método carga un fichero de imagen del sistema de ficheros y lo devuelve
	 * como un objeto de tipo BufferedImage
	 * @param nombre
	 * @return
	 */
	private BufferedImage cargarImagen (String nombre) {
		URL url=null;
		try {
			url = getClass().getResource(nombre);
			return ImageIO.read(url);
		} catch (Exception e) { // algo ha fallado, se acaba el programa si no podemos cargar alguna imagen
			e.printStackTrace();
			System.exit(0);
		}
		return null;
	}

	/**
	 * @param nombre
	 * @return
	 */
	public BufferedImage getImagen(String nombre) {
		BufferedImage img = sprites.get(nombre);
		if (img == null) {
			img = cargarImagen("../resources/images/" + nombre);
			sprites.put(nombre,img);
		}
		return img;
	}
}
