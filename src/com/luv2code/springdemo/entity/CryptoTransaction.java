package com.luv2code.springdemo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="cost")
public class CryptoTransaction {
	
	enum TxType{
		BUY,
		SELL,
		CASHIN,
		CASHOUT,
		SWAP
	}
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int Id;
	

	public CryptoTransaction() {
		
	}



	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getAssetPair() {
		return assetPair;
	}

	public void setAssetPair(String assetPair) {
		this.assetPair = assetPair;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getAtPrice() {
		return atPrice;
	}

	public void setAtPrice(double atPrice) {
		this.atPrice = atPrice;
	}

	@Column(name="TransactionDate")
	@NotNull(message="is required")
	private String transactionDate;

	@Column(name="TransactionType")
	private String transactionType;
	
	@Column(name="AssetPair")
	private String assetPair;
	
	@Column(name="Amount")
	@NotNull(message="is required")
	private double amount;
	
	@Column(name="AtPrice")
	@NotNull(message="is required")
	private double atPrice;
	
	@Column(name="Exchange")
	private String exchange;
	
	




	public String getExchange() {
		return exchange;
	}



	public void setExchange(String exchange) {
		this.exchange = exchange;
	}



	public CryptoTransaction(String transactionDate, String transactionType, String assetPair, double amount, double atPrice,
			String exchange) {
		this.transactionDate = transactionDate;
		this.transactionType = transactionType;
		this.assetPair = assetPair;
		this.amount = amount;
		this.atPrice = atPrice;
		this.exchange = exchange;
	}



	@Override
	public String toString() {
		return "CryptoTransaction [Id=" + Id + ", transactionDate=" + transactionDate + ", transactionType="
				+ transactionType + ", assetPair=" + assetPair + ", amount=" + amount + ", atPrice=" + atPrice
				+ ", exchange=" + exchange + "]";
	}

	
	public CryptoCoin toCoin() {
		String ctassetName = assetPair.substring(0, assetPair.indexOf("/"));
		CryptoCoin cc = new CryptoCoin();
		cc.setCoinName(ctassetName);
		cc.setAvgCost(atPrice);
		cc.setExchange(exchange);
		
		if(transactionType.equalsIgnoreCase("b")) {
			cc.setTotalAmount(amount);
		}else if(transactionType.equalsIgnoreCase("s")) {
			cc.setTotalAmount(-amount);
		}
		return cc;
	}
}
