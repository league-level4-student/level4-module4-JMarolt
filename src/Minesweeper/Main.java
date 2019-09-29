package Minesweeper;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {
	final static int width = 700;
	final static int height = 700;
	final int totalBlocks = 1225;
	private JFrame f;
	private JPanel j;
	
	public Main() {
		f = new JFrame();
		f.setTitle("'_'");
		f.setResizable(false);
		j = new JPanel() {
		
		public void paintComponent(Graphics g) {
			
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, width, height);
			
			g.setColor(Color.BLACK);
			for(int i = 0; i < height; i+=20) {
				g.drawLine(i, 0, i, height);
			}
			for(int k = 0; k < width; k+=20) {
				g.drawLine(0, k, width, k);
			}
		}
	
		};
		f.setPreferredSize(new Dimension(width, height));
		f.add(j);
		
		f.pack();
		f.setVisible(true);
		
	}
	
	public void setBlocks() {
		int temp = 0;
		ArrayList<Block> blocks = new ArrayList<Block>();
		for(int i = 0; i < totalBlocks; i++) {
			blocks.add(new Block(i * 20, temp));
			if(i * 20 >= 720) {
				
			}
		}
	}
	
	public static void main(String[] args) {
		new Main();
	}
	
}
