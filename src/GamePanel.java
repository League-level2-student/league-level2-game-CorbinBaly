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

	static int playerDeaths = 0;
	Player player = new Player(40, 40, 30, 30);
	ObjectManager objectmanager;
	int level = 0;
	int coins = 0;
	int endpointX;
	int endpointY;
	// X and Y's for obstacle placements
	int xOne;
	int yOne;
	int xTwo;
	int yTwo;
	int xThree;
	int yThree;

	public GamePanel() {
		timer = new Timer(1000 / 60, this);
		timer.start();
		titleFont = new Font("Arial", Font.PLAIN, 48);
		enterFont = new Font("Arial", Font.PLAIN, 36);
		instructionFont = new Font("Arial", Font.PLAIN, 26);
		objectmanager = new ObjectManager(player);
		
		
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
		createObstaclesThree(xThree, yThree, 0);
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
			// End Point
			endpointX = 705;
			endpointY = 290;
			g.setColor(Color.GREEN);
			g.fillRect(endpointX+10, endpointY+10, 60, 60);
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
			endpointX = 705;
			endpointY = 290;
			g.setColor(Color.GREEN);
			g.fillRect(endpointX, endpointY, 70, 70);
			objectmanager.draw(g);
		}
	}

	public void leveltwoValues() {
		
		xOne = 175;
		yOne = 200;
		xTwo = 170;
		yTwo = 340;
		xThree = 160;
		yThree = 400;
		createObstaclesOne(xOne, yOne, 25);
		createObstaclesTwo(xTwo, yTwo, 35);
		createObstaclesThree(xThree, yThree, 50);
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
			objectmanager.addObstacle(new Obstacle(x, y - (i * objectsize), objectsize, objectsize, 270, i * objectsize));
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

	public void updateGameState() {
		objectmanager.rotateAll(xOne, yOne, xTwo, yTwo, xThree, yThree);
		objectmanager.update();
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
		// level up
		if (player.x >= endpointX && endpointY <= player.y) {
			level++;
			currentState = MENU_STATE;
			objectmanager.sendBack = true;
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
		g.drawString("- Avoid the moving red objects", 225, 575);
		g.drawString("- Collect the gold coins around the map", 225, 635);
		g.drawString("- Reach the green tile to the side", 225, 695);
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
		objectmanager.createWalls();
		if (level == 0) {
			leveloneGraphics(g);
		}
		// level 2
		else if (level == 1) {
			leveltwoGraphics(g);
			
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
		//clearing walls
		objectmanager.removeStuff();
		if (level == 0) {
			leveloneValues();
		}
		else if (level == 1) {
			leveltwoValues();
		}
	}

	// Action Performed/Refreshing game
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
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
