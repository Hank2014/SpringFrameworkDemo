package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.CryptoTransaction;

@Repository
public class CryptoDAOImpl implements CryptoDAO{

	@Autowired
	private SessionFactory sessionfactory;
	
	@Override
	public List<CryptoTransaction> getTransactions() {
		
		Session currentSession = sessionfactory.getCurrentSession();
		
		//from + "Class name" instead of Table name
		Query<CryptoTransaction> theQuery = currentSession.createQuery("from CryptoTransaction", CryptoTransaction.class);
		
		List<CryptoTransaction> transactions = theQuery.getResultList();
		
		return transactions;
	}

	@Override
	public void saveCryptoTx(CryptoTransaction cryptoTransaction) {
		Session currentSession = sessionfactory.getCurrentSession();
		currentSession.saveOrUpdate(cryptoTransaction);
	}
	
	

}
