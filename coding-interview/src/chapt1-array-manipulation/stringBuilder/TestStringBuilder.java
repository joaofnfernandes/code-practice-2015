package stringBuilder;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestStringBuilder {
	
	@Test
	public void testEmptyStringBuilder() {
		StringBuilder builder = new StringBuilder();
		assertEquals(0, builder.length());
		String result = builder.toString();
		assertEquals("", result);
	}
	
	@Test
	public void testAppendString() {
		StringBuilder builder = new StringBuilder();
		String text = "abc";
		builder.append(text);
		String result = builder.toString();
		assertEquals(text, result);
	}
	
	@Test
	public void testAppendHugeString() {
		final int SIZE = 256;
		StringBuilder builder = new StringBuilder();
		java.lang.StringBuilder referenceBuilder = new java.lang.StringBuilder();
		for(int i = 0; i < SIZE; i++) {
			char c = (char)(Math.random() * 256);
			builder.append(c); referenceBuilder.append(c);
		}
		assertEquals(builder.toString(), referenceBuilder.toString());
	}
	
	@Test
	public void testAppendObject() {
		StringBuilder builder = new StringBuilder();
		int value = 123;
		builder.append(value);
		String result = builder.toString();
		assertEquals(Integer.toString(value), result);
	}
	
	@Test
	public void testCharAt() {
		StringBuilder builder = new StringBuilder();
		String text = "abc";
		builder.append(text);
		char result = builder.charAt(1);
		assertEquals('b', result);
	}
	
	@Test
	public void testDeleteChar() {
		StringBuilder builder = new StringBuilder();
		String text = "abc";
		builder.append(text).deleteCharAt(0);
		String result = builder.toString();
		assertEquals("bc", result);
	}
	
	@Test
	public void testReverse() {
		StringBuilder builder = new StringBuilder();
		String text = "abc";
		builder.append(text).reverse();
		String result = builder.toString();
		assertEquals("cba", result);
	}
	
	@Test
	public void testSubstring() {
		StringBuilder builder = new StringBuilder();
		String text = "abc";
		builder.append(text);
		String result = builder.substring(1, 2);
		assertEquals("b", result);
	}

}
