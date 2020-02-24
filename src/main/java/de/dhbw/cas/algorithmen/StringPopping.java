package de.dhbw.cas.algorithmen;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class StringPopping{

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String nextLine = s.nextLine();
		int listLength = Integer.parseInt(nextLine);
		
		List<String> testCases = new LinkedList<String>();
		for(int i=0; i< listLength; i++) {
			String testCase = s.nextLine();
			testCases.add(testCase);
		}
		
		List<Integer> results = popStrings(listLength, testCases);
		
		for(Integer result: results) {
			System.out.println(result);
		}
		
		s.close();
		System.exit(0);
	}
	
	public static List<Integer> popStrings(int listLength, List<String> asList) {
		List<Integer> result = new LinkedList<>();
		
		for(String str: asList) {
			int singleResult = popSingleString(str);
			result.add(singleResult);
		}
		
		
		return result;
	}

	private static int popSingleString(String str) {
		if(str == null || "".contentEquals(str)) {
			return 1;
		}
		
		String workString = ""+str;
		
		int i=1;
		while(!workString.contentEquals("")) {
			if(workString.length() == 1) {
				return 0;
			}
			
			char prevChar=workString.charAt(0);
			int prevCharIndex =0;
			boolean isMultiGroup = false;
			boolean didPop = false;
			
			for(i=1;i<workString.length(); i++) {
				char currentChar = workString.charAt(i);
				if(prevChar == currentChar) {
					isMultiGroup = true;
				}
				else if(isMultiGroup){
					boolean canPop= false;
					//check if we can pop
					boolean isIndexOfCurrentCharTheLastChar = i==workString.length()-1;
					if(isIndexOfCurrentCharTheLastChar) {
						canPop=true;
					}
					else {
						// die popCharGruppe ist das vom currentChar abweichende Gruppe.
						// das currentChar dient zum Bestimmen, wann geprueft werden muss, ob gepoppt wird.
						// der Kommentar oben hört sich komisch an.
						
						boolean isGroupOfPopCharAfterCurrentPopCharGroupMulti = false;
						// gibt an ob mind. 1 weiteres vom currentChar abweichendes Zeichen gefunden wurde
						boolean foundNextGroupOfPopChar = false; 
						
						int indexOfGroupOfPopCharAfterCurrentPopChar = -1;
						for(int j= i+1; j< workString.length(); j++) {
							if(workString.charAt(j) != currentChar) {
								foundNextGroupOfPopChar = true;
								if(indexOfGroupOfPopCharAfterCurrentPopChar == -1) {
									indexOfGroupOfPopCharAfterCurrentPopChar = j;
								}
								else if(j-indexOfGroupOfPopCharAfterCurrentPopChar == 1) {
									isGroupOfPopCharAfterCurrentPopCharGroupMulti = true;
									break; // frueher abbrechen, die ganze schleife muss nicht weiter durchlaufen werden.
								}
							}
						}
						
						canPop = isGroupOfPopCharAfterCurrentPopCharGroupMulti || !foundNextGroupOfPopChar;
					}
					if(canPop) {
						//pop
						workString = 
								workString.substring(0, prevCharIndex) 
								+ workString.substring(i, workString.length());
						didPop = true;
						break;
					}
					
					
				}else {
					prevChar = currentChar;
					prevCharIndex = i;
				}
			}
			if(i == workString.length() && !didPop) {
				// emuliert das Popping am Ende, weil kein unterschiedlicher Charakter mehr gefunden wurde,
				// z.B. bei 'aa'
				if(isMultiGroup) {
					return 1;
				}
				break;
			}
			
		}
		
		return workString.contentEquals("") ? 1 : 0;
	}
	

}
