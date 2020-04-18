package com.app.aforo255.historical.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.app.aforo255.historical.model.entity.Transaction;
import com.app.aforo255.historical.service.ITransactionService;

@RestController
public class HistoricalController {

	@Autowired
	private ITransactionService transaction;

	@GetMapping("/transaction/{accountId}")
	public ResponseEntity<?> obtenerTansacciones(@PathVariable Integer accountId) {
		Iterable<Transaction> Itransaction = transaction.findByAccountId(accountId);
		return ResponseEntity.ok(Itransaction);
	}

	@GetMapping("/listar")
	public List<Transaction> listar() {
		return (List<Transaction>) transaction.findAdll();
	}

}
