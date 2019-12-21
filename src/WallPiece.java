import java.awt.Color;
import java.awt.Graphics;

public class WallPiece extends BorderCollisions{

	public WallPiece(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
	public void update() {
		super.update();
	}
	public void draw(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(x, y, width, height);
	}
}
