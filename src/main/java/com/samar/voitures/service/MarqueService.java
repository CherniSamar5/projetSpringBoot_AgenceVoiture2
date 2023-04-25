package com.samar.voitures.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.samar.voitures.entities.Marque;


public interface MarqueService {
	
	Marque saveMarque(Marque v);
	Marque updateMarque(Marque v);
	void deleteMarque(Marque v);
	void deleteMarqueById(Long id);
	Marque getMarque(Long id);
	List<Marque> getAllMarque();
	Page<Marque> getAllMarquesParPage(int page, int size);

}
