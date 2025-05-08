package com.edu.coffeshop.cafe;
import java.util.Collection;

import java.util.HashMap;
import java.util.Map;

import com.edu.coffeshop.machine.CoffeeMachine;

public class CoffeeShop {
	private final Map<String, CoffeeMachine> coffeeMachines = new HashMap<>();
	
	public void add(CoffeeMachine machine) {
		coffeeMachines.put(machine.getId(), machine);
	}
	
	public void remove(String Id) {
		coffeeMachines.remove(Id);
	}
	
	public CoffeeMachine get(String Id) {
		return coffeeMachines.get(Id);
	}
	
	public Collection<CoffeeMachine> getAll(){
		return coffeeMachines.values();
	}

}
