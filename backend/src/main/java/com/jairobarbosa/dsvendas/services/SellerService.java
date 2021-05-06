package com.jairobarbosa.dsvendas.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jairobarbosa.dsvendas.dto.SellerDTO;
import com.jairobarbosa.dsvendas.entities.Seller;
import com.jairobarbosa.dsvendas.repositories.SellerRepository;

@Service
public class SellerService {
	
	@Autowired
	private SellerRepository repository;
	
	public List<SellerDTO> findAll() {
		List<Seller> result = repository.findAll();
		return result.stream().map(entity -> new SellerDTO(entity)).collect(Collectors.toList());
	}

}
