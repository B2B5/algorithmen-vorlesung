package de.dhbw.cas.algorithmen.csesfi1638;

/**
 * Bestimmt die ANzahl möglicher Pfade zu einem Grid
 * 
 * Ein Grid
 * 
 * @author boelz
 *
 */
public class GridResolver {

	private GridUtil util = new GridUtil();

	/**
	 * Berechnet die Anzahl moeglicher Wege eines Grids
	 * von der obersten linken zur untersten rechten Position.
	 * 
	 * !! Achtung: Start- und Endposition dürfen keine Traps sein.
	 * @param grid das Grid
	 * @return die Anzahl moeglicher Wege
	 */
	public int resolve(int[][] grid) {
		int xLength = grid[0].length;
		int yLength = grid.length;

		// in diesem Grid werden wir die Anzahl moeglicher Wege an der
		// jeweiligen Position speichern.
		// bevor das Grid durchlaufen wird ist alles 0
		int[][] numOfPossibeWaysGrid = util.createGrid(xLength, yLength);
		
		// unsere Startposition ist das Ende des Grids.
		Position endPositionOfGrid = new Position(xLength - 1, yLength - 1);
		
		// das Grid wird solange durchlaufen, bis keine weiteren Wege mehr möglich sind.
		resolveWithAdditionalInfos(grid, endPositionOfGrid, numOfPossibeWaysGrid);
		
		// die Anzahl der moeglichen Wege befindet sich an der Startposition
		return numOfPossibeWaysGrid[0][0];
	}

	/**
	 * durchlauft das Grid von unten nach oben, bis kein weiterer Weg
	 * mehr möglich ist. Bei jeder Position die durchlaufen wird,
	 * wird der Wert im 'numOfPossibeWaysGrid' um eins erhoeht. 
	 * Fuehrt der Weg nicht zur Startposition, weil eine Trap im Weg ist, 
	 * so wird der Weg auch nicht in der Startposition des 'numOfPossibeWaysGrid'
	 * gespeichert, da die Startposition nie erreicht wird.
	 * 
	 * @param grid
	 * @param currentPosition
	 * @param numOfPossibeWaysGrid
	 */
	void resolveWithAdditionalInfos(
			int[][] grid, 
			Position currentPosition, 
			int[][] numOfPossibeWaysGrid) {
		
		int numOfPossibleWaysIfPositionResolves = util.getValueOfGridAt(numOfPossibeWaysGrid, currentPosition);
		
		util.setValueOfGridAt(
				numOfPossibeWaysGrid, 
				currentPosition, 
				numOfPossibleWaysIfPositionResolves +1);
		
		
		if(currentPosition.isStartPos()) {
			return;
		}
		
		if(currentPosition.canGoLeft()) {
			Position leftPos = currentPosition.goLeft();
			if(util.getValueOfGridAt(grid, leftPos) == Grid.EMPTY_SQUARE) {
				resolveWithAdditionalInfos(grid, leftPos, numOfPossibeWaysGrid);
			}
			//bei Traps muss nicht weiter evaluiert werden
		}
		
		if(currentPosition.canGoUp()) {
			Position upPos = currentPosition.goUpWards();
			if(util.getValueOfGridAt(grid, upPos) == Grid.EMPTY_SQUARE) {
				resolveWithAdditionalInfos(grid, upPos, numOfPossibeWaysGrid);
			}
			//bei Traps muss nicht weiter evaluiert werden
		}
		
		return;
	}
}
