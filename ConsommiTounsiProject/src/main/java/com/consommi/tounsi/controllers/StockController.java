package com.consommi.tounsi.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.consommi.tounsi.exceptions.ResourceNotFoundException;
import com.consommi.tounsi.models.Post;
import com.consommi.tounsi.models.Product;
import com.consommi.tounsi.models.Stock;
import com.consommi.tounsi.models.StockId;
import com.consommi.tounsi.models.Supplier;
import com.consommi.tounsi.models.User;
import com.consommi.tounsi.repository.PostRepository;
import com.consommi.tounsi.repository.ProductRepository;
import com.consommi.tounsi.repository.StockRepository;
import com.consommi.tounsi.repository.SupplierRepository;
import com.consommi.tounsi.repository.UserRepository;

@RestController
@RequestMapping("/api/v1")
public class StockController {

	@Autowired
	StockRepository agent;
	@Autowired
	SupplierRepository agentSupplier;
	@Autowired
	ProductRepository agentProduct;
	@GetMapping("/stock")
	public List<Stock> getAllStocks() {
		return agent.findAll();
	}
	@GetMapping("/stock/{id}")
	public ResponseEntity<Stock> getStockById(@PathVariable(value = "id") Long stockId)
			throws ResourceNotFoundException {
		Stock stock = agent.findById(stockId)
				.orElseThrow(() -> new ResourceNotFoundException("stock not found for this id :: " + stockId));
		return ResponseEntity.ok().body(stock);
	}

	@PostMapping("/stock/{supplierid}/{productid}")
	public Stock createStock(@Valid @RequestBody Stock stock,@PathVariable(value = "supplierid")
	Long supplierId,@PathVariable(value = "productid") Long productId) throws ResourceNotFoundException {
		Supplier supplier = agentSupplier.findById(supplierId).orElseThrow(() -> new ResourceNotFoundException("Supplier not found for this id :: " + supplierId));
		Product product = agentProduct.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + productId));
		stock.setStockId(new StockId(supplierId, productId));
		stock.setProduct(product);
		stock.setSupplier(supplier);
		return agent.save(stock);
	}

	@PutMapping("/stock/{id}")
	public ResponseEntity<Stock> updateStock(@PathVariable(value = "id") Long stockId,
			@Valid @RequestBody Stock stockDetails) throws ResourceNotFoundException {
		Stock stock = agent.findById(stockId)
				.orElseThrow(() -> new ResourceNotFoundException("stock not found for this id :: " + stockId));
		final Stock updatedstock = agent.save(stock);
		return ResponseEntity.ok(updatedstock);
	}
	@DeleteMapping("/stock/{id}")
	public Map<String, Boolean> deleteStock(@PathVariable(value = "id") Long stockId)
			throws ResourceNotFoundException {
		Stock stock = agent.findById(stockId)
				.orElseThrow(() -> new ResourceNotFoundException("stock not found for this id :: " + stockId));
		agent.delete(stock);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	@GetMapping("/stockByProductName/{nomProd}")
	public ResponseEntity<List<Stock>> getStockByNomProd(@PathVariable(value = "nomProd") String nomProd)
			throws ResourceNotFoundException {
		List<Stock> stock = agent.findByStockName(nomProd)
				.orElse(null);
		return ResponseEntity.ok().body(stock);
	}
	@GetMapping("/stockByProductAndSupplier/{productid}/{supplierid}")
	public ResponseEntity<Stock> getStockByProductAndSupplier(@PathVariable(value = "productid") String productid,@PathVariable(value = "supplierid") String supplierid)
			throws ResourceNotFoundException {
		Stock stock = agent.findByProductIdAndSuppliedId(productid, supplierid)
				.orElse(null);
		return ResponseEntity.ok().body(stock);
	}
	
	@GetMapping("/stockBySupplier/{supplierid}")
	public ResponseEntity <List<Stock>> getStockBySupplier(@PathVariable(value = "supplierid") String supplierid)
			throws ResourceNotFoundException {
		List<Stock>  stocks = agent.findBySuppliedId(supplierid)
				.orElse(null);
		return ResponseEntity.ok().body(stocks);
	}
}
