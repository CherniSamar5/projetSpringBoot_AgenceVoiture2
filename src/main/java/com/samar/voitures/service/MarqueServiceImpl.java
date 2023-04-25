package com.samar.voitures.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.samar.voitures.entities.Marque;
import com.samar.voitures.repos.MarqueRepository;

@Service
public class MarqueServiceImpl implements MarqueService {

	@Autowired
	MarqueRepository marqueRepository; 
	
	@Override
	public Marque saveMarque(Marque v) {
		return marqueRepository.save(v);
	}

	@Override
	public Marque updateMarque(Marque v) {
		return marqueRepository.save(v);

	}

	@Override
	public void deleteMarque(Marque v) {
		marqueRepository.delete(v);		
		
	}

	@Override
	public void deleteMarqueById(Long id) {
		marqueRepository.deleteById(id);		
	}

	@Override
	public Marque getMarque(Long id) {
		return marqueRepository.findById(id).get();

	}

	@Override
	public List<Marque> getAllMarque() {
		return marqueRepository.findAll();

	}

	@Override
	public Page<Marque> getAllMarquesParPage(int page, int size) {
		return marqueRepository.findAll(PageRequest.of(page, size));
		
	}

}
