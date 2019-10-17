import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = 0;
	
	public GamePanel() {
		
	}
	
	public void changeMenu(Graphics g) {
		if(currentState==MENU_STATE) {
			g.setColor(Color.BLUE);
			g.drawRect(0, 0, MediocreGame.width, MediocreGame.height);
		}
	}
	
	
	public void paintComponent(Graphics g) {
		if (currentState == MENU_STATE) {

			drawMenuState(g);

		} else if (currentState == GAME_STATE) {

			drawGameState(g);

		} else if (currentState == END_STATE) {

			drawEndState(g);

		}

	}
	
	
	private void drawEndState(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.red);
		g.drawRect(0, 0, MediocreGame.width, MediocreGame.height);
	}

	private void drawGameState(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.set);
		g.drawRect(0, 0, MediocreGame.width, MediocreGame.height);
	}

	private void drawMenuState(Graphics g) {
		// TODO Auto-generated method stub
		g.drawRect(0, 0, MediocreGame.width, MediocreGame.height);
	}
	
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==10&&currentState!=GAME_STATE) {
			currentState++;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		changeMenu(e);
	}

}
