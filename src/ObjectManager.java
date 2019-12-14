import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class ObjectManager {
	int i;

	ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();
	Player player;

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

	public void update(int x, int y) {
		player.update();
		for (int i = 0; i < obstacles.size(); i++) {
			obstacles.get(i).update(x, y);
		}
	}

	public void addObstacle(Obstacle obstacle) {
		obstacles.add(obstacle);

	}
}
