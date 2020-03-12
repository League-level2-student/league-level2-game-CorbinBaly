import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import javax.swing.JOptionPane;

public class ObjectManager {
	int i;

	static ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();
	static ArrayList<Obstacle> obstaclesTwo = new ArrayList<Obstacle>();
	static ArrayList<Obstacle> obstaclesThree = new ArrayList<Obstacle>();
	static ArrayList<Obstacle> obstaclesFour = new ArrayList<Obstacle>();
	static ArrayList<WallPiece> wallpieces = new ArrayList<WallPiece>();

	Player player;
	boolean sendBack = false;
	EndPoint endpoint;

	public ObjectManager(Player player, EndPoint endpoint) {
		this.player = player;
		this.endpoint = endpoint;
	}

	// Iterating through all obstacles and collisions to see if they collide.
	void checkCollision() {
		if (player.collisionBox.intersects(endpoint.collisionBox)) {
			// else if(GamePanel.level == 0 && GamePanel.playerDeaths)
			GamePanel.level++;
			sendBack = true;
			GamePanel.currentState = 0;
			System.out.println("level up");
			if (GamePanel.level == 1) {
				JOptionPane.showMessageDialog(null, "Yeah that one was easy, let's see the next one.");
				Player.direcOne = "none";
				Player.direcTwo = "none";
			}
			if (GamePanel.level == 2) {
				JOptionPane.showMessageDialog(null, "Even better, but still a bit too easy. ");
				Player.direcOne = "none";
				Player.direcTwo = "none";
			}
			if (GamePanel.level == 3) {
				JOptionPane.showMessageDialog(null, "Wow, you're getting pretty good!");
				Player.direcOne = "none";
				Player.direcTwo = "none";
			}
			if (GamePanel.level == 4) {
				JOptionPane.showMessageDialog(null,
						"Oh my god you did it. It took me like over 80 tries to get this one. I'm so proud of  you.");
				JOptionPane.showMessageDialog(null,
						"That's the end. That's it. It's time for you to go outside. Get out of the house. Have fun.");
				Player.direcOne = "none";
				Player.direcTwo = "none";
			}

		}
		for (Obstacle a : obstacles) {
			if (player.collisionBox.intersects(a.collisionBox)) {
				obstacles.get(i).isAlive = false;
				player.isAlive = false;
				GamePanel.playerDeaths++;
				System.out.println("Killed player= 1");
				return;
			}
		}
		for (Obstacle b : obstaclesTwo) {
			if (player.collisionBox.intersects(b.collisionBox)) {
				obstaclesTwo.get(i).isAlive = false;
				player.isAlive = false;
				GamePanel.playerDeaths++;
				System.out.println("Killed player= 2");
				return;
			}
		}
		for (Obstacle c : obstaclesThree) {
			if (player.collisionBox.intersects(c.collisionBox)) {
				obstaclesThree.get(i).isAlive = false;
				player.isAlive = false;
				System.out.println("Killed player =3");
				GamePanel.playerDeaths++;
				return;
			}

		}
		for (Obstacle d : obstaclesFour) {
			if (player.collisionBox.intersects(d.collisionBox)) {
				obstaclesThree.get(i).isAlive = false;
				player.isAlive = false;
				System.out.println("Killed player =3");
				GamePanel.playerDeaths++;
				return;
			}

		}
		for (WallPiece d : wallpieces) {
			if (player.collisionBox.intersects(d.collisionBox)) {
				wallpieces.get(i).isAlive = false;
				sendBack = true;
				return;
			}
		}

	}

	void createWalls() {
		wallpieces.clear();
		// top bar
		addWall(new WallPiece(0, 0, MediocreGame.width, 25));
		// bottom bar
		addWall(new WallPiece(0, MediocreGame.height - 45, MediocreGame.width, 25));
		// left bar
		addWall(new WallPiece(0, 25, 25, MediocreGame.height));
		// right bar
		addWall(new WallPiece(MediocreGame.width - 25, 25, 50, MediocreGame.height));
		
	
	}

	void draw(Graphics g) {
		
		player.draw(g);
		endpoint.draw(g);
		for (int i = 0; i < obstacles.size(); i++) {
			obstacles.get(i).draw(g);
		}
		for (int i = 0; i < obstaclesTwo.size(); i++) {
			obstaclesTwo.get(i).draw(g);
		}
		for (int i = 0; i < obstaclesThree.size(); i++) {
			obstaclesThree.get(i).draw(g);
		}
		for (int i = 0; i < obstaclesFour.size(); i++) {
			obstaclesFour.get(i).draw(g);
		}
		for (int i = 0; i < wallpieces.size(); i++) {
			wallpieces.get(i).draw(g);
		}
		

	}

	void removeStuff() {
		wallpieces.clear();
		obstacles.clear();
		obstaclesTwo.clear();
		obstaclesThree.clear();
		obstaclesFour.clear();
	}

	// Drawing walls
	void addWall(WallPiece wallpiece) {
		wallpieces.add(wallpiece);
	}

	public void update(int x, int y) {
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
		for (int i = 0; i < obstaclesFour.size(); i++) {
			obstaclesFour.get(i).update();
		}
		endpoint.update(x, y);
	}

	public void rotateAll(int firstx, int firsty, int secondx, int secondy, int thirdx, int thirdy, int fourx,
			int foury) {
		for (int i = 0; i < obstacles.size(); i++) {
			obstacles.get(i).circleMove(firstx, firsty);
		}
		for (int i = 0; i < obstaclesTwo.size(); i++) {
			obstaclesTwo.get(i).circleMove(secondx, secondy);
		}
		for (int i = 0; i < obstaclesThree.size(); i++) {
			obstaclesThree.get(i).circleMove(thirdx, thirdy);
		}
		for (int i = 0; i < obstaclesFour.size(); i++) {
			obstaclesFour.get(i).circleMove(fourx, foury);
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

	public void addObstacleFour(Obstacle obstacle) {
		obstaclesFour.add(obstacle);

	}
}
