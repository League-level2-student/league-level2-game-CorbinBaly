import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class ObjectManager {
	ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();
	Player player;

	public ObjectManager(Player player) {
		this.player = player;
	}

	public void Draw(Graphics g) {
		player.draw(g);
		
	}

	public void Update(Graphics g) {
		player.update();
	}
	public void addObstacle(Obstacle thisobstacle) {
		obstacles.add(thisobstacle);
		
	}
}
