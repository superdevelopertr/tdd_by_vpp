package com.vpp.ex3.bdd;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Test;

public class StockManagerTest {

	@Test
	public void validate_DBIsCalledBuWSIsNotCalled() {
		String isbn="9780006486121";
		
		
		ExternalService db = mock(ExternalService.class);
		when(db.lookup(isbn)).thenReturn(new Book(isbn, "A Feast for Crows", "G.R.R. Martin"));
		
		ExternalService ws = mock(ExternalService.class);
		when(ws.lookup(isbn)).thenReturn(new Book(isbn, "A Feast for Crows", "G.R.R. Martin"));
		
		StockManager sm = new StockManager(ws, db);
		sm.getLocator(isbn);
		
		verify(db).lookup(anyString());
		verify(ws, never()).lookup(anyString());
	}
}