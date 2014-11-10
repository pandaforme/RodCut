package model;

import java.util.HashMap;
import java.util.Map;

public class Price {
	private Map<Integer, Integer>	prices;

	public Price() {
		prices = new HashMap<Integer, Integer>();
	}

	public void add(int rodLength, int price) {
		prices.put(rodLength, price);
	}

	public int getPrice(int rodLength) {
		return prices.get(rodLength);
	}
}
