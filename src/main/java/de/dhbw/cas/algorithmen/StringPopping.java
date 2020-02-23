package de.dhbw.cas.algorithmen;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class StringPopping {

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
		
		
		
		String workString = ""+str;
		
		int i=1;
		while(!workString.contentEquals("")) {
			if(workString.length() == 1) {
				return 0;
			}
			
			boolean didPop = false;
			char prevChar=workString.charAt(0);
			int prevCharIndex =0;
			boolean isMulti = false;
			
			for(i=1;i<workString.length(); i++) {
				char currentChar = workString.charAt(i);
				if(prevChar == currentChar) {
					isMulti = true;
				}
				else {
					// kann ich poppen?
					
					if(isMulti) {
						boolean canPop = isMulti;
						boolean currentIndexIsLastChar = i==workString.length();
						if(currentIndexIsLastChar) {
							canPop = true;
						}
						else if(workString.length() -i > 1){
							canPop = workString.charAt(i +1 ) == currentChar;
						}
						//pop
						//pruefen, ob danach ein einzelnes kommt
						if(canPop) {
							workString = 
									workString.substring(0, prevCharIndex) 
									+ workString.substring(i, workString.length());
							didPop = true;							
						}
						if(didPop) {
							break;
						}
					}
					prevChar = currentChar;
					prevCharIndex = i;
				}
			}
			if(i == workString.length() && !didPop) {
				if(isMulti) {
					return 1;
				}
				break;
			}
			
		}
		
		return workString.contentEquals("") ? 1 : 0;
	}
	

}
