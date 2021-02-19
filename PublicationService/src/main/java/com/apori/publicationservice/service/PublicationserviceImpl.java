package com.apori.publicationservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.apori.publicationservice.dao.PublicationDAO;
import com.apori.publicationservice.model.Publication;

@Service
public class PublicationserviceImpl implements Publicationservice{
	
	@Autowired
	private PublicationDAO publicationDAO;
	
	//Liste des Publications
	public List<Publication> getPublications(){
		List<Publication> PublicationList = publicationDAO.findAll();
		if(!PublicationList.isEmpty()) {
			return PublicationList;
		}else {
			return null;
		}
	}

	//Ajouter une publication
	public void addPublication(Publication publication){
		publicationDAO.save(publication);
	}

}
