package com.apori.publicationservice.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.apori.publicationservice.model.Publication;

public interface Publicationservice {
	
	//Liste des Publications
	List<Publication> getPublications();
	
	//Ajouter une publication
	void addPublication(Publication publication);

}
