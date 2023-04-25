package com.samar.voitures.resstcontrollers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.samar.voitures.entities.Marque;
import com.samar.voitures.service.MarqueService;

@RestController
@RequestMapping("/api/marques")
@CrossOrigin
public class MarqueRestController {
	@Autowired
	private MarqueService marqueService;
	
	@GetMapping
	List<Marque> getAllMarques() {
		return this.marqueService.getAllMarque();
	}
	
	@GetMapping("/{id}")
	Marque getMarque(@PathVariable("id") Long id) {
		return this.marqueService.getMarque(id);
	}
	
	@PostMapping
	Marque createNewMarque(@RequestBody Marque marque) {
		return this.marqueService.saveMarque(marque); 
	}
	
	@PutMapping("/{id}")
	Marque updateMarque(@PathVariable("id") Long id, @RequestBody Marque marque) {
		marque.setIdMarque(id);
		return this.marqueService.saveMarque(marque);
	}
	
	@DeleteMapping("/{id}")
	void deleteMarque(@PathVariable("id") Long id) {
		this.marqueService.deleteMarqueById(id);
	}
	
}
