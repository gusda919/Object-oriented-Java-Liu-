package GameAssets;

/*
 * klass som ritar ut objekten.
 */
import java.awt.Graphics;

import java.awt.Image;

public class GameObjects {

	private Image image;

	public GameObjects(Image image) {
		this.image = image;

	}

	public int getWidth() {
		return image.getWidth(null);
	}

	public int getHeight() {
		return image.getHeight(null);
	}

	public void draw(Graphics g, int x, int y) {
		g.drawImage(image, x, y, null);
	}

}
