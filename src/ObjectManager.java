import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class ObjectManager {
	int i;

	ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();
	ArrayList<Obstacle> obstaclesTwo = new ArrayList<Obstacle>();
	ArrayList<Obstacle> obstaclesThree = new ArrayList<Obstacle>();
	ArrayList<WallPiece> wallpieces = new ArrayList<WallPiece>();
	Player player;

	public ObjectManager(Player player) {
		this.player = player;
	}

	// Iterating through all obstacles and collisions to see if they collide.
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
				obstaclesTwo.get(i).isAlive = false;
				player.isAlive = false;
				GamePanel.playerDeaths++;
			}
		}
		for (Obstacle c : obstaclesThree) {
			if (player.collisionBox.intersects(c.collisionBox)) {
				obstaclesThree.get(i).isAlive = false;
				player.isAlive = false;
				GamePanel.playerDeaths++;
			}
		
		}
		for (WallPiece d : wallpieces) {
	
		}
	}

	void createWalls() {
		// top bar
		addWall(new WallPiece(0, 0, MediocreGame.width, 25));
		// bottom bar
		addWall(new WallPiece(0, MediocreGame.height - 25, MediocreGame.width, 25));
		// left bar
		addWall(new WallPiece(0, 25, 25, MediocreGame.height));
		// right bar
		addWall(new WallPiece(MediocreGame.width - 25, 25, 25, MediocreGame.height));
	}

	void draw(Graphics g) {
		player.draw(g);

		for (int i = 0; i < obstacles.size(); i++) {
			obstacles.get(i).draw(g);
		}
		for (int i = 0; i < obstacles.size(); i++) {
			obstaclesTwo.get(i).draw(g);
		}
		for (int i = 0; i < obstacles.size(); i++) {
			obstaclesThree.get(i).draw(g);
		}
		for (int i = 0; i < wallpieces.size(); i++) {
			wallpieces.get(i).draw(g);
		}
	}

	// Drawing walls
	void addWall(WallPiece wallpiece) {
		wallpieces.add(wallpiece);
	}

	public void update() {
		player.update();
		for (int i = 0; i < obstacles.size(); i++) {
			obstacles.get(i).update();
		}
		for (int i = 0; i < obstaclesTwo.size(); i++) {
			obstaclesTwo.get(i).update();
		}
		for (int i = 0; i < obstaclesThree.size(); i++) {
			obstaclesThree.get(i).update();
		}
		for (int i = 0; i < wallpieces.size(); i++) {
			wallpieces.get(i).update();
		}

	}

	public void rotateAll(int firstx, int firsty, int secondx, int secondy, int thirdx, int thirdy) {
		for (int i = 0; i < obstacles.size(); i++) {
			obstacles.get(i).circleMove(firstx, firsty);
		}
		for (int i = 0; i < obstacles.size(); i++) {
			obstaclesTwo.get(i).circleMove(secondx, secondy);
		}
		for (int i = 0; i < obstacles.size(); i++) {
			obstaclesThree.get(i).circleMove(thirdx, thirdy);
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
