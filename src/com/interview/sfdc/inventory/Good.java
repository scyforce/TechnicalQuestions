package com.interview.sfdc.inventory;

public class Good {
    private String name;
    private double buyingPrice;
    private double sellingPrice;
    private int stock;
    
	public Good(String name, double buyingPrice, double sellingPrice) {
		this.name = name;
		this.buyingPrice = buyingPrice;
		this.sellingPrice = sellingPrice;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBuyingPrice() {
		return buyingPrice;
	}
	public void setBuyingPrice(double buyingPrice) {
		this.buyingPrice = buyingPrice;
	}
	public double getSellingPrice() {
		return sellingPrice;
	}
	public void setSellingPrice(double sellingPrice) {
		this.sellingPrice = sellingPrice;
	}
	public int getStock() {
		return stock;
	}
	public void addStock(int stock) {
		this.stock += stock;
	}
	public void sellStock(int stock) {
		this.stock -= stock;
	}
	
	@Override
    public String toString() {
		return name+"\t\t"+buyingPrice+"\t\t"+sellingPrice+"\t\t"+stock+"\t\t"+InventoryUtil.formatPrecision(buyingPrice*stock);   	
    }
	
	public static void main(String[] args) {
		Good g = new Good("test",1.0f,0.5f);
		g.setName("test");
		g.setSellingPrice(1.0f);
		g.setBuyingPrice(0.5f);
		g.addStock(200);
		System.out.println(g.toString());
		System.out.println(2*(4.98f-1));
	}
    
}
