package DrawGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Circle {

	int x, y, thickness;
	Color color;
	
	public void paint(Graphics g) {
		g.setColor(color);
		g.fillOval(x - (thickness/2), y - (thickness/2), thickness, thickness);
	}
	
	public Circle(int x, int y, int thickness, Color color) {
		this.x = x;
		this.y = y;
		this.thickness = thickness;
		this.color = color;
	}
	
	public Rectangle collision() {
		return new Rectangle(x, y, thickness, thickness);
	}
	
}
