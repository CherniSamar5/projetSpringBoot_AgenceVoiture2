package com.samar.voitures.repos;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import com.samar.voitures.entities.Marque;
import com.samar.voitures.entities.Voiture;

//@RepositoryRestController("rest_Voitures")
public interface VoitureRepository extends JpaRepository <Voiture, Long>{
	List<Voiture> findByModeleVoiture(String nom);
	List<Voiture> findByModeleVoitureContains(String nom);
	@Query("select v from Voiture v where v.modeleVoiture like %?1 and v.prixVoiture > ?2")
	List<Voiture> findByModeleVoiturePrixVoiture (@Param("nom") String nom,@Param("prix") Double prix);
	@Query("select v from Voiture v where v.marque = ?1")
	List<Voiture> findByMarque(Marque marque);
	List<Voiture> findByMarqueIdMarque(Long id);
	List<Voiture> findByOrderByModeleVoitureAsc();
	
	@Query("select v from Voiture v order by v.modeleVoiture ASC, v.prixVoiture DESC")
	List<Voiture> trierVoituresModelesPrix ();

	

}
