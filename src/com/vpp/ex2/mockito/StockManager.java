package com.vpp.ex2.mockito;

public class StockManager {

	private ExternalWS externalWS;
	
	public StockManager(ExternalWS externalWS) {
		super();
		this.externalWS = externalWS;
	}

	public String getLocator(String isbn) {
		
		Book book = externalWS.lookup(isbn);
		
		StringBuilder locatorBuilder = new StringBuilder();
		locatorBuilder.append(isbn.substring(isbn.length()-4));
		locatorBuilder.append(book.getAuthor().substring(0, 1));
		locatorBuilder.append(book.getTitle().split(" ").length);
		
		return locatorBuilder.toString();
	}

}