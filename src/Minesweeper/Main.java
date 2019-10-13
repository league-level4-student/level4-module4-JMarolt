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
	public int totalBombs;
	public int flagsLeft = totalBombs;
	Timer timer;
	
	public Main() {
		f = new JFrame();
		f.setTitle("'_'");
		f.setResizable(false);
		blocks = new Block[width/20][height/20];
		j = new JPanel() {
		//draws the map and other drawing functions
		public void paintComponent(Graphics g) {			
			for(int i = 0; i < width/20; i++) {
				for(int k = 0; k < height/20; k++) {
					if(blocks[i][k].getState().equals(State.FLAGGED)) {
						g.setColor(Color.red);
						g.fillRect(blocks[i][k].getX(), blocks[i][k].getY(), 20, 20);
					}
				}
			}
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
	//sets the blocks before game starts
	public void setBlocks() {	
		for(int i = 0; i < width/20; i++) {
			for(int k = 0; k < height/20; k++) {
				blocks[i][k] = new Block(i*20, k*20);
				blocks[i][k].setX(i);
				blocks[i][k].setY(k);
			}
		}	
		for(int i = 0; i < width/20; i++) {
			for(int k = 0; k < height/20; k++) {
				int next = (int) (Math.random()*5);
				if(next == 0) {
					blocks[i][k].setState(State.BOMB);
				}else if(next >= 1 && next <= 4){
					blocks[i][k].setState(State.UNCHECKED);
				}		
			}
		}
	}
	//return number of bombs
	public void getTotalBombs() {
		for(int i = 0; i < width/20; i++) {
			for(int k = 0; k < height/20; k++) {
				if(blocks[i][k].getState().equals(State.BOMB)) {
					totalBombs++;
				}
			}
		}
	}
	//returns the neighbors that are a bomb
	public int getBombNeighbors(int x, int y) {
		int num = 0;
		
		int ax = x/20;
		int ay = y/20;
		
		if(ax - 1 > 0 && ay - 1 > 0) {
			if(blocks[ax - 1][ay - 1].getState().equals(State.BOMB)) {
				num++;
			}
		}
		if(ay - 1 > 0) {
			if(blocks[ax][ay - 1].getState().equals(State.BOMB)) {
				num++;
			}
		}
		if(ax + 1 < 26 && ay - 1 > 0) {
			if(blocks[ax + 1][ay - 1].getState().equals(State.BOMB)) {
				num++;
			}
		}
		if(ax + 1 < 26) {
			if(blocks[ax + 1][ay].getState().equals(State.BOMB)) {
				num++;
			}
		}
		if(ax + 1 < 26 && ay + 1 < 26) {
			if(blocks[ax + 1][ay + 1].getState().equals(State.BOMB)) {
				num++;
			}
		}
		if(ay + 1 < 26) {
			if(blocks[ax][ay + 1].getState().equals(State.BOMB)) {
				num++;
			}
		}
		if(ax - 1 > 0 && ay + 1 < 26) {
			if(blocks[ax - 1][ay + 1].getState().equals(State.BOMB)) {
				num++;
			}
		}
		if(ax - 1 > 0) {
			if(blocks[ax - 1][ay].getState().equals(State.BOMB)) {
				num++;
			}
		}

		return num;
	}
	//returns the neighbors that have 0 bombs around them.
	public int getNullNeighbors(int x, int y) {
		int num = 0;
		
		int ax = x/20;
		int ay = y/20;
		
		if(ax - 1 > 0 && ay - 1 > 0) {
			if(blocks[ax - 1][ay - 1].getState().equals(State.NULL)) {
				num++;
			}
		}
		if(ay - 1 > 0) {
			if(blocks[ax][ay - 1].getState().equals(State.NULL)) {
				num++;
			}
		}
		if(ax + 1 < 26 && ay - 1 > 0) {
			if(blocks[ax + 1][ay - 1].getState().equals(State.NULL)) {
				num++;
			}
		}
		if(ax + 1 < 26) {
			if(blocks[ax + 1][ay].getState().equals(State.NULL)) {
				num++;
			}
		}
		if(ax + 1 < 26 && ay + 1 < 26) {
			if(blocks[ax + 1][ay + 1].getState().equals(State.NULL)) {
				num++;
			}
		}
		if(ay + 1 < 26) {
			if(blocks[ax][ay + 1].getState().equals(State.NULL)) {
				num++;
			}
		}
		if(ax - 1 > 0 && ay + 1 < 26) {
			if(blocks[ax - 1][ay + 1].getState().equals(State.NULL)) {
				num++;
			}
		}
		if(ax - 1 > 0) {
			if(blocks[ax - 1][ay].getState().equals(State.NULL)) {
				num++;
			}
		}

		return num;
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
		mouseY = (int) MouseInfo.getPointerInfo().getLocation().getY();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		mouseX = (int) MouseInfo.getPointerInfo().getLocation().getX();
		mouseY = (int) MouseInfo.getPointerInfo().getLocation().getY();
		//check for bomb state when clicked a certain square to determine what program does
		if(e.getButton() == MouseEvent.BUTTON1) {
			for(int i = 0; i < width/20; i++) {
				for(int k = 0; k < height/20; k++) {
					if(mouseX >= i*20 && mouseX < i*21) {
						if(mouseY >= k*20 && mouseY < k*21) {
							if(blocks[i][k].getState().equals(State.BOMB)) {
								lose();
							}else if(blocks[i][k].getState().equals(State.NULL)) {
								
							}else if(blocks[i][k].getState().equals(State.UNCHECKED)) {
								blocks[i][k].setNeighbors(getBombNeighbors(i*20,k*20));
							}
						}
					}
				}
			}	
		}
		//return amount of bombs around the spot
		if(e.getButton() == MouseEvent.BUTTON3) {
			for(int i = 0; i < width/20; i++) {
				for(int k = 0; k < height/20; k++) {
					if(mouseX >= i*20 && mouseX < i*21) {
						if(mouseY >= k*20 && mouseY < k*21) {
							System.out.println(getBombNeighbors(i*20,k*20));
						}
					}
				}
			}
		}
		//flag the spot pressed
		if(e.getButton() == MouseEvent.BUTTON3) {
			for(int i = 0; i < width/20; i++) {
				for(int k = 0; k < height/20; k++) {
					if(mouseX >= i*20 && mouseX < i*21) {
						if(mouseY >= k*20 && mouseY < k*21) {
							blocks[i][k].setState(State.FLAGGED);
						}
					}
				}
			}
		}
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
		
		//System.out.println(flagsLeft);
		//System.out.println("X: " + mouseX);
		//System.out.println("Y: " + mouseY);
		
	}
	
	public void lose() {
		
	}
	
}
