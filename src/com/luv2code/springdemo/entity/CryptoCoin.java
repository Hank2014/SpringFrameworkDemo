package com.luv2code.springdemo.entity;

public class CryptoCoin implements Comparable<CryptoCoin>{
	public CryptoCoin(String coinName, double totalAmount, double avgCost, String exchange) {
		this.coinName = coinName;
		this.totalAmount = totalAmount;
		this.avgCost = avgCost;
		this.exchange = exchange;
	}


	public CryptoCoin() {
		coinName="N/A";
		totalAmount=0;
		avgCost=0;
		exchange="N/A";
	}


	private String coinName;
	private double totalAmount;
	private double avgCost;
	private String exchange;
	public String getCoinName() {
		return coinName;
	}
	public void setCoinName(String coinName) {
		this.coinName = coinName;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public double getAvgCost() {
		return avgCost;
	}
	public void setAvgCost(double avgCost) {
		this.avgCost = avgCost;
	}
	public String getExchange() {
		return exchange;
	}
	public void setExchange(String exchange) {
		this.exchange = exchange;
	}
	

	@Override
	public int compareTo(CryptoCoin o) {
		int compareName = (this.getCoinName().equalsIgnoreCase(o.getCoinName()))?1:0;
		int compareExchange = (this.getExchange().equalsIgnoreCase(o.getExchange()))?1:0;
		return compareName*compareExchange;
	}
	
	public CryptoCoin averageForBuySell(CryptoCoin c) {
		CryptoCoin res = new CryptoCoin();
		res.setCoinName(this.coinName);
		res.setExchange(this.getExchange());

		double totalAmount = this.getTotalAmount()+c.getTotalAmount();
		double totalCost = (this.getTotalAmount()*this.getAvgCost()+c.getTotalAmount()*c.getAvgCost());
		
		//buy
		if(c.getTotalAmount()>=0){	
			res.setAvgCost(totalCost/totalAmount);
		}else {
			res.setAvgCost(this.avgCost);
		}
		
		res.setTotalAmount(totalAmount);
		return res;
	}

}
