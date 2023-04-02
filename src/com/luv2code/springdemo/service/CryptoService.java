package com.luv2code.springdemo.service;

import java.util.List;

import com.luv2code.springdemo.entity.CryptoTransaction;

public interface CryptoService {
	public List<CryptoTransaction> getTransactions();

	public void saveCryptoTx(CryptoTransaction cryptoTransaction);
}
