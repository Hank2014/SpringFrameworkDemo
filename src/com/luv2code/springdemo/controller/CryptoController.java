package com.luv2code.springdemo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springdemo.entity.CryptoTransaction;
import com.luv2code.springdemo.entity.TransactionToCoin;
import com.luv2code.springdemo.service.CryptoService;


@Controller
@RequestMapping("/crypto")
public class CryptoController {

	@Autowired
	private CryptoService cryptoService;
	
	@Value("#{txTypeOptions}")
	private Map<String, String> txTypeOptions;
	
	@Value("#{exchangeOptions}")
	private Map<String, String> exchangeOptions;

	@Value("#{cryptoOptions}")
	private Map<String, String> cryptoOptions;
	
	private TransactionToCoin transactionToCoin;

	@GetMapping("/list")
	public String listTransactions(Model theModel) {
		List<CryptoTransaction> theTransactions = cryptoService.getTransactions();
		
		theModel.addAttribute("transactions", theTransactions);
		
		calculate(theTransactions);
		
		theModel.addAttribute("coins", transactionToCoin.getOwnedCoins());
		
		return "list-transactions";
	}
	
	@GetMapping("/showFormForAddTransaction")
	public String showFormForAddTransaction(Model theModel) {
		CryptoTransaction cryptoTransaction = new CryptoTransaction();
		theModel.addAttribute("cryptoTransaction", cryptoTransaction);
		theModel.addAttribute("theTxTypeOptions", txTypeOptions);
		theModel.addAttribute("exchangeOptions", exchangeOptions);
		theModel.addAttribute("cryptoOptions", cryptoOptions);

		return "transaction-add-form";
	}
	
	@PostMapping("/saveCryptoTransaction")
	public String saveCryptoTx(@ModelAttribute("cryptoTransaction") CryptoTransaction cryptoTransaction) {
		cryptoService.saveCryptoTx(cryptoTransaction);
		return "redirect:/crypto/list";
	}
	
	private void calculate(List<CryptoTransaction> theTransactions) {
		transactionToCoin = new TransactionToCoin(); 
		transactionToCoin.setTransactions(theTransactions);
		transactionToCoin.calculate();
		transactionToCoin.print();
	}
}
