package de.dhbw.cas.algorithmen.csesfi1638;
import static de.dhbw.cas.algorithmen.csesfi1638.Grid.*;
public class GridUtil {

	
	public void setValueOfGridAt(int[][] grid, int x, int y, int value) {
		grid[y][x] = value;
	}
	
	
	public void setValueOfGridAt(int[][] grid, Position p, int value) {
		setValueOfGridAt(grid, p.x, p.y, value);
	}
	
	public int getValueOfGridAt(int[][] grid, int x, int y) {
		return grid[y][x];
	}
	
	public int getValueOfGridAt(int[][] grid, Position p) {
		return getValueOfGridAt(grid, p.x, p.y);
	}
	

	public int[][] createGrid(int x, int y) {
		int[][] grid = new int[y][x];
		
		for(int yIndex = 0; yIndex < y; yIndex++) {
			grid[yIndex] = new int[x];
			for(int xIndex = 0; xIndex < x; xIndex++) {
				// Achtung y wegen 2d Array in Java an erster Stelle
				grid[yIndex][xIndex] = EMPTY_SQUARE;
			}
		}
		
		return grid;
	}
	
	public void printGrid(int[][] grid) {
		System.out.println();
		for(int yIndex = 0; yIndex < grid.length; yIndex++) {
			for(int xIndex = 0; xIndex < grid[0].length; xIndex++) {
				int value = getValueOfGridAt(grid, xIndex, yIndex);
				if(value == TRAP) {
					System.out.print("*");
				}
				else if(value == EMPTY_SQUARE) {
					System.out.print(".");
				}
			}
			System.out.println();
		}
		System.out.println();
	}
}
