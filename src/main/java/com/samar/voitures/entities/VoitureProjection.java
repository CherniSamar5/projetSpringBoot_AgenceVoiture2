package com.samar.voitures.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "modeleVoit", types = { Voiture.class })
public interface VoitureProjection {

	public String getModeleVoiture();
	

}
