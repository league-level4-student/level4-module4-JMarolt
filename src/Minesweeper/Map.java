package Minesweeper;

import java.awt.Color;
import java.awt.Graphics;

public class Map {
	public void draw(Graphics g) {
		g.setColor(new Color(220,220,220));
		g.fillRect(0, 0, Main.width, Main.height);
		
		g.setColor(Color.BLACK);
		for(int i = 0; i < Main.height; i+=20) {
			g.drawLine(i, 0, i, Main.height);
		}
		for(int k = 0; k < Main.width; k+=20) {
			g.drawLine(0, k, Main.width, k);
		}
		
		for(int i = 0; i < Main.width; i+=20) {
			for(int k = 0; k < Main.height; k+=20) {
				if(Main.mouseX >= i && Main.mouseX <= i + 20) {
					if(Main.mouseY >= k && Main.mouseY <= k + 20) {
						g.setColor(new Color(0,0,0,50));
						g.fillRect(i, k, 20, 20);
					}
				}
			}
		}
	}
}
