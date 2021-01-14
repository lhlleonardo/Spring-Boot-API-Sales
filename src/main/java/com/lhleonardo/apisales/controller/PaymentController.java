package com.lhleonardo.apisales.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lhleonardo.apisales.entity.Payment;
import com.lhleonardo.apisales.repository.PaymentRepository;

@RestController
public class PaymentController {

	@Autowired
	private PaymentRepository _paymentRepository;
	
    @RequestMapping(value = "/payment", method = RequestMethod.GET)
    public List<Payment> Get() {
        return _paymentRepository.findAll();
    }
}
