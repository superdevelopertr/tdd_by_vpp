package com.vpp.ex4.spy;

public class StockManager {

	private ExternalService externalWS;
	
	private ExternalService externalDB;
	
	public StockManager(ExternalService externalWS, ExternalService externalDB) {
		super();
		this.externalWS = externalWS;
		this.externalDB = externalDB;
	}

	public String getLocator(String isbn) {
		
		Book book = externalDB.lookup(isbn);
		if(book==null) {
			book = externalWS.lookup(isbn);
		}
		
		StringBuilder locatorBuilder = new StringBuilder();
		locatorBuilder.append(isbn.substring(isbn.length()-4));
		locatorBuilder.append(book.getAuthor().substring(0, 1));
		locatorBuilder.append(book.getTitle().split(" ").length);
		locatorBuilder.append(book.getRate());
		
		return locatorBuilder.toString();
	}

}