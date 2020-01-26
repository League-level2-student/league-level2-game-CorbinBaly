import java.awt.Dimension;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MediocreGame {
	static int width = 900;
	static int height = 650;
	public static JFrame frame;
	static GamePanel panel;

	public MediocreGame() {
		frame = new JFrame();
		panel = new GamePanel();
		frame.add(panel);
	}
	
	public void setup() {
		frame.setVisible(true);
		frame.add(panel);
		frame.addKeyListener(panel);
		frame.setDefaultCloseOperation(3);
		frame.pack();
	}
	public static void changeSize(int newWidth, int newHeight) {
		width = newWidth;
		height = newHeight;
		//panel.setPreferredSize(new Dimension(MediocreGame.width, MediocreGame.height));
		frame.setPreferredSize(new Dimension(MediocreGame.width, MediocreGame.height));
		//panel.setSize(new Dimension(MediocreGame.width, MediocreGame.height));
		frame.pack();
	}

	public static void main(String[] args) {
		MediocreGame runner = new MediocreGame();
		runner.setup();
	}
}
