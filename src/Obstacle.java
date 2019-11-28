import java.awt.Color;
import java.awt.Graphics;

public class Obstacle extends BorderCollisions {

	public Obstacle(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
	
	public void update() {
		super.update();
		
	}
	public void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillOval(x, y, width, height);
	}

}
