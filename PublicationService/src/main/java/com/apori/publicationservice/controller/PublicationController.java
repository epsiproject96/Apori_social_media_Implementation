package com.apori.publicationservice.controller;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.apori.publicationservice.model.Publication;
import com.apori.publicationservice.model.PublicationResponse;
import com.apori.publicationservice.service.Publicationservice;
import com.google.common.reflect.TypeToken;

@RestController
@RequestMapping(path = "/User/{idUser}/Publications")
public class PublicationController {
	
	@Autowired
	private Publicationservice publicationservice;

// Retourne l'ensemble des publications
	@GetMapping(path = "/Allpublication")
	public @ResponseBody List<PublicationResponse> getPublications(HttpServletRequest request,HttpServletResponse response){
		List<PublicationResponse> RetrievedList = new ArrayList<>();
		List<Publication> PublicationList = publicationservice.getPublications();
		
 		if(PublicationList==null||PublicationList.isEmpty()) {
			return RetrievedList;
		}else {
			Type listType = new TypeToken<List<PublicationResponse>>(){}.getType();	
			ModelMapper modelMapper = new ModelMapper();
			RetrievedList = modelMapper.map(PublicationList,listType);
			return RetrievedList;
	}
}
	
	
// Ajouter une publication
	@PostMapping(path = "/addPublication/")
	@ResponseBody
	ResponseEntity<HttpStatus> addPublication(HttpServletRequest request,@RequestBody Publication publication){
		publicationservice.addPublication(publication);
		return new  ResponseEntity<>(HttpStatus.CREATED);
	}
	
// Mise à jour du contenu textuel de la publication
	
//	@PutMapping(path = "/updateContent/{idPublication}/{title}")
//	public ResponseEntity<HttpStatus> updateTitle(HttpServletRequest request,
//			@PathVariable Integer idPublication,
//			@PathVariable String title
//			){
//		Optional<Publication> retrievedPublication = publicationDAO.findById(idPublication);
//		if(retrievedPublication.isPresent()) {
//			retrievedPublication.get().setTitle(title);
//			publicationDAO.save(retrievedPublication.get());
//			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
//		}
//		else {
//			return new ResponseEntity<HttpStatus>(HttpStatus.NOT_MODIFIED);
//		}
//	}
	
	
	
//Mise à jour du titre de la publication
	
//	@PutMapping(path = "/updateContent/{idPublication}/{content}")
//	public ResponseEntity<HttpStatus> updateContent(HttpServletRequest request,
//			@PathVariable Integer idPublication,
//			@PathVariable String content
//			){
//		Optional<Publication> retrievedPublication = publicationDAO.findById(idPublication);
//		if(retrievedPublication.isPresent()) {
//			retrievedPublication.get().setContent(content);
//			publicationDAO.save(retrievedPublication.get());
//			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
//		}
//		else {
//			return new ResponseEntity<HttpStatus>(HttpStatus.NOT_MODIFIED);
//		}
//	}
	
	
//Ajouter une publication
	
	
	
//Supprimer une publication
	

}
