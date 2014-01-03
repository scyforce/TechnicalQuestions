package com.interview.sfdc.inventory;


public class OperationImpl implements Operation {

	@Override
	public void newItem(Inventory inventory, String itemName, double buyingPrice,
			double sellingPrice) {
		if (!inventory.isGoodExist(itemName)) {
			Good good = new Good(itemName, buyingPrice, sellingPrice);
			inventory.addGood(good);
		}		
	}

	@Override
	public void deleteItem(Inventory inventory, String itemName) {
		if (inventory.isGoodExist(itemName)) {			
			Good good = inventory.removeGood(itemName);			
			double profit = -(good.getStock()*good.getBuyingPrice());
			inventory.adjustProfit(profit);
			System.out.println("remove - " + itemName + " losing " + profit);
		}		
	}

	@Override
	public void buyItem(Inventory inventory, String itemName, int stock) {
		if (inventory.isGoodExist(itemName)) {
			Good good = inventory.getGood(itemName);
			good.addStock(stock);
			System.out.println("add stock - " + itemName);
		}
		
	}

	@Override
	public void sellItem(Inventory inventory, String itemName, int stock) {
		if (inventory.isGoodExist(itemName)) {
			Good good = inventory.getGood(itemName);
			good.sellStock(stock);
			double profit = (stock*(good.getSellingPrice()-good.getBuyingPrice()));
			inventory.adjustProfit(profit);
			System.out.println("sell stock - " + itemName + " gaining " + profit);
		}		
	}

	@Override
	public String report(Inventory inventory) {
		String report = inventory.toString();
		inventory.resetProfit();
		return report;
	}
}
