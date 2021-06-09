package GameAssets;

import java.awt.Graphics;

import java.awt.Rectangle;
import java.io.IOException;

/*
 * abstract metod definerar modelw utseende och de gemensamma metoderna.
 */
public abstract class GameModels {

	protected double x;
	protected double y;
	protected double dx;
	protected double dy;
	private int hp = 0;

	protected GameObjects objects;
	private Rectangle object1 = new Rectangle();

	private Rectangle object2 = new Rectangle();

	public GameModels(String resource, int x, int y) {

		this.objects = ObjectAssets.get().getObject(resource);

		this.x = x;
		this.y = y;
	}

	public GameModels(String resource, int x, int y, int hp) {

		this.objects = ObjectAssets.get().getObject(resource);

		this.x = x;
		this.y = y;
		this.hp = hp;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = this.hp + hp;
	}

	/*
	 * move metod , ger object en movement speed
	 * 
	 * 
	 */
	public void move(long delta) {

		x += (delta * dx) / 1000;
		y += (delta * dy) / 1000;

	}

	public int getX() {
		return (int) x;
	}

	public int getY() {
		return (int) y;
	}

	public void setHorizontalMovement(double dx) {
		this.dx = dx;
	}

	public void setVerticalMovement(double dy) {
		this.dy = dy;
	}

	public double getHorizontalMovement() {
		return dx;
	}

	public double getVerticalMovement() {
		return dy;
	}

	public void draw(Graphics g) {
		objects.draw(g, (int) x, (int) y);
	}

	public void doLogic() throws IOException {
	}
/**
 * collision detector metod
 * jämför två objects boundss
 * @param other
 * @return
 */
	public boolean collidesWith(GameModels other) {
		object1.setBounds((int) x, (int) y, objects.getWidth(), objects.getHeight());
		object2.setBounds((int) other.x, (int) other.y, other.objects.getWidth(), other.objects.getHeight());

		return object1.intersects(object2);
	}

	public abstract void collidedWith(GameModels other) throws IOException, InterruptedException;

}
