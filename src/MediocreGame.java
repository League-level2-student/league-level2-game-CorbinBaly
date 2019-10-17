import java.awt.Dimension;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MediocreGame {
	final static int width = 500;
	final static int height = 800;
	JFrame frame;
	GamePanel panel;

	public MediocreGame() {
		frame = new JFrame();
		panel = new GamePanel();

	}

	public void setup() {
		frame.setVisible(true);
		frame.add(panel);
		frame.addKeyListener(panel);
		frame.setDefaultCloseOperation(3);
		frame.getContentPane().setPreferredSize(new Dimension(width, height));
		frame.pack();
	}

}
