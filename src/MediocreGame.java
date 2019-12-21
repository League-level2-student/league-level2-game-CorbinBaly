import java.awt.Dimension;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MediocreGame {
	final static int width = 900;
	final static int height = 650;
	JFrame frame;
	GamePanel panel;

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
		frame.getContentPane().setPreferredSize(new Dimension(width, height));
		frame.pack();

	}

	public static void main(String[] args) {
		MediocreGame runner = new MediocreGame();
		runner.setup();
	}
}
