import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class ObjectManager {
	int i;

	ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();
	Player player;
	WallPiece wallpieces;

	public ObjectManager(Player player) {
		this.player = player;
	}

	void checkCollision() {
		for (Obstacle a : obstacles) {
			if (player.collisionBox.intersects(a.collisionBox)) {
				obstacles.get(i).isAlive = false;
				player.isAlive = false;
				GamePanel.playerDeaths++;
			}
		}
	}

	void draw(Graphics g) {
		player.draw(g);

		for (int i = 0; i < obstacles.size(); i++) {
			obstacles.get(i).draw(g);
		}

	}

	void drawWalls(Graphics g, int x, int y, int z, int xx) {
		wallpieces = new WallPiece(x, y, z, xx);
		wallpieces.draw(g);
	}

	public void update() {
		player.update();
		for (int i = 0; i < obstacles.size(); i++) {
			obstacles.get(i).update();

		}
	}

	public void finalCircles(int x, int y) {
		for (int i = 0; i < obstacles.size(); i++) {
			obstacles.get(i).circleMove(x, y);
		}
	}

	public void addObstacle(Obstacle obstacle) {
		obstacles.add(obstacle);

	}
}
