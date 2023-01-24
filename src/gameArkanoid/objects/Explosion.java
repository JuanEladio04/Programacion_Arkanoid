package gameArkanoid.objects;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import gameArkanoid.Arkanoid;


public class Explosion extends Actor {
	/**
	 * Constructor
	 */
	public Explosion(int x, int y) {
		super();
		this.x = x;
		this.y = y;
		// Carga de los sprites de la explosi�n
		List<BufferedImage> nuevosSprites = new ArrayList<BufferedImage>();
		nuevosSprites.add(ResourcesCache.getInstance().getImagen("sprite-explosion1.png"));
		nuevosSprites.add(ResourcesCache.getInstance().getImagen("sprite-explosion2.png"));
		nuevosSprites.add(ResourcesCache.getInstance().getImagen("sprite-explosion3.png"));
		nuevosSprites.add(ResourcesCache.getInstance().getImagen("sprite-explosion4.png"));
		nuevosSprites.add(ResourcesCache.getInstance().getImagen("sprite-explosion5.png"));
		nuevosSprites.add(ResourcesCache.getInstance().getImagen("sprite-explosion6.png"));
		nuevosSprites.add(ResourcesCache.getInstance().getImagen("sprite-explosion7.png"));
		nuevosSprites.add(ResourcesCache.getInstance().getImagen("sprite-explosion8.png"));
		nuevosSprites.add(ResourcesCache.getInstance().getImagen("sprite-explosion9.png"));
		this.setSpritesDeAnimacion(nuevosSprites);
		// Sprite actual
		this.spriteActual = this.getSpritesDeAnimacion().get(0);
		// Velocidad de cambio de sprite
		this.velocidadDeCambioDeSprite = 5;
	}


	/**
	 * M�todo que se llamar� para cada actor, en cada refresco de pantalla del juego
	 */
	@Override
	public void actua() {
		super.actua();
		if (this.spriteActual.equals(this.spritesDeAnimacion.get(this.spritesDeAnimacion.size()-1))) {
			Arkanoid.getInstance().eliminaActor(this);
		}
	}

}
