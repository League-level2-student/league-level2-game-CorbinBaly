import java.awt.Color;
import java.awt.Graphics;

public class Player extends BorderCollisions {
	String direcOne = "none";
	String direcTwo = "none";
	int PlayerX;
	int PlayerY;
	public Player(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	public void draw(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(x, y, width, height);
		
	}


	public void update() {
		super.update();
		// left
		if (direcOne.equalsIgnoreCase("left")) {
			x -= (5);
		}
		// right
		else if (direcOne.equalsIgnoreCase("right")) {
			x += (5);
		}

		// forward
		if (direcTwo.equalsIgnoreCase("forward")) {
			y -= (5);
		}
		// back
		else if (direcTwo.equalsIgnoreCase("back")) {
			y += (5);
		}

	}
}
