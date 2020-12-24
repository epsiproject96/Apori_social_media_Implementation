package com.apori.commentaireservice.controller;

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

import com.apori.commentaireservice.dao.CommentaireDAO;
import com.apori.commentaireservice.model.Commentaire;

@RestController
@RequestMapping(path = "/Commentaire")
public class CommentaireController {
	
	@Autowired
	private CommentaireDAO commentaireDAO;
	
//	Retourne l'ensemble des commentaires
	
	@GetMapping(path = "/AllCommentaires")
	public @ResponseBody Iterable<Commentaire> getAllCommentaire(HttpServletRequest request,HttpServletResponse response){
		List<Commentaire> CommentaireList = (List<Commentaire>) commentaireDAO.findAll();
		if(CommentaireList.size()!=0) {
			return CommentaireList;
		}
		else {
			return null;
		}
     }
	
//	Mise à jour d'un commentaire 
	@PutMapping(path = "/updateCommentaire/{idCommentaire}/{content}")
	public ResponseEntity<HttpStatus> updateCommentaire(HttpServletRequest request,@PathVariable Integer idCommentaire ,@PathVariable String content){
		
		Optional<Commentaire> retrievedCommentaire = commentaireDAO.findById(idCommentaire);
		if(retrievedCommentaire.isPresent()) {
			
			retrievedCommentaire.get().setContenu(content);
			Commentaire comment = commentaireDAO.save(retrievedCommentaire.get());
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
			
		}else {
			return new ResponseEntity<HttpStatus>(HttpStatus.NOT_MODIFIED);
		}
	}
	
//	Ajouter un commentaire 
	
}
