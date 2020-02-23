package de.dhbw.cas.algorithmen;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class WechselGeldTest {
	
	@Test
	public void getAnzahlMuenzen_LiefertKorrektesWechselGeld_FuerGueltigeEingaben() {
		assertEquals(1, WechselGeld.getAnzahlMuenzen(5));
		assertEquals(3, WechselGeld.getAnzahlMuenzen(27));
		assertEquals(2, WechselGeld.getAnzahlMuenzen(50));
		assertEquals(4, WechselGeld.getAnzahlMuenzen(41));
		assertEquals(1, WechselGeld.getAnzahlMuenzen(10));
	}
}
