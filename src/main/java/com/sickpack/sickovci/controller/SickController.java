package com.sickpack.sickovci.controller;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;
import com.sickpack.sickovci.model.Sickovac;
import com.sickpack.sickovci.repository.Repository;

@RestController
@RequestMapping("/api/sick")
@CrossOrigin
public class SickController {
	
	private final Repository repository;
	
	public SickController(Repository repository) {
		this.repository = repository;
	}
	
	@GetMapping("")
	public ModelAndView homePage(Model model){
		model.addAttribute("logo", "https://static1.srcdn.com/wordpress/wp-content/uploads/2009/07/Superman-Returns-Smallville-Chest-Logo.jpg");
		return new ModelAndView("home");
	}
	
	@GetMapping("/list")
	public ModelAndView findAllSikovci(Model model){
		Iterable<Sickovac> allSikovci = repository.findAll();
		model.addAttribute("allSikovci", allSikovci);
		return new ModelAndView("sickovci");
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
	
	@GetMapping("/create")
	public ModelAndView createSickovac(Model model) {
		model.addAttribute("sickovac", new Sickovac());
		return new ModelAndView("create");
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("")
	public ModelAndView createSikovac(@ModelAttribute Sickovac sickovac) {
		repository.save(sickovac);
		ModelAndView model = new ModelAndView("sickovci");
		Iterable<Sickovac> allSikovci = repository.findAll();
		model.addObject("allSikovci", allSikovci);
		return model;
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void deleteSickovacById(@PathVariable Integer id) {
		repository.deleteById(id);
	}

}
