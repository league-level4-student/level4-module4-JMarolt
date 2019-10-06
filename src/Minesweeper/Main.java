package Minesweeper;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Main implements MouseMotionListener, MouseListener, ActionListener{
	final static int width = 520;
	final static int height = 520;
	final int totalBlocks = 1225;
	public int amountOfBombs = 245;
	private JFrame f;
	private JPanel j;
	Map map = new Map();
	Block[][] blocks;
	public static int mouseX;
	public static int mouseY;
	public int mili = (int) System.currentTimeMillis();
	public int totalTimeTaken = mili%1000;
	Timer timer;
	
	public Main() {
		f = new JFrame();
		f.setTitle("'_'");
		f.setResizable(false);
		blocks = new Block[width/20][height/20];
		j = new JPanel() {
		
		public void paintComponent(Graphics g) {
			
			map.draw(g);
			
		}
	
		};
		f.addMouseMotionListener(this);
		f.addMouseListener(this);
		timer = new Timer(0, this);
		f.setPreferredSize(new Dimension(width, height));
		f.add(j);
		
		f.pack();
		f.setVisible(true);
		setBlocks();
		timer.start();
		
	}
	
	public void setBlocks() {
		for(int i = 0; i < width; i+= 20) {
			for(int k = 0; k < height; k+=20) {
				int next = (int) (Math.random()*5);
				if(next == 0) {
					//blocks[i][k].setState(State.BOMB);
				}else {
					//blocks[i][k].setState(State.NULL);
				}		
				//blocks[i][k].setX(i);
				//blocks[i][k].setY(k);
			}
		}
	}
	
	public int getNeighbors(int x, int y) {
		return 0;
	}
	
	public static void main(String[] args) {
		new Main();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mouseX = (int) MouseInfo.getPointerInfo().getLocation().getX();
		mouseY = (int) MouseInfo.getPointerInfo().getLocation().getY() - 45;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		j.repaint();
		System.out.println("X: " + mouseX);
		System.out.println("Y: " + mouseY);
		
	}
	
}
