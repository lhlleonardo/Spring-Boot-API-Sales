package com.lhleonardo.apisales.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lhleonardo.apisales.entity.Product;
import com.lhleonardo.apisales.repository.ProductRepository;

@RestController
public class ProductController {

	@Autowired
	private ProductRepository _productRepository;
	
    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public List<Product> Get() {
        return _productRepository.findAll();
    }
    
    @RequestMapping(value = "/product/{productId}", method = RequestMethod.GET)
    public ResponseEntity<Product> GetById(@PathVariable(value = "productId") Long productId)
    {
    	Optional<Product> product = _productRepository.findById(productId);
        if(product.isPresent())
            return new ResponseEntity<Product>(product.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @RequestMapping(value = "/product", method =  RequestMethod.POST)
    public Product Post(@Validated @RequestBody Product product)
    {
        return _productRepository.save(product);
    }
    
    @RequestMapping(value = "/product/{productId}", method =  RequestMethod.PUT)
    public ResponseEntity<Product> Put(@PathVariable(value = "productId") long productId, @Validated @RequestBody Product newProduct)
    {
        Optional<Product> oldProduct = _productRepository.findById(productId);
        if(oldProduct.isPresent()){
        	Product product = oldProduct.get();
        	
        	product.setName(newProduct.getName());
        	product.setDescription(newProduct.getDescription());
        	product.setBarcode(newProduct.getBarcode());
        	product.setManufacturer(newProduct.getManufacturer());
        	product.setUnitPrice(newProduct.getUnitPrice());
        	
        	_productRepository.save(product);
        	
            return new ResponseEntity<Product>(product, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @RequestMapping(value = "/product/{productId}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "productId") long productId)
    {
        Optional<Product> product = _productRepository.findById(productId);
        if(product.isPresent()){
        	_productRepository.delete(product.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}