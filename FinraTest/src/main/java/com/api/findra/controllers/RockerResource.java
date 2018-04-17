package com.api.findra.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.api.finra.model.Rockers;
import com.api.finra.repository.RockerRepository;

@RestController
@RequestMapping("/api")
public class RockerResource {
	public static final Logger logger = LoggerFactory.getLogger(RockerResource.class);
	@Autowired
	private RockerRepository rockerRepository;
	
	@GetMapping(value = "/rockers")
	public List<Rockers> getAllRockers(){
		return rockerRepository.findAll();
	}
	
	@GetMapping("/rockers/{id}")
	public Rockers retrieveStudent(@PathVariable long id) {
		Optional<Rockers> rocker = rockerRepository.findById(id);
				
		return rocker.get();
	}
	
	@DeleteMapping("/rockers/{id}")
	public void deleteRocker(@PathVariable long id) {
		rockerRepository.deleteById(id);
	}

	@PostMapping("/rockers")
	public ResponseEntity<Object> createRocker(@RequestBody Rockers rocker) {
		Rockers savedRocker = rockerRepository.save(rocker);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedRocker.getId()).toUri();

		return ResponseEntity.created(location).build();

	}
	
	@PutMapping("/rockers/{id}")
	public ResponseEntity<Object> updateRocker(@RequestBody Rockers rocker, @PathVariable long id) {

		Optional<Rockers> rockerOptional = rockerRepository.findById(id);

		if (!rockerOptional.isPresent())
			return ResponseEntity.notFound().build();

		rocker.setId(id);
		
		rockerRepository.save(rocker);

		return ResponseEntity.noContent().build();
	}
	
	
}
