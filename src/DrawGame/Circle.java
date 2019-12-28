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
	
	public void drawBetween(Circle a, Circle b, Graphics g) {
		double dX = (double)a.x - b.x;
		double dY = (double)a.y - b.y;
		double slope = (a.y - b.y)/(a.x - b.x);
				
		while(!(a.x == b.x) && !(a.y == b.y)) {
			if(dX < 0 && dY > 0) {
				//g.fillOval(a.x + pX, dY, width, height);
			}
		}
		
	}
	
	public Rectangle collision() {
		return new Rectangle(x, y, thickness, thickness);
	}
	
}
