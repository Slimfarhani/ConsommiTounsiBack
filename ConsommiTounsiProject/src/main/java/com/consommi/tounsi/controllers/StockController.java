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

import jdk.nashorn.internal.runtime.FindProperty;

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

	@GetMapping("/stockbysupplier/{userid}")
	public ResponseEntity<List<Stock>> getStockBySupplierId(@PathVariable(value = "userid") Long supplierId)
			throws ResourceNotFoundException {
		List<Stock> stocks = agent.findBySuppliedId(supplierId).orElse(null);
		return ResponseEntity.ok().body(stocks);
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
	@PostMapping("/stockfornewproduct")
	public Stock createStockForNewProduct(@Valid @RequestBody Stock stock) throws ResourceNotFoundException {
		Supplier supplier = agentSupplier.findById(stock.getSupplier().getUserId()).orElseThrow(() -> new ResourceNotFoundException("Supplier not found for this id :: " + stock.getSupplier().getUserId()));
		Product product = agentProduct.findById(stock.getProduct().getProductId()).orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + stock.getProduct().getProductId()));
		stock.setStockId(new StockId(stock.getSupplier().getUserId(), stock.getProduct().getProductId()));
		stock.setProduct(product);
		stock.setSupplier(supplier);
		return agent.save(stock);
	}
	@PostMapping("/updatestockfromcart")
	public List<Stock> updateStockFromCart(@Valid @RequestBody List<Stock> stocks) throws ResourceNotFoundException {
		for (Stock stockfromcart : stocks) {
			Stock stock=agent.findByProductIdAndSuppliedId(stockfromcart.getProduct().getProductId(), stockfromcart.getSupplier().getUserId()).orElse(null);
			if (stock!=null) {
				stock.setPrice(stockfromcart.getPrice());
				stock.setQuantity(stockfromcart.getQuantity());
				agent.save(stock);
			}
			else {
				Supplier supplier = agentSupplier.findById(stockfromcart.getSupplier().getUserId()).orElse(null);
				Product product = agentProduct.findById(stockfromcart.getProduct().getProductId()).orElse(null);
				stockfromcart.setSupplier(supplier);
				stockfromcart.setProduct(product);
				StockId stockId=new StockId();
				stockId.setProductId(stockfromcart.getProduct().getProductId());
				stockId.setSupplierId(stockfromcart.getSupplier().getUserId());
				stockfromcart.setStockId(stockId);
				agent.save(stockfromcart);
			}
		}
		return agent.findAll();
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
	@DeleteMapping("/deletestockbysupplier/{supplierid}/{productid}")
	public Map<String, Boolean> deleteStockBySupplier(@PathVariable(value = "supplierid") Long supplierId,@PathVariable(value = "productid") Long productId)
			throws ResourceNotFoundException {
		Stock stock = agent.findByProductIdAndSuppliedId(productId, supplierId).orElse(null);
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
	public ResponseEntity<Stock> getStockByProductAndSupplier(@PathVariable(value = "productid") long productid,@PathVariable(value = "supplierid") long supplierid)
			throws ResourceNotFoundException {
		Stock stock = agent.findByProductIdAndSuppliedId(productid, supplierid)
				.orElse(null);
		return ResponseEntity.ok().body(stock);
	}
	
	@GetMapping("/stockBySupplier/{supplierid}")
	public ResponseEntity <List<Stock>> getStockBySupplier(@PathVariable(value = "supplierid") long supplierid)
			throws ResourceNotFoundException {
		List<Stock>  stocks = agent.findBySuppliedId(supplierid)
				.orElse(null);
		return ResponseEntity.ok().body(stocks);
	}
}
