package de.dhbw.cas.algorithmen;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		// Matrix Multiplikation wie cut rod-aux:

		int[] size_x = new int[] { 4, 5, 2 };
		int[] size_y = new int[] { 5, 2, 8 };
		int start = 0;
		int end = 2;

		int gesamtKosten = matrixMultipl(start, end, size_x, size_y);
		System.out.println(gesamtKosten);

	}

	private static int matrixMultipl(int start, int end, int[] size_x, int[] size_y) {
		if(start == end ) {
			return 0;
		}
		if(start + 1 == end) {
			return size_x[start] * size_y[start] * size_y[end];
		}
		
		int cost = Integer.MAX_VALUE;
		for(int i=1; i< end; i++) {
			cost = Math.min(cost, 
					
					matrixMultipl(start, i, size_x, size_y)
					+ matrixMultipl(i+1, end, size_x, size_y)
					+ size_x[start] * size_x[i] * size_y[end]
					);
		}
		return cost;
		
	}
}
