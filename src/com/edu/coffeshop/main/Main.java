package com.edu.coffeshop.main;

import com.edu.coffeshop.cafe.*;
import com.edu.coffeshop.ui.*;
import com.edu.coffeshop.service.*;

public class Main {

	public static void main(String[] args) {
		
		CoffeeShop coffeeshop = new CoffeeShop();
		CoffeeShopService service = new CoffeeShopService(coffeeshop);
		CafeConsoleUi ui = new CafeConsoleUi(service);
		
		ui.run();

	}

}
