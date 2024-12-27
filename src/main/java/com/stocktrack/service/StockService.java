package com.stocktrack.service;

import org.springframework.stereotype.Service;

import com.stocktrack.entity.Stock;
import com.stocktrack.repository.StockRepository;

import java.util.List;

@Service
public class StockService {
    private final StockRepository stockRepository;

    public StockService(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }

    public Stock getStockById(Long id) {
        return stockRepository.findById(id).orElseThrow(() -> new RuntimeException("Stock not found with id " + id));
    }

    public Stock saveStock(Stock stock) {
        return stockRepository.save(stock);
    }

    public Stock updateStock(Long id, Stock stockDetails) {
        Stock stock = getStockById(id);
        stock.setName(stockDetails.getName());
        stock.setTicker(stockDetails.getTicker());
        stock.setQuantity(stockDetails.getQuantity());
        stock.setBuyPrice(stockDetails.getBuyPrice());
        return stockRepository.save(stock);
    }

    public void deleteStock(Long id) {
        Stock stock = getStockById(id);
        stockRepository.delete(stock);
    }
}
