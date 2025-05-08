package com.edu.coffeshop.drink;

import java.util.Objects;

public class Drink {
	private final int milkAmountPerDrink;
	private final int beansAmountPerDrink;
	private final int waterAmountForDrink;

	public Drink(String drink) {		
		switch (drink) {		
		case "Cappuccino":
			milkAmountPerDrink = 120;
			beansAmountPerDrink = 8;
			waterAmountForDrink = 25;
			break;
		
		case "Latte":
			milkAmountPerDrink = 250;
			beansAmountPerDrink = 8;
			waterAmountForDrink = 25;
			break;
		case "Espresso":
			milkAmountPerDrink = 0;
			beansAmountPerDrink = 8;
			waterAmountForDrink = 25;
			break;
			
		default:
			milkAmountPerDrink = 0;
			beansAmountPerDrink = 0;
			waterAmountForDrink = 0;
		}
	}
	
	public int getMilkAmountPerDrink() {
		return milkAmountPerDrink;
	}

	public int getBeansAmountPerDrink() {
		return beansAmountPerDrink;
	}

	public int getWaterAmountForDrink() {
		return waterAmountForDrink;
	}

	@Override
	public int hashCode() {
		return Objects.hash(beansAmountPerDrink, milkAmountPerDrink, waterAmountForDrink);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Drink other = (Drink) obj;
		return beansAmountPerDrink == other.beansAmountPerDrink && milkAmountPerDrink == other.milkAmountPerDrink
				&& waterAmountForDrink == other.waterAmountForDrink;
	}
	
	

}
