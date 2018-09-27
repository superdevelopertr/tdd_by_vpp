package com.vpp.ex1.hello_tdd;

public class ISBNValidator {

	public boolean checkIsbn(String isbn) {
		
		if(isbn.length()!=10) {
			throw new NumberFormatException("isbn number should be 10 digit");
		}
		
		int sum=0;
		for(int i=0;i<10;i++) {
			if(Character.isDigit(isbn.charAt(i))) {
				sum+=Integer.valueOf(isbn.charAt(i))*(10-i);
			}else {
				if(i==9 && isbn.charAt(i)=='X') {
					sum+=10;
				}else {
					throw new NumberFormatException("isbn number should be numeric");
				}
			}
		}
		
		System.out.println(sum);
		return sum%11==0;
	}

}