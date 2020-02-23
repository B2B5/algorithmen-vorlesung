package de.dhbw.cas.algorithmen;

public class LevensteinDistanzS26 {
	public static int levensteinDistanz(String aStr, String bStr) {
		if(aStr == null || bStr == null) {
			return -1;
		}
		if("".equals(aStr) || "".equals(bStr)) {
			return Math.max(aStr.length(), bStr.length());
		}
		//array aufbauen mit lösungen für a.length-1 bzw. b.length-1
		// ein zusätzliches feld wird für die initialwerte benoetigt
		int anzahlZeilen = aStr.length()+1;
		int anzahlSpalten = bStr.length()+1;
		
		int[][] distanz = new int[anzahlZeilen][];
		//init 2d array
		for(int i=0; i< anzahlZeilen;i++) {
			distanz[i] = new int[anzahlSpalten];
		}		
		distanz[0][0] = 0;
		
		/**
		 * Array
		 *      b0 b1
		 *    0 1  2
		 * a0 1
		 * a1 2 
		 * a2 3
		 */
		// init erste spalte
		for(int aIndex=1; aIndex<anzahlZeilen; aIndex++) {
			distanz[aIndex][0] = aIndex;
		}
		// init erste zeile
		for(int bIndex=1; bIndex<anzahlSpalten; bIndex++) {
			distanz[0][bIndex] = bIndex;
		}
		
		char[] a = aStr.toCharArray();
		char[] b = bStr.toCharArray();
		
		for( int aIndex = 1; aIndex < anzahlZeilen; aIndex++) {
			for(int bIndex = 1; bIndex < anzahlSpalten; bIndex ++) {
				
				// die Distanz hängt von den Teillösungen (a-1 oder b-1) ab, 
				// weil ein Insert oder delete nur 1 kostet
				// ein Change kostet auch 1
				// nur wenn die Teillösung gleich ist kostet es nicht mehr wie die vorige Teillösung (a-1,b-1)
				
				int distanzDirekterVorgaengerOhneInsertDelete = distanz[aIndex -1][bIndex -1];
				int aktuelleChangeDistanz = distanzDirekterVorgaengerOhneInsertDelete;
				if(a[aIndex -1] == b[bIndex -1]) {
					// gleich -> kein change notwendig
				}
				else {
					// change notwendig
					aktuelleChangeDistanz += 1;
				}
				
				// je nach sichtweise
				int distanzInsert = distanz[aIndex][bIndex -1] +1;// 1 ist kosten für insert
				int distanzDelete = distanz[aIndex -1][bIndex] +1;// 1 ist kosten für delete
				
				
				distanz[aIndex][bIndex] = Math.min(aktuelleChangeDistanz, Math.min(distanzInsert, distanzDelete));
			}
		}
		
		return distanz[anzahlZeilen -1][anzahlSpalten -1];
	}
}
