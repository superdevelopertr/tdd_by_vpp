package com.vpp.ex4.spy;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.mockito.Mockito;

public class StockManagerTest {

	@Test
	public void validate_DBIsCalledBuWSIsNotCalled() {
		String isbn="9780006486121";
		
		Book book = spy(new Book(isbn, "A Feast for Crows", "G.R.R. Martin"));
		Mockito.doReturn(20.0).when(book).getRate();
		
		ExternalService db = mock(ExternalService.class);
		when(db.lookup(isbn)).thenReturn(null);
		
		ExternalService ws = mock(ExternalService.class);
		when(ws.lookup(isbn)).thenReturn(book);
		
		StockManager sm = new StockManager(ws, db);
		String result = sm.getLocator(isbn);
		
		assertEquals(result, "6121G420.0");
	}
}