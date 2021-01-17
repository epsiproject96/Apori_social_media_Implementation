package com.apori.commentaireservice.controller;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.apori.commentaireservice.model.Commentaire;
import com.apori.commentaireservice.model.CommentaireResponse;
import com.apori.commentaireservice.service.CommentaireService;
import com.google.common.reflect.TypeToken;

@RestController
@RequestMapping(path = "Publications/{idPublication}/Commentaires")
public class CommentaireController {
	
	@Autowired
	private CommentaireService commentaireService;
	
//	Retourne les commentaires d'une publication
	@GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE} )
	public List<CommentaireResponse> PublicationCommentaires(Integer idPublication) {
		List<CommentaireResponse> returnValue = new ArrayList<>();
		
		List<Commentaire> CommentairesList = commentaireService.getPublicationComments(idPublication);
		
		if(CommentairesList == null || CommentairesList.isEmpty() ) {
			return returnValue;
		}
		else {
			Type listType = new TypeToken<List<CommentaireResponse>>(){}.getType();
			
//			modelMapper modelMapper = new ModelMapper();
//			
//			returnValue = modelMapper().map(CommentairesList, listType);

			return returnValue;
		}
	}
	
}









