package com.luv2code.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.dao.CryptoDAO;
import com.luv2code.springdemo.entity.CryptoTransaction;

@Service
public class CryptoServiceImpl implements CryptoService{

	@Autowired
	private CryptoDAO cryptoDAO;
	
	@Override
	@Transactional
	public List<CryptoTransaction> getTransactions() {
		return cryptoDAO.getTransactions();
	}
	
	@Transactional
	@Override
	public void saveCryptoTx(CryptoTransaction cryptoTransaction) {
		cryptoDAO.saveCryptoTx(cryptoTransaction);
	}

}
