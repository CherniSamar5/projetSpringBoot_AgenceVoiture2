package com.samar.voitures.repos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import com.samar.voitures.entities.Marque;

//@RepositoryRestController(path = "rest_marques")
public interface MarqueRepository extends JpaRepository<Marque, Long>{

}
