package com.luv2code.springdemo.dao;

import java.util.List;

import com.luv2code.springdemo.entity.CryptoTransaction;

//DAO = Data Access Object
public interface CryptoDAO {
	public List<CryptoTransaction> getTransactions();

	public void saveCryptoTx(CryptoTransaction cryptoTransaction);
}
