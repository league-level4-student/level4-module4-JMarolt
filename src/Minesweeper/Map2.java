package Minesweeper;

import java.awt.Color;
import java.awt.Graphics;

public class Map2 {
	public void draw(Graphics g) {
		g.setColor(new Color(220,220,220));
		g.fillRect(0, 0, Main2.width, Main2.height);
		
		g.setColor(Color.BLACK);
		for(int i = 0; i < Main2.height; i+=20) {
			g.drawLine(i, 0, i, Main2.height);
		}
		for(int k = 0; k < Main2.width; k+=20) {
			g.drawLine(0, k, Main2.width, k);
		}
		
		for(int i = 0; i < Main2.width; i+=20) {
			for(int k = 0; k < Main2.height; k+=20) {
				if(Main2.mouseX >= i && Main2.mouseX < i + 20) {
					if(Main2.mouseY >= k && Main2.mouseY < k + 20) {
						g.setColor(new Color(0,0,0,50));
						g.fillRect(i, k, 20, 20);
					}
				}
			}
		}
	}
}
