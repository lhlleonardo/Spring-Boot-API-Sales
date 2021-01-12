package com.lhleonardo.apisales.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
}
