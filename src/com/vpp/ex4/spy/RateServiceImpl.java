package com.vpp.ex4.spy;

import java.util.HashMap;
import java.util.Map;

public class RateServiceImpl implements RateService {

	private Map<String, Double> rateDB = new HashMap<>();
	
	public RateServiceImpl() {

		rateDB.put("9780006486121", 10d);
	}
	
	@Override
	public double getRate(String isbn) {
		return rateDB.get(isbn);
	}
}