package com.apori.publicationservice.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.apori.publicationservice.dao.PublicationDAO;
import com.apori.publicationservice.model.Publication;

@RestController
@RequestMapping(path = "/Publication")
public class PublicationController {
	
	@Autowired
	private PublicationDAO publicationDAO;

// Retourne l'ensemble des publication
	@GetMapping(path = "/Allpublications")
	public @ResponseBody Iterable<Publication> getAllPublication(HttpServletRequest request,HttpServletResponse response){
		
		List<Publication> publicationlist = (List<Publication>) publicationDAO.findAll();
		if (publicationlist.size()!=0) {
			return publicationlist;
		}else {
			return null;
		}
	}
	
// Mise à jour du contenu textuel de la publication
	
	@PutMapping(path = "/updateContent/{idPublication}/{title}")
	public ResponseEntity<HttpStatus> updateTitle(HttpServletRequest request,
			@PathVariable Integer idPublication,
			@PathVariable String title
			){
		Optional<Publication> retrievedPublication = publicationDAO.findById(idPublication);
		if(retrievedPublication.isPresent()) {
			retrievedPublication.get().setTitle(title);
			publicationDAO.save(retrievedPublication.get());
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<HttpStatus>(HttpStatus.NOT_MODIFIED);
		}
	}
	
//Mise à jour du titre de la publication
	
	@PutMapping(path = "/updateContent/{idPublication}/{content}")
	public ResponseEntity<HttpStatus> updateContent(HttpServletRequest request,
			@PathVariable Integer idPublication,
			@PathVariable String content
			){
		Optional<Publication> retrievedPublication = publicationDAO.findById(idPublication);
		if(retrievedPublication.isPresent()) {
			retrievedPublication.get().setContent(content);
			publicationDAO.save(retrievedPublication.get());
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<HttpStatus>(HttpStatus.NOT_MODIFIED);
		}
	}

}
