package com.edu.coffeshop.service;

import java.util.Collection;

import com.edu.coffeshop.cafe.*;
import com.edu.coffeshop.machine.*;
import com.edu.coffeshop.drink.*;

public class CoffeeShopService {
	private final CoffeeShop coffeeshop;
	
	public CoffeeShopService(CoffeeShop coffeeshop) {
		this.coffeeshop = coffeeshop;
	}
	
	public void addCoffeeMachine(String id, int waterLevel, int milkLevel,int beans) {
		CoffeeMachine coffeemachine = new CoffeeMachine(id, waterLevel, milkLevel, beans);
		coffeeshop.add(coffeemachine);
	}
	
	public boolean deleteCoffeeMachine(String Id) {
		if(coffeeshop.get(Id) != null) {
			coffeeshop.remove(Id);
			return true;
		}
		return false;
	}
	
	public String makeCoffee(String drinkType, CoffeeMachine coffeeMachine) {

		StringBuilder result = new StringBuilder();
		Drink drink = new Drink(drinkType);
		if (coffeeMachine.isEmptyBeans()) {
			result.append("Coffee Machine ").append(coffeeMachine.getId()).append(" has no beans. Please add beans");
		} else if (coffeeMachine.isEmptyMilk()) {
			result.append("Coffee Machine ").append(coffeeMachine.getId()).append(" has no milk. Please add milk");
		} else if (coffeeMachine.isEmptyWater()) {
			result.append("Coffee Machine ").append(coffeeMachine.getId()).append(" has no water. Please add water");
		}

		boolean madeCoffee = coffeeMachine.makeCoffee(drink.getMilkAmountPerDrink(), drink.getBeansAmountPerDrink(),
				drink.getWaterAmountForDrink());
		if (!madeCoffee) {
			result.append("Coffee Machine ").append(coffeeMachine.getId())
					.append(" hasn't got enough ingredients to make this kind of coffee. Please review the ingredients");
		} else {
			result.append("Your ").append(drinkType).append(" was successfully made in Coffee Machine ")
					.append(coffeeMachine.getId());
		}
		return result.toString();
	}
	
	public void fillWater(int amount, String Id) {
		if(coffeeshop.get(Id) != null) {
			CoffeeMachine coffeeMachine = coffeeshop.get(Id);
			coffeeMachine.fillWater(amount);
		}
	}
	
	public void fillMilk(int amount, String Id) {
		if(coffeeshop.get(Id) != null) {
			CoffeeMachine coffeeMachine = coffeeshop.get(Id);
			coffeeMachine.fillMilk(amount);
		}
	}
	
	public void fillBeans(int amount, String Id) {
		if(coffeeshop.get(Id) != null) {
			CoffeeMachine coffeeMachine = coffeeshop.get(Id);
			coffeeMachine.fillBeans(amount);
		}
	}
	
	public Collection<CoffeeMachine> getAll() {
		return coffeeshop.getAll();
	}
	
	public CoffeeMachine getCoffeeMachine(String id) {
		return coffeeshop.get(id);
	}
}
