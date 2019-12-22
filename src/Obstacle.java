import java.awt.Color;
import java.awt.Graphics;

public class Obstacle extends BorderCollisions {
	int angle;
	int radius;
	double centerX;
	double centerY;

	public Obstacle(int x, int y, int width, int height, int angle, int radius) {
		super(x, y, width, height);
		this.angle = angle;
		this.radius = radius;
		this.centerX = x;
		this.centerY = y;
		// TODO Auto-generated constructor stub
	}

	public void update() {
		super.update();
	}

	public void circleMove(int xplac, int yplac) {
		angle++;

		if (angle >= 360) {
			angle = 0;

		}
		double rads = Math.toRadians(angle);
		double x = Math.cos(rads) * radius;
		double y = Math.sin(rads) * radius;
		this.x = xplac + (int) (x);
		this.y = yplac + (int) (y);
	}

	public void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillOval(x, y, width, height);
	}

}
