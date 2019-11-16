import java.awt.Color;
import java.awt.Graphics;

public class Player extends GameObject{
String direction = "";
	public Player(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
public void draw(Graphics g) {
g.setColor(Color.RED);
g.fillRect(x, y, width, height);
}
	void update() {
		super.update();
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
