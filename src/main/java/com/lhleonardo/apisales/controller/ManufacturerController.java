package com.lhleonardo.apisales.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lhleonardo.apisales.entity.Manufacturer;
import com.lhleonardo.apisales.repository.ManufacturerRepository;

@RestController
public class ManufacturerController {

	@Autowired
	private ManufacturerRepository _manufacturerRepository;
	
    @RequestMapping(value = "/manufacturer", method = RequestMethod.GET)
    public List<Manufacturer> Get() {
        return _manufacturerRepository.findAll();
    }
    
}