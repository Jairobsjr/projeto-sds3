package com.jairobarbosa.dsvendas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jairobarbosa.dsvendas.dto.SaleDTO;
import com.jairobarbosa.dsvendas.dto.SaleSuccessDTO;
import com.jairobarbosa.dsvendas.dto.SaleSumDTO;
import com.jairobarbosa.dsvendas.services.SaleService;

@RestController
@RequestMapping("/sales")
public class SaleController {
	
	@Autowired
	private SaleService service;
	
	@GetMapping
	public ResponseEntity<Page<SaleDTO>> findAll(Pageable pageable) {
		Page<SaleDTO> list = service.findAll(pageable);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/amount-by-seller")
	public ResponseEntity<List<SaleSumDTO>> amountGroupedSeller() {
		List<SaleSumDTO> list = service.amountGroupedSeller();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/success-by-seller")
	public ResponseEntity<List<SaleSuccessDTO>> sucessGroupedSeller() {
		List<SaleSuccessDTO> list = service.successGroupedSeller();
		return ResponseEntity.ok(list);
	}
}