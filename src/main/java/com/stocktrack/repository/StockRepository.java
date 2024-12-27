package com.stocktrack.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stocktrack.entity.Stock;

public interface StockRepository extends JpaRepository<Stock, Long> {
}

