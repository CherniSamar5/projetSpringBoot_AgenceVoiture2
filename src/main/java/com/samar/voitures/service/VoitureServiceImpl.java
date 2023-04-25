package com.samar.voitures.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.samar.voitures.entities.Marque;
import com.samar.voitures.entities.Voiture;
import com.samar.voitures.repos.VoitureRepository;

@Service
public class VoitureServiceImpl implements VoitureService{

	@Autowired
	VoitureRepository voitureRepository;
	
	@Override
	public Voiture saveVoiture(Voiture v) {
		return voitureRepository.save(v);
	}

	@Override
	public Voiture updateVoiture(Voiture v) {
		return voitureRepository.save(v);

	}

	@Override
	public void deleteVoiture(Voiture v) {
		voitureRepository.delete(v);
		
	}

	@Override
	public void deleteVoitureById(Long id) {
		voitureRepository.deleteById(id);		
	}

	@Override
	public Voiture getVoiture(Long id) {
		return voitureRepository.findById(id).get();

	}

	@Override
	public List<Voiture> getAllVoitures() {
		return voitureRepository.findAll();

	}

	@Override
	public Page<Voiture> getAllVoituresParPage(int page, int size) {
		return voitureRepository.findAll(PageRequest.of(page, size));

	}

	@Override
	public List<Voiture> findByModeleVoiture(String nom) {
		return  voitureRepository.findByModeleVoiture(nom);

	}

	@Override
	public List<Voiture> findByModeleVoitureContains(String nom) {
		return  voitureRepository.findByModeleVoitureContains(nom);

	}

	@Override
	public List<Voiture> findByModeleVoiturePrixVoiture(String nom, Double prix) {
		return  voitureRepository.findByModeleVoiturePrixVoiture(nom,prix);
 
	}

	@Override
	public List<Voiture> findByMarque(Marque marque) {
		return  voitureRepository.findByMarque(marque);

	}

	@Override
	public List<Voiture> findByMarqueIdMarque(Long id) {
		return  voitureRepository.findByMarqueIdMarque(id);

	}
	
	
}
