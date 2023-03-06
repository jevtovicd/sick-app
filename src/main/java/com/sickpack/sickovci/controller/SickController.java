package com.sickpack.sickovci.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.sickpack.sickovci.model.Sickovac;
import com.sickpack.sickovci.repository.Repository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/sick")
@CrossOrigin
public class SickController {
	
	private final Repository repository;
	
	public SickController(Repository repository) {
		this.repository = repository;
	}
	
	@GetMapping("")
	public Iterable<Sickovac> findAllSikovci(){
		return repository.findAll();
	}
	
	@GetMapping("/id/{id}")
	public Sickovac findSikovacById(@PathVariable Integer id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PutMapping("/{id}")
	public void updateSickovac(@RequestBody Sickovac sickovac, @PathVariable Integer id) {
		if(!repository.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Sickovac not found");
		}
		repository.save(sickovac);
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("")
	public void createSikovac(@Valid @RequestBody Sickovac sickovac) {
		repository.save(sickovac);
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void deleteSickovacById(@PathVariable Integer id) {
		repository.deleteById(id);
	}

}
