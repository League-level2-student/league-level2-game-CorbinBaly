import java.awt.Rectangle;

public class BorderCollisions {
int x;
int y;
int width;
int height;
boolean isAlive = true;
Rectangle collisionBox = new Rectangle();
public BorderCollisions(int x, int y, int width, int height) {
	this.x = x;
	this.y = y;
	this.width = width;
	this.height = height;
}
public void update(){
	collisionBox.setBounds(x, y, width, height);
}

public int getX() {
	return x;
}
public void setX(int x) {
	this.x = x;
}
public int getY() {
	return y;
}
public void setY(int y) {
	this.y = y;
}


}


