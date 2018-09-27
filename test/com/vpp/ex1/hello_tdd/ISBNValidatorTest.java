package com.vpp.ex1.hello_tdd;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class ISBNValidatorTest {

	@Test
	public void checkValidISBN() {
		ISBNValidator validator = new ISBNValidator();
		
		boolean result = validator.checkIsbn("9750719409");
		assertTrue("first value", result);
		
		result = validator.checkIsbn("6050827230");
		assertTrue("second value", result);
	}
	
	@Test
	public void checkInvalidISBN() {
		ISBNValidator validator = new ISBNValidator();
		boolean result = validator.checkIsbn("9750719401");
		assertFalse(result);
	}
	
	@Test(expected=NumberFormatException.class)
	public void  checkISBNIs10Digit() {
		ISBNValidator validator = new ISBNValidator();
		validator.checkIsbn("1234");
	}
	
	@Test(expected=NumberFormatException.class)
	public void  checkISBNIsNumeric() {
		ISBNValidator validator = new ISBNValidator();
		validator.checkIsbn("helloworld");
	}
	
	@Test
	public void checkISBNLastCharacterXIsValid() {
		ISBNValidator validator = new ISBNValidator();
		boolean result = validator.checkIsbn("975071940X");
		assertTrue(result);
	}
}
