package com.apori.commentaireservice.service;

import java.util.List;

import com.apori.commentaireservice.model.Commentaire;

public interface CommentaireService {
	
	
	//Retourne la liste des commentaires d'une Publication
	List<Commentaire> getPublicationComments(Integer idPublication);
	
	//Ajouter un commentaire à une publication 
//	Boolean saveComment(String content);
	
}
