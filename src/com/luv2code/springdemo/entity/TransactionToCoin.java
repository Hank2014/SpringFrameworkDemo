package com.luv2code.springdemo.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class TransactionToCoin {
	private List<CryptoTransaction> transactions;

	private Map<String, CryptoCoin> ownedCoins;
	
	public Map<String, CryptoCoin> getOwnedCoins() {
		return ownedCoins;
	}

	public void setOwnedCoins(Map<String, CryptoCoin> ownedCoins) {
		this.ownedCoins = ownedCoins;
	}

	public void setTransactions(List<CryptoTransaction> transactions) {
		this.transactions = transactions;
	}

	public TransactionToCoin() {
		ownedCoins = new HashMap<String, CryptoCoin>();
	}

	public List<CryptoTransaction> getTransactions() {
		return transactions;
	}

	public void print() {
		transactions.forEach(System.out::println);
	}
	
	public void calculate() {
		for(CryptoTransaction ct : transactions) {
			String ctAssetPair = ct.getAssetPair();
			String transactionType = ct.getTransactionType();
			
			if(transactionType.equalsIgnoreCase("b")||transactionType.equalsIgnoreCase("s")) {
				String ctassetName = ctAssetPair.substring(0, ctAssetPair.indexOf("/"));
				if(ownedCoins.containsKey(ctassetName)) {
					ownedCoins.put(ctassetName, ownedCoins.get(ctassetName).averageForBuySell(ct.toCoin()));
				}else {
					CryptoCoin cc = ct.toCoin();
					ownedCoins.put(ctassetName, cc);
				}
			}
		}

	}
	

	
}
