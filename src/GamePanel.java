import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Iterator;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer timer;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = 0;
	Font titleFont;
	Font enterFont;
	Font instructionFont;
	Boolean instructionsShowing = false;
	int playerX = 250;
	int playerY = 750;
	Player player = new Player(playerX, playerY, 30, 30);
	ObjectManager objectmanager;

	public GamePanel() {
		timer = new Timer(1000 / 60, this);
		timer.start();
		titleFont = new Font("Arial", Font.PLAIN, 48);
		enterFont = new Font("Arial", Font.PLAIN, 36);
		instructionFont = new Font("Arial", Font.PLAIN, 26);
		objectmanager = new ObjectManager(player);
		levelOne();
	}

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

		}

	}

	public void updateGameState() {
		objectmanager.update();

	}

//// Levels
	public void levelOne() {
		// create obstacles
		createObstacles(400, 300);

	}

	public void leveltwo() {

	}

	public void levelthree() {

	}
//// levelOne methods

	public void createObstacles(int x, int y) {
		// top
		for (int i = 0; i < 10; i++) {
			objectmanager.addObstacle(new Obstacle(x, y + (i * 20), 20, 20, 0, i * 20));
		}
		// bottom
		for (int i = 0; i < 10; i++) {
			objectmanager.addObstacle(new Obstacle(x, y - (i * 20), 20, 20, 180, i * 20));
		}
		// left
		for (int i = 0; i < 10; i++) {
			objectmanager.addObstacle(new Obstacle(x - (i * 20), y, 20, 20, 270, i * 20));
		}
		// right
		for (int i = 0; i < 10; i++) {
			objectmanager.addObstacle(new Obstacle(x + (i * 20), y, 20, 20, 90, i * 20));
		}
	}

//// Draw
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
		g.setColor(Color.red);
		g.fillRect(0, 0, MediocreGame.width, MediocreGame.height);
	}

	private void drawGameState(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, MediocreGame.width, MediocreGame.height);
		objectmanager.draw(g);
	}

	private void drawMenuState(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, MediocreGame.width, MediocreGame.height);
		g.setColor(Color.BLUE);
		g.setFont(titleFont);
		g.drawString("The World's Most Mediocre Game", 100, 200);
		g.setFont(enterFont);
		g.drawString("Press ENTER to start", 300, 300);
		g.setFont(instructionFont);
		g.drawString("Press SPACE for instructions", 305, 450);
		// draw instructions

	}

//// Action Performed
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
		updateGameState();
	}

//// Key used
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
			} else if (e.getKeyCode() == 10 && currentState != 2) {
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
