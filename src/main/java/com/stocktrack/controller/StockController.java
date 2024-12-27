package com.stocktrack.controller;
import java.util.List;
import org.springframework.web.bind.annotation.*;
import com.stocktrack.entity.Stock;
import com.stocktrack.service.StockService;



@RestController
@RequestMapping("/api/stocks")
@CrossOrigin(origins = "http://localhost:3000") // Adjust based on frontend URL
public class StockController {
    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping
    public List<Stock> getAllStocks() {
        return stockService.getAllStocks();
    }

    @GetMapping("/{id}")
    public Stock getStockById(@PathVariable Long id) {
        return stockService.getStockById(id);
    }

    @PostMapping
    public Stock addStock(@RequestBody Stock stock) {
        return stockService.saveStock(stock);
    }

    @PutMapping("/{id}")
    public Stock updateStock(@PathVariable Long id, @RequestBody Stock stockDetails) {
        return stockService.updateStock(id, stockDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteStock(@PathVariable Long id) {
        stockService.deleteStock(id);
    }
}
