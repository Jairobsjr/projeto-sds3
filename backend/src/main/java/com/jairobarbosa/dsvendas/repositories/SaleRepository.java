package com.jairobarbosa.dsvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jairobarbosa.dsvendas.entities.Sale;

public interface SaleRepository extends JpaRepository<Sale, Long> {

}
