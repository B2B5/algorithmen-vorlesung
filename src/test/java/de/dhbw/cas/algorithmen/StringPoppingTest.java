package de.dhbw.cas.algorithmen;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class StringPoppingTest {

	@Test
	public void popStrings_LiefertKorrektesErgebnis_FuerPopbareStrings() {
		assertEquals(Arrays.asList(1,1,1), StringPopping.popStrings(3,Arrays.asList("aa", "aabbaa", "bbb")));
		assertEquals(Arrays.asList(1,1,1), StringPopping.popStrings(3,Arrays.asList("aabaab", "babbaab", "abba")));
		assertEquals(Arrays.asList(1), StringPopping.popStrings(1, Arrays.asList("aabbbba")));
	}
	
	@Test
	public void popStrings_LiefertKorrektesErgebnis_FuerNichtPopbareStrings() {
		assertEquals(Arrays.asList(0,0,0), StringPopping.popStrings(3,Arrays.asList("ab", "a", "b")));
		assertEquals(Arrays.asList(0,0), StringPopping.popStrings(3,Arrays.asList("abab", "bba")));
		
	}
}
