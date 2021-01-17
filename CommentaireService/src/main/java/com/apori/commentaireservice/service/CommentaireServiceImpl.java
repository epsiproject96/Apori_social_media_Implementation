package com.apori.commentaireservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apori.commentaireservice.dao.CommentaireDAO;
import com.apori.commentaireservice.model.Commentaire;

@Service
public class CommentaireServiceImpl implements CommentaireService {
	
	@Autowired
	private CommentaireDAO commentaireDAO;
	
	
	//Retourne la liste des commentaires d'une publication
	public List<Commentaire> getPublicationComments(Integer idPublication){
		List<Commentaire> CommentList = commentaireDAO.findByidPublication(idPublication);
		if(CommentList.size()!=0) {
			return CommentList;
		}
		else {
			return null;
		}
	}


}
