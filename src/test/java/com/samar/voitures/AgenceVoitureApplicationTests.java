package com.samar.voitures;

import java.util.Date;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.samar.voitures.entities.Marque;
import com.samar.voitures.entities.Voiture;
import com.samar.voitures.repos.VoitureRepository;

@SpringBootTest
class AgenceVoitureApplicationTests {

	@Autowired
	private VoitureRepository voitureRepository;
	
	@Test
	public void testCreateVoiture() {
		Voiture voit = new Voiture("Golf7",10001.500,new Date());
		voitureRepository.save(voit);
	}
	
	@Test
	public void testFindVoiture()
	{
		Voiture v = voitureRepository.findById(3L).get();
		System.out.println(v.getModeleVoiture());
	}
	
	@Test
	public void testUpdateVoiture()
	{
		Voiture v = voitureRepository.findById(1L).get();
		v.setPrixVoiture(1000.0);
		voitureRepository.save(v);
	}
	
	@Test
	public void testDeleteVoiture()
	{
		voitureRepository.deleteById(1L);;
	}

	@Test
	public void testListerTousVoitures()
	{
		List <Voiture> voit = voitureRepository.findAll();
		for (Voiture v : voit)
		{
			System.out.println(v.getModeleVoiture());
		}
	}
	
	 @Test
	 public void testFindByModeleVoiture()
	 {
		 List<Voiture> voits = voitureRepository.findByModeleVoiture("Golf7");
		 for (Voiture v : voits)
		 {
		 System.out.println(v.getModeleVoiture());
		 }
	 }
	 
	 @Test
	 public void testFindByModeleVoitureContains ()
	 {
		 List<Voiture> voits = voitureRepository.findByModeleVoitureContains("G");
		 for (Voiture v : voits)
		 {
		 System.out.println(v.getModeleVoiture());
		 } 
		 }
	 
	 @Test
	 public void findByModeleVoiturePrixVoiture()
	 {
		 List<Voiture> voits = voitureRepository.findByModeleVoiturePrixVoiture("Golf", 1000.0);
		 for (Voiture v : voits)
		 {
		 System.out.println(v.getModeleVoiture());
		 }
	 }
	 
	 @Test
	 public void testfindByMarque()
	 {
		 Marque marq = new Marque();
		 marq.setIdMarque(1L);
		 List<Voiture> voits = voitureRepository.findByMarque(marq);
		 for (Voiture v : voits)
		 {
		 System.out.println(v);
		 }
	 }
	 
	 @Test
	 public void testFindByMarqueIdMarque()
	 {
		 List<Voiture> voits = voitureRepository.findByMarqueIdMarque(1L);
		 for (Voiture v : voits)
		 {
		 System.out.println(v);
		 }
	  }
	 
	 @Test
	 public void testfindByOrderByNomProduitAsc()
	 {
		 List<Voiture> voits =
		 voitureRepository.findByOrderByModeleVoitureAsc();
		 for (Voiture v : voits)
		 {
		 System.out.println(v);
		 }
	 }
	 @Test
	 public void testTrierProduitsNomsPrix()
		 {
		 List<Voiture> voits = voitureRepository.trierVoituresModelesPrix();
		 for (Voiture v : voits)
		 {
		 System.out.println(v);
		 }
	 }


}


