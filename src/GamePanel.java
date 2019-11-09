import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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

	public GamePanel() {
		timer = new Timer(1000 / 60, this);
		timer.start();
		titleFont = new Font("Arial", Font.PLAIN, 48);
		enterFont = new Font("Arial", Font.PLAIN, 36);
		instructionFont = new Font("Arial", Font.PLAIN, 26);
	}

	@Override
	public void paintComponent(Graphics g) {
		if (currentState == 0) {

			drawMenuState(g);

		} else if (currentState == 1) {

			drawGameState(g);

		} else if (currentState == 2) {

			drawEndState(g);

		}

	}

	void updateGame() {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
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
		g.drawString("Press SPACE for instructions", 300, 450);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == 10) {
			if (currentState == END_STATE) {
				currentState = 0;
			} else if (e.getKeyCode() == 10 && currentState != 2) {
				currentState++;
				System.out.println("clicked");
			}
	
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
