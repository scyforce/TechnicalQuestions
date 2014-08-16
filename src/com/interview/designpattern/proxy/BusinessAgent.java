package com.interview.designpattern.proxy;

class BusinessAgent implements CheatingWife {
	private CheatingWife cheatingWife;
 
	public BusinessAgent() {
		this.cheatingWife = new HouseWifeOne();
	}
 
	public BusinessAgent(CheatingWife cheatingWife) {
		this.cheatingWife = cheatingWife;
	}
 
	public void seduceMan() {
		this.cheatingWife.seduceMan();
	}
 
	public void happyWithMan() {
		this.cheatingWife.happyWithMan();
	}
 
}
