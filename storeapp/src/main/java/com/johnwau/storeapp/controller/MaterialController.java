package com.johnwau.storeapp.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.johnwau.storeapp.entity.Materials;
import com.johnwau.storeapp.repository.MaterialJpaRepository;

@RestController
@RequestMapping("/materials")
public class MaterialController {
	@Autowired
	private MaterialJpaRepository materialJpaRepository;
	
	@GetMapping(value="/all")
	public List<Materials> findAll(){ 
		
		return materialJpaRepository.findAll();
		
		
	}
	
	@GetMapping (value= "/{name}")
	public Materials findByName(@PathVariable final String name ) {
		return materialJpaRepository.findByName(name);
		
	}
	
	@PostMapping(value= "/load")
	public Materials load(@RequestBody final Materials materials) {
		materialJpaRepository.save(materials);
		return materialJpaRepository.findByName(materials.getName());
		
	}

}
