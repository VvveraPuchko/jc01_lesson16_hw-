package com.edu.coffeshop.ui;

import java.util.Scanner;

import com.edu.coffeshop.machine.CoffeeMachine;
import com.edu.coffeshop.service.*;

public class CafeConsoleUi {
	
	private final Scanner scanner = new Scanner(System.in);
	private final CoffeeShopService service;
	
	public CafeConsoleUi(CoffeeShopService service) {
		this.service = service;
	}
	
	public void run() {
		while(true) {
			System.out.println("Choose option: ");
			System.out.println("1. Add Coffee Machine");
			System.out.println("2. Delete Coffee Machine");
			System.out.println("3. Show all Coffee Machines");
			System.out.println("4. Add water to Coffee Machine");
			System.out.println("5. Add milk to Coffee Machine");
			System.out.println("6. Add beans to Coffee Machine");
			System.out.println("7. Make Cappuccino in Coffee Machine");
			System.out.println("8. Make Latte in Coffee Machine");
			System.out.println("9. Make Espresso in Coffee Machine");
		
		
		int option = Integer.parseInt(scanner.nextLine());
		
		switch(option) {
			case 1 -> addCoffeeMachine();
			case 2 -> removeCoffeeMachine();
			case 3 -> showAllMachines();
			case 4 -> addWater();
			case 5 -> addMilk();
			case 6 -> addBeans();
			case 7 -> makeCappuccino();
			case 8 -> makeLatte();
			case 9 -> makeEspresso();
			default -> System.out.println("Invalid input!");
		}
		}
			
	}
	
	public void addCoffeeMachine() {
		System.out.println("Id for Coffee Machine: ");
		String id = scanner.nextLine();
		System.out.println("WaterLevel: ");
		int waterLevel = Integer.parseInt(scanner.nextLine());
		System.out.println("MilkLevel: ");
		int milkLevel = Integer.parseInt(scanner.nextLine());
		System.out.println("Beans amount: ");
		int beans = Integer.parseInt(scanner.nextLine());	
		service.addCoffeeMachine(id, waterLevel, milkLevel, beans);
		System.out.println("Coffee Machine was added to the Coffee Shop. ");
	}

	public void removeCoffeeMachine() {
		System.out.println("Id for Coffee Machine you would like to delete: ");
		String id = scanner.nextLine();
		boolean wasDeleted = service.deleteCoffeeMachine(id);
		if (wasDeleted) {
			System.out.println("Coffee Machine was deleted from the Coffee Shop. ");
		} else {
			System.out.println("There is no Coffee Machine with the ID " + id + " in the Coffee Shop. ");
		}
	}
	
	public void showAllMachines() {
		for(CoffeeMachine cm: service.getAll()) {
			System.out.println(cm);
		}
	}
	
	public void addWater() {
		System.out.println("Id for Coffee Machine you would like to fill with water: ");
		String id = scanner.nextLine();
		System.out.println("Amount of water: ");
		int amount = Integer.parseInt(scanner.nextLine());
		service.fillWater(amount, id);
		System.out.println("You have added water to the coffee machine ");
	}
	
	public void addMilk() {
		System.out.println("Id for Coffee Machine you would like to fill with milk: ");
		String id = scanner.nextLine();
		System.out.println("Amount of milk: ");
		int amount = Integer.parseInt(scanner.nextLine());
		service.fillMilk(amount, id);
		System.out.println("You have added milk to the coffee machine ");
	}
	
	public void addBeans() {
		System.out.println("Id for Coffee Machine you would like to fill with beans: ");
		String id = scanner.nextLine();
		System.out.println("Amount of beans: ");
		int amount = Integer.parseInt(scanner.nextLine());
		service.fillBeans(amount, id);
		System.out.println("You have added beans to the coffee machine ");
	}
	
	public void makeCappuccino() {
		System.out.println("Id for Coffee Machine where you would like to make cappuccino: ");
		String id = scanner.nextLine();
		String result = service.makeCoffee("Cappuccino", service.getCoffeeMachine(id));
		System.out.println(result);
	}
	
	public void makeLatte() {
		System.out.println("Id for Coffee Machine where you would like to make latte: ");
		String id = scanner.nextLine();
		String result = service.makeCoffee("Latte", service.getCoffeeMachine(id));
		System.out.println(result);
	}
	
	public void makeEspresso() {
		System.out.println("Id for Coffee Machine where you would like to make espresso: ");
		String id = scanner.nextLine();
		String result = service.makeCoffee("Espresso", service.getCoffeeMachine(id));
		System.out.println(result);
	}

	
	
	
}
