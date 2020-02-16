package de.dhbw.cas.algorithmen.csesfi1638;

public class Position {
	public int x;
	public int y;
	
	public Position(int x,int y) {
		this.x=x;
		this.y=y;
	}
	
	public Position goUpWards() {
		return new Position(x, y-1);
	}
	
	public Position goLeft() {
		return new Position(x -1, y);
	}
	
	public boolean canGoUp() {
		return y - 1 >= 0;
	}
	
	public boolean canGoLeft() {
		return x- 1 >= 0;
	}
	
	public boolean isStartPos() {
		return x == 0 && y == 0;
	}
}
