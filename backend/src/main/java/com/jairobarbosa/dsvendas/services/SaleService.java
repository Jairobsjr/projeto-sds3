package com.jairobarbosa.dsvendas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jairobarbosa.dsvendas.dto.SaleDTO;
import com.jairobarbosa.dsvendas.dto.SaleSuccessDTO;
import com.jairobarbosa.dsvendas.dto.SaleSumDTO;
import com.jairobarbosa.dsvendas.entities.Sale;
import com.jairobarbosa.dsvendas.repositories.SaleRepository;
import com.jairobarbosa.dsvendas.repositories.SellerRepository;

@Service
public class SaleService {
	
	@Autowired
	private SaleRepository repository;
	
	@Autowired
	private SellerRepository sellerRepository;
	
	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pageable) {
		sellerRepository.findAll();
		Page<Sale> result = repository.findAll(pageable);
		return result.map(entity -> new SaleDTO(entity));
	}
	
	@Transactional(readOnly = true)
	public	List<SaleSumDTO> amountGroupedSeller() {
		return repository.amountGroupedSeller();
	}
	
	@Transactional(readOnly = true)
	public	List<SaleSuccessDTO> successGroupedSeller() {
		return repository.successGroupedSeller();
	}

}
