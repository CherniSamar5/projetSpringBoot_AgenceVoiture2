package com.samar.voitures.entities;
import java.util.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;


import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.Entity;

@Entity
public class Voiture {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idVoiture;
	
	@NotNull
	@Size (min = 4,max = 15)
	private String modeleVoiture;
	
	@Min(value = 10)
	 @Max(value = 10000)
	private Double prixVoiture;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent
	private Date dateFabrication;
	
	@ManyToOne
    private Marque marque;
    

	public Voiture() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Voiture( String modeleVoiture, Double prixVoiture, Date dateFabrication) {
		super();
		this.modeleVoiture = modeleVoiture;
		this.prixVoiture = prixVoiture;
		this.dateFabrication = dateFabrication;
	}
	
	public Long getIdVoiture() {
		return idVoiture;
	}
	
	public void setIdVoiture(Long idVoiture) {
		this.idVoiture = idVoiture;
	}
	
	public String getModeleVoiture() {
		return modeleVoiture;
	}
	
	public void setModeleVoiture(String modeleVoiture) {
		this.modeleVoiture = modeleVoiture;
	}
	
	public Double getPrixVoiture() {
		return prixVoiture;
	}
	
	public void setPrixVoiture(Double prixVoiture) {
		this.prixVoiture = prixVoiture;
	}
	
	public Date getDateFabrication() {
		return dateFabrication;
	}
	
	public void setDateFabrication(Date dateFabrication) {
		this.dateFabrication = dateFabrication;
	}
	
	public Marque getMarque() {
		return marque;
	}
	
	public void setMarque(Marque marque) {
		this.marque = marque;
	}

	@Override
	public String toString() {
		return "Voiture [idVoiture=" + idVoiture + ", modeleVoiture=" + modeleVoiture + ", prixVoiture=" + prixVoiture
				+ ", dateFabrication=" + dateFabrication + ", marque=" + marque + "]";
	}
	
	
	
	
	

}
