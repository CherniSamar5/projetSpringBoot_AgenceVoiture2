package com.samar.voitures.controllers;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.samar.voitures.entities.Marque;
import com.samar.voitures.entities.Voiture;
import com.samar.voitures.service.MarqueService;
import com.samar.voitures.service.VoitureService;

@Controller
public class VoitureController {
	

	@Autowired
	VoitureService voitureService;
	
	@Autowired
	MarqueService marqueService;
	
	@RequestMapping("/showCreateVoiture")
	public String showCreate(ModelMap modelMap)
	{
	modelMap.addAttribute("voiture", new Voiture());
	modelMap.addAttribute("mode", "new");
	return "formVoiture";
	}

	
	@RequestMapping("/saveVoiture")
	public String saveProduit(@Valid Voiture voiture,
			 BindingResult bindingResult)
			{
			if (bindingResult.hasErrors()) return "formVoiture";

			voitureService.saveVoiture(voiture);
			return "formVoiture";
			}

	
	@RequestMapping("/ListeVoitures")
	public String listeVoitures(ModelMap modelMap,
	@RequestParam (name="page",defaultValue = "0") int page,
	@RequestParam (name="size", defaultValue = "2") int size)
	{
		Page<Voiture> voits = voitureService.getAllVoituresParPage(page, size);
		modelMap.addAttribute("voitures", voits);
		modelMap.addAttribute("pages", new int[voits.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		return "listeVoitures";
	}
	@RequestMapping("/supprimerVoiture")
	public String supprimerProduit(@RequestParam("id") Long id,
	ModelMap modelMap,
	@RequestParam (name="page",defaultValue = "0") int page,
	@RequestParam (name="size", defaultValue = "2") int size)
	{
		voitureService.deleteVoitureById(id);
		Page<Voiture> prods = voitureService.getAllVoituresParPage(page,
		size);
		modelMap.addAttribute("voitures", prods);
		modelMap.addAttribute("pages", new int[prods.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "listeVoitures";
	}
	@RequestMapping("/modifierVoiture")
	public String editerProduit(@RequestParam("id") Long id,ModelMap modelMap)
	{
		Voiture v = voitureService.getVoiture(id);
		modelMap.addAttribute("voiture", v);
		modelMap.addAttribute("mode", "edit");
		return "formVoiture";
	}

	@RequestMapping("/updateVoiture")
	public String updateVoiture(@ModelAttribute("voiture") Voiture voiture,
								@RequestParam("date") String date,
			                    ModelMap modelMap) throws ParseException 
	{
		
		//conversion de la date 
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateFabrication = dateformat.parse(String.valueOf(date));
        voiture.setDateFabrication(dateFabrication);
        
		  voitureService.updateVoiture(voiture);
		  Page<Voiture> voits = voitureService.getAllVoituresParPage(0, 2);
		  modelMap.addAttribute("voitures", voits);	
		  modelMap.addAttribute("pages", new int[voits.getTotalPages()]);

		
		return "listeVoitures";
	}
	}


