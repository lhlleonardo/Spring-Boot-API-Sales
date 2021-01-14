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

import com.lhleonardo.apisales.entity.OrderSales;
import com.lhleonardo.apisales.entity.Product;
import com.lhleonardo.apisales.repository.OrderSalesRepository;

import enums.OrderStatus;

@RestController
public class OrderSalesController {
	
	@Autowired
	private OrderSalesRepository _orderSalesRepository;
	
    @RequestMapping(value = "/ordersales", method = RequestMethod.GET)
    public List<OrderSales> Get() {
        return _orderSalesRepository.findAll();
    }
    
    @RequestMapping(value = "/ordersales", method =  RequestMethod.POST)
    public OrderSales Post(@Validated @RequestBody OrderSales orderSales)
    {
    	orderSales.setStatus(OrderStatus.PENDING);
        return _orderSalesRepository.save(orderSales);
    }
    
    @RequestMapping(value = "/cancelordersales/{orderSalesId}", method =  RequestMethod.PUT)
    public ResponseEntity<OrderSales> Put(@PathVariable(value = "orderSalesId") long orderSalesId, @Validated @RequestBody OrderSales newOrderSales)
    {
        Optional<OrderSales> oldOrderSales = _orderSalesRepository.findById(orderSalesId);
        if(oldOrderSales.isPresent()){
        	OrderSales orderSales = oldOrderSales.get();
        	
        	orderSales.setStatus(OrderStatus.CANCELED);
        	
        	_orderSalesRepository.save(orderSales);
        	
            return new ResponseEntity<OrderSales>(orderSales, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @RequestMapping(value = "/confirmordersales/{orderSalesId}", method =  RequestMethod.PUT)
    public ResponseEntity<OrderSales> Put1(@PathVariable(value = "orderSalesId") long orderSalesId, @Validated @RequestBody OrderSales newOrderSales)
    {
        Optional<OrderSales> oldOrderSales = _orderSalesRepository.findById(orderSalesId);
        if(oldOrderSales.isPresent()){
        	OrderSales orderSales = oldOrderSales.get();
        	
        	orderSales.setStatus(OrderStatus.CONFIRMED);
        	
        	_orderSalesRepository.save(orderSales);
        	
            return new ResponseEntity<OrderSales>(orderSales, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
