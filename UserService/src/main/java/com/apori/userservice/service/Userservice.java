package com.apori.userservice.service;

import java.util.List;
import java.util.Optional;

import com.apori.userservice.model.User;
import com.apori.userservice.response.model.Publicationresponse;

public interface Userservice {

	//Retourne la liste de tous les utilisateurs 
	 List<User> getUsers(); 
	 
	//Retourne la liste des publications d'un utlisateur
	 List<Publicationresponse> getUserPublications(Long idUser);
	 
	 //Retourne un utilisateur par son id
	 Optional<User> getUserbyID(Long idUser);
	 
	 //Retourne un utilisateur par son nom
	 Optional<User> getUserbyname(String username);
}
