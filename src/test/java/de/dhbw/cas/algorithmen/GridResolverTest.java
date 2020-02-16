package de.dhbw.cas.algorithmen;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import de.dhbw.cas.algorithmen.csesfi1638.Grid;
import de.dhbw.cas.algorithmen.csesfi1638.GridResolver;
import de.dhbw.cas.algorithmen.csesfi1638.GridUtil;

public class GridResolverTest {
	
	private GridResolver resolver = new GridResolver();
	
	private GridUtil gridUtil = new GridUtil();
	
	@Test
	public void resolve_liefertKorrekteAnzahl_Fuer4x4BeispielGrid() {
		int [][] grid = create4x4ExampleGrid();
		int expectedNumberOfPaths = 3;
		
		testGrid(grid, expectedNumberOfPaths);
	}
	
	private void testGrid(int[][] grid, int expectedNumberOfPaths) {
		int actualNumberOfPaths = resolver.resolve(grid);
		
		gridUtil.printGrid(grid);
		System.out.println("Expected number of paths: "+expectedNumberOfPaths);
		System.out.println("------------");
		assertEquals(expectedNumberOfPaths, actualNumberOfPaths);
	}
	
	@Test
	public void resolve_liefertKorrekteAnzahl_FuerZweites4x4Grid() {
		int [][] grid = create4x4SecondExampleGrid();
		int expectedNumberOfPaths = 2;
		
		testGrid(grid, expectedNumberOfPaths);
	}
	
	@Test
	public void resolve_liefertKorrekteAnzahl_Fuer3x4GridMitVielenMoeglichkeiten() {
		int [][] grid = create3x4Grid();
		int expectedNumberOfPaths = 4;
		
		testGrid(grid, expectedNumberOfPaths);
	}
	
	@Test
	public void resolve_liefertKorrekteAnzahl_Fuer4x4GridMitVielenMoeglichkeiten() {
		int [][] grid = createKomplex4x4Grid();
		int expectedNumberOfPaths = 11;
		
		testGrid(grid, expectedNumberOfPaths);
	}
	
	@Test
	public void resolve_liefertKorrekteAnzahl_Fuer2x2GridOhneFallen() {
		int [][] grid = create2x2GridOhneFallen();
		int expectedNumberOfPaths = 2;
		
		testGrid(grid, expectedNumberOfPaths);
	}
	
	private int[][] create2x2GridOhneFallen() {
		return gridUtil.createGrid(2, 2);
	}

	//zwei erwartet
	private int[][] create4x4SecondExampleGrid() {
		int[][] grid = gridUtil.createGrid(4, 4);
		gridUtil.setValueOfGridAt(grid, 2, 0, Grid.TRAP);
		gridUtil.setValueOfGridAt(grid, 1, 1, Grid.TRAP);
		gridUtil.setValueOfGridAt(grid, 3, 2, Grid.TRAP);
		gridUtil.setValueOfGridAt(grid, 0, 3, Grid.TRAP);
		
		return grid;
	}

	// 3 erwartet
	private int[][] create4x4ExampleGrid() {
		int[][] grid = gridUtil.createGrid(4, 4);
		gridUtil.setValueOfGridAt(grid, 1, 1, Grid.TRAP);
		gridUtil.setValueOfGridAt(grid, 3, 2, Grid.TRAP);
		gridUtil.setValueOfGridAt(grid, 0, 3, Grid.TRAP);
		
		return grid;
	}
	
	//view erwartet
	private int[][] create3x4Grid() {
		int[][] grid = gridUtil.createGrid(3, 4);
		gridUtil.setValueOfGridAt(grid, 2, 2, Grid.TRAP);
		
		return grid;
	}
	
	//drei erwartet
	private int[][] createKomplex4x4Grid() {
		int[][] grid = gridUtil.createGrid(4, 4);
		gridUtil.setValueOfGridAt(grid, 1, 2, Grid.TRAP);
		
		return grid;
	}
}
