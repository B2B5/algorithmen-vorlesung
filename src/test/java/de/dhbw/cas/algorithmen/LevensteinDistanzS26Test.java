package de.dhbw.cas.algorithmen;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LevensteinDistanzS26Test {
	
	@Test
	public void levensteinDistanz_LiefertKorrektesErgebnis_FuerGueltigeEingaben() {
		
		assertEquals(1, LevensteinDistanzS26.levensteinDistanz("a", "b"));
		assertEquals(1, LevensteinDistanzS26.levensteinDistanz("a", ""));
		assertEquals(1, LevensteinDistanzS26.levensteinDistanz("", "b"));
		assertEquals(2, LevensteinDistanzS26.levensteinDistanz("heute", "hütte"));
		assertEquals(1, LevensteinDistanzS26.levensteinDistanz("mor", "moor"));
		assertEquals(1, LevensteinDistanzS26.levensteinDistanz("aab", "ab"));
		assertEquals(3, LevensteinDistanzS26.levensteinDistanz("graph", "group"));
	}
}
