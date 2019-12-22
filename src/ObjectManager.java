import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class ObjectManager {
	int i;

	ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();
	ArrayList<Obstacle> obstaclesTwo = new ArrayList<Obstacle>();
	ArrayList<Obstacle> obstaclesThree = new ArrayList<Obstacle>();
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
		for (Obstacle b : obstaclesTwo) {
			if (player.collisionBox.intersects(b.collisionBox)) {
				obstacles.get(i).isAlive = false;
				player.isAlive = false;
				GamePanel.playerDeaths++;
			}
		}
		for (Obstacle c : obstaclesThree) {
			if (player.collisionBox.intersects(c.collisionBox)) {
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

	void drawWalls(Graphics g, int x, int y, int width, int height) {
		wallpieces = new WallPiece(x, y, width, height);
		wallpieces.draw(g);
	}

	public void update() {
		player.update();
		for (int i = 0; i < obstacles.size(); i++) {
			obstacles.get(i).update();
		}

	}

	public void rotateOne(int x, int y) {
		for (int i = 0; i < obstacles.size(); i++) {
			obstacles.get(i).circleMove(x, y);
		}
		for (int i = 0; i < obstacles.size(); i++) {
			obstaclesTwo.get(i).circleMove(x, y);
		}
		for (int i = 0; i < obstacles.size(); i++) {
			obstaclesThree.get(i).circleMove(x, y);
		}
	}

	public void rotateTwo(int x, int y) {
		for (int i = 0; i < obstacles.size(); i++) {
			obstacles.get(i).circleMove(x, y);
		}
		for (int i = 0; i < obstacles.size(); i++) {
			obstaclesTwo.get(i).circleMove(x, y);
		}
		for (int i = 0; i < obstacles.size(); i++) {
			obstaclesThree.get(i).circleMove(x, y);
		}
	}

	public void rotateThree(int x, int y) {
		for (int i = 0; i < obstacles.size(); i++) {
			obstacles.get(i).circleMove(x, y);
		}
		for (int i = 0; i < obstacles.size(); i++) {
			obstaclesTwo.get(i).circleMove(x, y);
		}
		for (int i = 0; i < obstacles.size(); i++) {
			obstaclesThree.get(i).circleMove(x, y);
		}
	}

	public void addObstacle(Obstacle obstacle) {
		obstacles.add(obstacle);

	}

	public void addObstacleTwo(Obstacle obstacle) {
		obstaclesTwo.add(obstacle);

	}

	public void addObstacleThree(Obstacle obstacle) {
		obstaclesThree.add(obstacle);

	}
}
