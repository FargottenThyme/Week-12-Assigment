package com.promineotech;

import java.util.Random;

public class TestDemo {
	private int randomInt = getRandomInt();
	public int addPositive(int a, int b) {
		if (a > 0 && b > 0) {
			return a + b;
		} else {
			throw new IllegalArgumentException("Both parameters must be positive!");
		}
	}
	// Checks if a person can afford the total.
	public boolean canAffordTotal(double itemCost1, double itemCost2, double itemCost3, double funds) {
		// Checks if each parameter is at least 0.00.
		if (itemCost1 >= 0.00 && itemCost2 >= 0.00 && itemCost3 >= 0.00 && funds >= 0.00) {
			double total = itemCost1 + itemCost2 + itemCost3; // Adds (sum) the item costs together.
			return funds >= total; // Returns the boolean of whether funds is greater than or equal to the total.
		} else {
			throw new IllegalArgumentException("One or more paramaters are less than zero!"); //If any parameter is less than zero, throws an exception.
		}
	}
	
	public int randomNumberSquared() {
		return randomInt * randomInt;
	}
	
	int getRandomInt() {
			Random random = new Random();
			return random.nextInt(10) + 1;
	}
}
