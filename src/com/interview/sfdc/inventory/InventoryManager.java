package com.interview.sfdc.inventory;

import java.util.Scanner;

public class InventoryManager {
    private Inventory inventory;
    private Operation operation;
	
    
    public InventoryManager() {
    	inventory = new Inventory();
    	operation = new OperationImpl();
    }
    
    public String executeOperation(String line) {
    	Scanner scanner = new Scanner(line).useDelimiter("\\s+");
    	String operationName = scanner.next();
    	String message = null;
    	if (operationName.equalsIgnoreCase("new")) {
    		String itemName = scanner.next();
    		double buyingPrice = scanner.nextDouble();
    		double sellingPrice = scanner.nextDouble();
    		operation.newItem(inventory, itemName, buyingPrice, sellingPrice);
    	} else if (operationName.equalsIgnoreCase("delete")) {
    		String itemName = scanner.next();
    		operation.deleteItem(inventory, itemName);
    	} else if (operationName.equalsIgnoreCase("buy")) {
    		String itemName = scanner.next();
    		int stock = scanner.nextInt();
    		operation.buyItem(inventory, itemName, stock);
    	} else if (operationName.equalsIgnoreCase("sell")) {
    		String itemName = scanner.next();
    		int stock = scanner.nextInt();
    		operation.sellItem(inventory, itemName, stock);
    	} else if (operationName.equalsIgnoreCase("report")) {
    		message = operation.report(inventory);
    	} else {
    		throw new UnsupportedOperationException();
    	}
    	
    	return message;
    }
    
}
