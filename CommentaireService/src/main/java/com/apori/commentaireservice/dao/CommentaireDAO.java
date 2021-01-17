package com.apori.commentaireservice.dao;

import org.springframework.stereotype.Repository;

import com.apori.commentaireservice.model.Commentaire;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface CommentaireDAO extends CrudRepository<Commentaire,Integer> {
	
	public List<Commentaire> findByidPublication(Integer idPublication);
}
