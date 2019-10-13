package Minesweeper;

public class Block {
	
	private int x, y;
	private int neighbors;
	public int getNeighbors() {
		return neighbors;
	}

	public void setNeighbors(int neighbors) {
		this.neighbors = neighbors;
	}

	public State state;
	
	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Block(int x, int y) {
		this.x = x;
		this.y = y;
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
