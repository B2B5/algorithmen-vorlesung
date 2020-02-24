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
			boolean isMulti = false;
			boolean didPop = false;
			
			for(i=1;i<workString.length(); i++) {
				char currentChar = workString.charAt(i);
				if(prevChar == currentChar) {
					isMulti = true;
				}
				else if(isMulti){
					boolean canPop= false;
					//check if we can pop
					if(i==workString.length()-1) {
						canPop=true;
					}
//					else if(i+1 < workString.length() && workString.charAt(i+1) == currentChar) {
//						
//					}
					else {
						//gibt an, ob das 
						boolean isNextOfPopCharMulti = false;
						// gibt an ob mind. 1 weiteres vom currentChar abweichendes Zeichen gefunden wurde, dann pop
						boolean foundNext = false; 
						
						int indexOfFirstNext = -1;
						for(int j= i+1; j< workString.length(); j++) {
							if(workString.charAt(j) != currentChar) {
								foundNext = true;
								if(indexOfFirstNext == -1) {
									indexOfFirstNext = j;
								}
								else if(j-indexOfFirstNext == 1) {
									isNextOfPopCharMulti = true;
									break; // frueher abbrechen, die ganze schleife muss nicht weiter durchlaufen werden.
								}
							}
						}
						canPop = isNextOfPopCharMulti || !foundNext;
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
				if(isMulti) {
					return 1;
				}
				break;
			}
			
		}
		
		return workString.contentEquals("") ? 1 : 0;
	}
	

}
