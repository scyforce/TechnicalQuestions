package com.interview.sfdc.inventory;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.HashMap;


public class Inventory {
	private Map<String, Good> inventoryMap;
	private double profit;
	
	public Inventory() {
    	this.inventoryMap = new HashMap<String, Good>();
    }
	
	public void addGood(Good good) {
    	inventoryMap.put(good.getName(), good);
    }
	
	public Good removeGood(String name) {
		return inventoryMap.remove(name);
	}
	
	public Good getGood(String name) {
		return inventoryMap.get(name);
	}
	
	public boolean isGoodExist(String name) {
		return inventoryMap.containsKey(name);
	}
	
	public void adjustProfit(double profit) {
		this.profit+=profit;
		this.profit = InventoryUtil.formatPrecision(this.profit);
	}
	
	public void resetProfit() {
		this.profit = 0;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\t\tINVENTORY REPORT\n");
		sb.append("Item Name\t\tBuy At\t\tSell At\t\tOn Hand\t\tValue\n");
		sb.append("---------\t\t------\t\t-------\t\t-------\t\t-----\n");
		double totalValue = 0.0;
		List<String> goodNames = new ArrayList<String>(this.inventoryMap.keySet());
		Collections.sort(goodNames);
		for (String goodName : goodNames) {
			Good good = this.inventoryMap.get(goodName);
			sb.append(good.toString()+"\n");
			totalValue+=good.getBuyingPrice()*good.getStock();
		}
		sb.append("------------------------\n");
		sb.append("Total value of inventory\t\t\t"+InventoryUtil.formatPrecision(totalValue)+"\n");
		sb.append("Profit since last report \t\t\t"+this.profit+"\n");
		return sb.toString();		
	}
}
