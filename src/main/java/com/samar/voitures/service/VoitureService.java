package com.samar.voitures.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.samar.voitures.entities.Marque;
import com.samar.voitures.entities.Voiture;

public interface VoitureService {
	Voiture saveVoiture(Voiture v);
	Voiture updateVoiture(Voiture v);
	void deleteVoiture(Voiture v);
	void deleteVoitureById(Long id);
	Voiture getVoiture(Long id);
	List<Voiture> getAllVoitures();
	Page<Voiture> getAllVoituresParPage(int page, int size);
	List<Voiture> findByModeleVoiture(String nom);
	List<Voiture> findByModeleVoitureContains(String nom);
	List<Voiture> findByModeleVoiturePrixVoiture (String nom, Double prix);
	List<Voiture> findByMarque (Marque marque);
	List<Voiture> findByMarqueIdMarque(Long id);

	

	}


