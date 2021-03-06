import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer timer;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	static int currentState = 0;
	Font titleFont;
	Font enterFont;
	Font instructionFont;
	Boolean instructionsShowing = false;
	int endPointX = 700;
	int endPointY = 300;
	EndPoint endpoint = new EndPoint(endPointX, endPointY, 75, 75);
	static int playerDeaths = 0;
	Player player = new Player(40, 40, 30, 30);
	ObjectManager objectmanager;
	static int level =0;
	// X and Y's for obstacle placements
	int xOne;
	int yOne;
	int xTwo;
	int yTwo;
	int xThree;
	int yThree;
	int xFour;
	int yFour;

	public GamePanel() {
		timer = new Timer(1000 / 60, this);
		timer.start();
		titleFont = new Font("Arial", Font.PLAIN, 48);
		enterFont = new Font("Arial", Font.PLAIN, 36);
		instructionFont = new Font("Arial", Font.PLAIN, 26);
		objectmanager = new ObjectManager(player, endpoint);
	}

	//////////////
	// Game State chooser
	@Override
	public void paintComponent(Graphics g) {

		if (currentState == 0) {
			drawMenuState(g);
			if (instructionsShowing == true) {
				drawInstructions(g);
			}
		} else if (currentState == 1) {

			drawGameState(g);

		} else if (currentState == 2) {

			drawEndState(g);
			player.isAlive = true;
		}

	}

	//////////////
	//// Levels

	// level 1
	public void leveloneValues() {
		// create obstacles
		
		xOne = 300;
		yOne = 200;
		xTwo = 400;
		yTwo = 250;
		xThree = 600;
		yThree = 225;
		createObstaclesOne(xOne, yOne, 50);
		createObstaclesTwo(xTwo, yTwo, 50);
		createObstaclesThree(xThree, yThree, 50);
		
	}

	public void leveloneGraphics(Graphics g) {
		if (level == 0 && player.isAlive && GAME_STATE == currentState) {
			MediocreGame.changeSize(800, 400);
			// background color
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, MediocreGame.width, MediocreGame.height);
			// Safe Zone
			g.setColor(Color.GREEN);
			g.fillRect(40, 40, 75, 75);
			objectmanager.createWalls();
			objectmanager.draw(g);
			
		}
	}

	// level 2

	public void leveltwoGraphics(Graphics g) {
		if (level == 1 && player.isAlive && GAME_STATE == currentState) {
			MediocreGame.changeSize(300, 600);
			// background color
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, MediocreGame.width, MediocreGame.height);
			// Safe Zone
			g.setColor(Color.GREEN);
			g.fillRect(40, 40, 75, 75);
			// End Point
			endPointY = 400;
			endPointX = 100;
			objectmanager.draw(g);
			objectmanager.createWalls();
		}
	}

	public void leveltwoValues() {
		
		xOne = 175;
		yOne = 200;
		xTwo = 170;
		yTwo = 340;
		xThree = 130;
		yThree = 400;
		createObstaclesOne(xOne, yOne, 25);
		createObstaclesTwo(xTwo, yTwo, 35);
		createObstaclesThree(xThree, yThree, 50);
	}

	public void levelthreeGraphics(Graphics g) {
		if (level == 2 && player.isAlive && GAME_STATE == currentState) {
			MediocreGame.changeSize(700, 300);
			// background color
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, MediocreGame.width, MediocreGame.height);
			// Safe Zone
			g.setColor(Color.GREEN);
			g.fillRect(40, 40, 75, 75);
			// End Point
			endPointY = 50;
			endPointX = 600;
			objectmanager.draw(g);
			objectmanager.createWalls();
		}
	}

	public void levelthreeValues() {
		
		xOne = 250;
		yOne = 300;
		xTwo = 450;
		yTwo = 0;
		xThree = 625;
		yThree = 300;
		xFour = 700;
		yFour = 50;
		createObstaclesOne(xOne, yOne, 50);
		createObstaclesTwo(xTwo, yTwo, 45);
		createObstaclesThree(xThree, yThree, 50);
		createObstaclesFour(xFour, yFour, 30);
		
	}

	public void levelfourGraphics(Graphics g) {
		if (level == 3 && player.isAlive && GAME_STATE == currentState) {
			MediocreGame.changeSize(500, 500);
			// background color
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, MediocreGame.width, MediocreGame.height);
			// Safe Zone
			g.setColor(Color.GREEN);
			g.fillRect(40, 40, 75, 75);
			// End Point
			endPointY = 380;
			endPointX = 25;
			objectmanager.draw(g);
			objectmanager.createWalls();
		}
	}

	public void levelfourValues() {
		
		xOne = 100;
		yOne = 300;
		xTwo = 300;
		yTwo = 100;
		xThree = 280;
		yThree = 375;
		xFour = 400;
		yFour = 300;
		createObstaclesOne(xOne, yOne, 42);
		createObstaclesTwo(xTwo, yTwo, 40);
		createObstaclesThree(xThree, yThree, 33);
		createObstaclesFour(xFour, yFour, 30);
	
	}
	
	public void levelfiveGraphics(Graphics g) {
		if (level == 4 && player.isAlive && GAME_STATE == currentState) {
			MediocreGame.changeSize(300, 700);
			// background color
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, MediocreGame.width, MediocreGame.height);
			// Safe Zone
			g.setColor(Color.GREEN);
			g.fillRect(40, 40, 75, 75);
			// End Point
			endPointY = 600;
			endPointX = 200;
			objectmanager.createWalls();
			objectmanager.draw(g);
			
		}
	}

	public void levelfiveValues() {

		xOne = 300;
		yOne = 100;
		
		xTwo = 25;
		yTwo = 250;
		
		xThree = 300;
		yThree = 400;
		
		xFour = 25;
		yFour = 550;
		createObstaclesOne(xOne, yOne, 45);
		createObstaclesTwo(xTwo, yTwo, 40);
		createObstaclesThree(xThree, yThree, 50);
		createObstaclesFour(xFour, yFour, 48);
		
	}
	//////////////
	//// Game Object Methods

	public void createObstaclesOne(int x, int y, int size) {
		int objectsize = size / 2;
		// top
		for (int i = 0; i < 10; i++) {
			objectmanager.addObstacle(new Obstacle(x + (i * objectsize), y, objectsize, objectsize, 0, i * objectsize));
		}
		// bottom
		for (int i = 0; i < 10; i++) {
			objectmanager
					.addObstacle(new Obstacle(x - (i * objectsize), y, objectsize, objectsize, 180, i * objectsize));
		}
		// left
		for (int i = 0; i < 10; i++) {
			objectmanager
					.addObstacle(new Obstacle(x, y - (i * objectsize), objectsize, objectsize, 270, i * objectsize));
		}
		// right
		for (int i = 0; i < 10; i++) {
			objectmanager
					.addObstacle(new Obstacle(x, y + (i * objectsize), objectsize, objectsize, 90, i * objectsize));
		}

	}

	public void createObstaclesTwo(int x, int y, int size) {
		int objectsize = size / 2;
		// top
		for (int i = 0; i < 10; i++) {
			objectmanager
					.addObstacleTwo(new Obstacle(x + (i * objectsize), y, objectsize, objectsize, 0, i * objectsize));
		}
		// bottom
		for (int i = 0; i < 10; i++) {
			objectmanager
					.addObstacleTwo(new Obstacle(x - (i * objectsize), y, objectsize, objectsize, 180, i * objectsize));
		}
		// left
		for (int i = 0; i < 10; i++) {
			objectmanager
					.addObstacleTwo(new Obstacle(x, y - (i * objectsize), objectsize, objectsize, 270, i * objectsize));
		}
		// right
		for (int i = 0; i < 10; i++) {
			objectmanager
					.addObstacleTwo(new Obstacle(x, y + (i * objectsize), objectsize, objectsize, 90, i * objectsize));
		}
	}

	public void createObstaclesThree(int x, int y, int size) {
		int objectsize = size / 2;
		// top
		for (int i = 0; i < 10; i++) {
			objectmanager
					.addObstacleThree(new Obstacle(x + (i * objectsize), y, objectsize, objectsize, 0, i * objectsize));
		}
		// bottom
		for (int i = 0; i < 10; i++) {
			objectmanager.addObstacleThree(
					new Obstacle(x - (i * objectsize), y, objectsize, objectsize, 180, i * objectsize));
		}
		// left
		for (int i = 0; i < 10; i++) {
			objectmanager.addObstacleThree(
					new Obstacle(x, y - (i * objectsize), objectsize, objectsize, 270, i * objectsize));
		}
		// right
		for (int i = 0; i < 10; i++) {
			objectmanager.addObstacleThree(
					new Obstacle(x, y + (i * objectsize), objectsize, objectsize, 90, i * objectsize));
		}
	}

	public void createObstaclesFour(int x, int y, int size) {
		int objectsize = size / 2;
		// top
		for (int i = 0; i < 10; i++) {
			objectmanager
					.addObstacleFour(new Obstacle(x + (i * objectsize), y, objectsize, objectsize, 0, i * objectsize));
		}
		// bottom
		for (int i = 0; i < 10; i++) {
			objectmanager.addObstacleFour(
					new Obstacle(x - (i * objectsize), y, objectsize, objectsize, 180, i * objectsize));
		}
		// left
		for (int i = 0; i < 10; i++) {
			objectmanager.addObstacleFour(
					new Obstacle(x, y - (i * objectsize), objectsize, objectsize, 270, i * objectsize));
		}
		// right
		for (int i = 0; i < 10; i++) {
			objectmanager
					.addObstacleFour(new Obstacle(x, y + (i * objectsize), objectsize, objectsize, 90, i * objectsize));
		}
	}

	public void updateGameState() {
		objectmanager.rotateAll(xOne, yOne, xTwo, yTwo, xThree, yThree, xFour, yFour);
		objectmanager.update(endPointX, endPointY);
		objectmanager.checkCollision();
		if (player.isAlive == false) {
			currentState = 2;
			player.setX(40);
			player.setY(40);
		}
		if (objectmanager.sendBack) {
			player.setX(40);
			player.setY(40);
			objectmanager.sendBack = false;
		}

	}

	//////////////
	//// Draw
	// drawing states
	private void drawInstructions(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		g.fillRect(225, 500, 500, 250);
		g.setColor(Color.YELLOW);
		g.setFont(instructionFont);
		g.drawString("- Move around using the arrow keys.", 225, 525);
		g.drawString("- Avoid the moving blue objects", 225, 575);
		g.drawString("- Reach the green tile to the side", 225, 635);
	}

	private void drawEndState(Graphics g) {
		// TODO Auto-generated method stub
		MediocreGame.changeSize(700, 450);
		g.setColor(Color.red);
		g.fillRect(0, 0, MediocreGame.width, MediocreGame.height);
		g.setColor(Color.WHITE);
		g.setFont(titleFont);
		g.drawString("You Ded", 20, 175);
		g.setFont(enterFont);
		g.drawString("Press ENTER to try again", 150, 250);
		g.setFont(instructionFont);
		g.drawString("Deaths: " + playerDeaths, 175, 300);
	}

	private void drawGameState(Graphics g) {
		// Drawing Game Things
		// TODO Auto-generated method stub
		// level 1
		if (level == 0) {
			leveloneGraphics(g);
			
		}
		// level 2
		else if (level == 1) {
			leveltwoGraphics(g);
			

		} else if (level == 2) {
			levelthreeGraphics(g);
			

		} else if (level == 3) {
			levelfourGraphics(g);
			

		} else if (level == 4) {
			levelfiveGraphics(g);
			
		}

	}

	private void drawMenuState(Graphics g) {
		// TODO Auto-generated method stub
		MediocreGame.changeSize(900, 750);
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, MediocreGame.width, MediocreGame.height);
		g.setColor(Color.BLUE);
		g.setFont(titleFont);
		g.drawString("The World's Most Mediocre Game", 100, 200);
		g.setFont(enterFont);
		g.drawString("Press ENTER to start", 300, 300);
		g.setFont(instructionFont);
		g.drawString("Press SPACE for instructions", 305, 450);
		// clearing stuff
		objectmanager.removeStuff();
		if (level == 0) {
			leveloneValues();
		} else if (level == 1) {
			leveltwoValues();
		} else if (level == 2) {
			levelthreeValues();
		} else if (level == 3) {
			levelfourValues();
		} else if (level == 4) {
			levelfiveValues();
		}
	}

	// Action Performed/Refreshing game
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
		System.out.println(ObjectManager.obstacles.size()+ObjectManager.obstaclesTwo.size()+ObjectManager.obstaclesThree.size()+ObjectManager.obstaclesFour.size()+ObjectManager.wallpieces.size());
		if (currentState == GAME_STATE) {
			updateGameState();
		}
	}

	// Key used
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println(player.direcOne);
		System.out.println(player.direcTwo);
		// TODO Auto-generated method stub
		if (e.getKeyCode() == 10) {
			if (currentState == END_STATE) {
				currentState = 0;
			} else if (e.getKeyCode() == 10 && currentState == MENU_STATE) {
				currentState++;
				System.out.println("clicked");
			}

		}
		// Turn instructions on
		if (e.getKeyCode() == 32 && currentState == MENU_STATE && instructionsShowing == false) {
			instructionsShowing = true;
			System.out.println("true");
		}
		// turn instructions off
		else if (e.getKeyCode() == 32 && currentState == MENU_STATE && instructionsShowing == true) {
			instructionsShowing = false;
			System.out.println("False");
		}
		// DIRECTIONS

		// left
		if (e.getKeyCode() == 37) {
			System.out.println(player.direcOne);
			player.direcOne = "left";
		}
		// right
		else if (e.getKeyCode() == 39) {
			player.direcOne = "right";
		}

		// back
		if (e.getKeyCode() == 40) {
			player.direcTwo = "back";
		}
		// forward
		else if (e.getKeyCode() == 38) {
			player.direcTwo = "forward";
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == 37 || e.getKeyCode() == 39) {
			player.direcOne = "";
		}
		if (e.getKeyCode() == 38 || e.getKeyCode() == 40) {
			player.direcTwo = "";
		}
	}

}
