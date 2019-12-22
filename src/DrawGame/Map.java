package DrawGame;

import java.awt.Color;
import java.awt.Graphics;

public class Map {
	public void draw(Graphics g) {
		g.setColor(new Color(220,220,220));
		g.fillRect(0, 0, Main.width, Main.height);
		
		g.setColor(Color.black);
		g.drawLine(Main.width - Main.sidePanel, 0, Main.width - Main.sidePanel, Main.height);
		
		for(int i = 0; i < Main.width - Main.sidePanel; i++) {
			for(int k = 0; k < Main.height; k++) {
				if(Main.mouseX >= i && Main.mouseX < i + 1) {
					if(Main.mouseY >= k && Main.mouseY < k + 1) {
						g.setColor(Main.currentColor);
						g.fillOval(i - (Main.thickness/2), k - (Main.thickness/2), Main.thickness, Main.thickness);
					}
				}
			}
		}
		
		
		
	}
	
}
