import java.awt.Color;
import java.awt.Graphics;

public class Player extends BorderCollisions {
	String direction = "right";

	public Player(int x, int y, int width, int height) {
		super(x, y, width, height);

	}

	public void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(x, y, width, height);
	}

	public void update() {

		// left
		if (direction.equalsIgnoreCase("left")) {
			x -= (10);
		}
		// right
		else if (direction.equalsIgnoreCase("right")) {
			x += (10);
		}
		// forward
		else if (direction.equalsIgnoreCase("forward")) {
			y -= (10);
		}
		// back
		else if (direction.equalsIgnoreCase("back")) {
			y += (10);
		}
	}
}
