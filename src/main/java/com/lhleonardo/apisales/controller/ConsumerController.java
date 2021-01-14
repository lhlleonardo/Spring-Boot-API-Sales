package com.lhleonardo.apisales.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lhleonardo.apisales.entity.Consumer;
import com.lhleonardo.apisales.repository.ConsumerRepository;

@RestController
public class ConsumerController {
	
	@Autowired
	private ConsumerRepository _consumerRepository;
	
    @RequestMapping(value = "/consumer", method = RequestMethod.GET)
    public List<Consumer> Get() {
        return _consumerRepository.findAll();
    }
}
