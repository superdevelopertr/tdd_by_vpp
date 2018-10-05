package com.vpp.ex2.mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Test;

public class StockManagerTest {

	@Test
	public void testGetValidLocator() {
		String isbn="9780006486121";

		ExternalWS externalWS = i->new Book(i, "A Feast for Crows", "G.R.R. Martin");
		
		StockManager sm = new StockManager(externalWS);
		String locator = sm.getLocator(isbn);
		assertEquals("6121G4", locator);
	}
	
	@Test
	public void testGetValidLocatorMockitoVersion() {
		String isbn="9780006486121";
		
		ExternalWS ws = mock(ExternalWS.class);
		when(ws.lookup(isbn)).thenReturn(new Book(isbn, "A Feast for Crows", "G.R.R. Martin"));
		
		StockManager sm = new StockManager(ws);
		String locator = sm.getLocator(isbn);
		assertEquals("6121G4", locator);
	}
}