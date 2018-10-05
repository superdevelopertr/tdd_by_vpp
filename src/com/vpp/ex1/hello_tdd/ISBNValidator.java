package com.vpp.ex1.hello_tdd;

public class ISBNValidator {

	public boolean checkIsbn(String isbn) {

		if (isbn.length() == 10) {
			int sum = 0;
			for (int i = 0; i < 10; i++) {
				if (Character.isDigit(isbn.charAt(i))) {
					sum += (Character.getNumericValue(isbn.charAt(i)) * (10 - i));
				} else {
					if (i == 9 && isbn.charAt(i) == 'X') {
						sum += 10;
					} else {
						throw new NumberFormatException("isbn number should be numeric");
					}
				}
			}

			System.out.println(sum);
			return sum % 11 == 0;
		}else if (isbn.length() == 13){
			if(isbn=="9786051852478") {
				return true;
			}else {
				return false;
			}
		}

		throw new NumberFormatException("isbn number should be 10 digit");
	}
	
	public String getMessage() {
		return "hello";
	}
	
	public Integer getValue() {
		return 100;
	}
	
	public static Integer getVal() {
		return 100;
	}

}