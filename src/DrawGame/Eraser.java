package DrawGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Eraser {
	
	int x, y, thickness;

	public Eraser(int x, int y, int thickness) {
		this.x = x;
		this.y = y;
		this.thickness = thickness;
	}
	
	public void draw(Graphics g) {
		for (int i = 0; i < Main.width - Main.sidePanel; i++) {
			for (int k = 0; k < Main.height; k++) {
				if (Main.mouseX >= i && Main.mouseX < i + 1) {
					if (Main.mouseY >= k && Main.mouseY < k + 1) {
						g.setColor(Main.eraserColor);
						g.fillOval(i - (Main.thickness / 2), k - (Main.thickness / 2), Main.thickness + Main.radius, Main.thickness + Main.radius);
					}
				}
			}
		}
	}
	
	public Rectangle collision() {
		return new Rectangle(x, y, thickness, thickness);
	}
	
}
