package de.dhbw.cas.algorithmen;

public class WechselGeld {
	public static int getAnzahlMuenzen(int amountMoneyInCents) {
		//sort order is important. starts with highest.
		int[] availableCoins = new int[] {25,10,5,1};
		int numberOfCoins = 0;
		
		int remainingMoneyInCents = amountMoneyInCents;
		for(int i=0; i< availableCoins.length; i++) {
			int valueOfCurrentCoin = availableCoins[i];
			numberOfCoins += remainingMoneyInCents / valueOfCurrentCoin; // abgerundetes Ergebnis da int
			remainingMoneyInCents = remainingMoneyInCents % valueOfCurrentCoin;
		}
		
		return numberOfCoins;
	}
}
