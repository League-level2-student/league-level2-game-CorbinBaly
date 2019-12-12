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
				player.isAlive = false;
				System.out.println(player.isAlive);
			}
		}
	}

	void draw(Graphics g) {
		player.draw(g);
		for (int i = 0; i < obstacles.size(); i++) {
			obstacles.get(i).draw(g);
		}
	}

	public void update() {
		player.update();
		for (int i = 0; i < obstacles.size(); i++) {
			obstacles.get(i).update();
		}
	}

	public void addObstacle(Obstacle obstacle) {
		obstacles.add(obstacle);

	}
}
