package GameAssets;
/*
 * class för att läsa in gif-filer
 * 
 * 
 */

import java.awt.GraphicsConfiguration;

import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class ObjectAssets {

	private static ObjectAssets single = new ObjectAssets();

	public static ObjectAssets get() {
		return single;
	}

	private HashMap<String, GameObjects> gameObjects = new HashMap<String, GameObjects>();
/*
 * 
 * metod för att läsa vår gif filer, som kanske är överflödig för att våra gif inte gör nåt, men det fanns en tanke. och det är smidigare än att behandla pngs.
 */
	public GameObjects getObject(String resource) {

		if (gameObjects.get(resource) != null) {

			return (GameObjects) gameObjects.get(resource);
		}

		BufferedImage sourceImage = null;

		try {
			URL url = this.getClass().getClassLoader().getResource(resource);

			if (url == null) {
				System.out.println("Can't find ref: " + resource);
			}

			sourceImage = ImageIO.read(url);
		} catch (IOException e) {
			System.out.println("Failed to load: " + resource);
		}

		GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice()
				.getDefaultConfiguration();
		Image image = gc.createCompatibleImage(sourceImage.getWidth(), sourceImage.getHeight(), Transparency.BITMASK);

		image.getGraphics().drawImage(sourceImage, 0, 0, null);

		GameObjects gameObject = new GameObjects(image);
		gameObjects.put(resource, gameObject);

		return gameObject;

	}

}
