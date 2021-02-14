package com.apori.userservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apori.userservice.data.PublicationServiceClient;
import com.apori.userservice.model.User;
import com.apori.userservice.repository.UserRepository;
import com.apori.userservice.response.model.Publicationresponse;

@Service
public class UserserviceImpl implements Userservice {
	
	@Autowired 
	private UserRepository userRepository;
	
	@Autowired
	private PublicationServiceClient publicationServiceClient;
	
	
	//Liste de tous les utilisateurs 
	public List<User> getUsers(){
		List<User> UserList = userRepository.findAll();
		if(!UserList.isEmpty()) {
			return UserList;
		}else {
			return null;
		}
	}
	
	//Liste des Publications d'un Utilisateur 
	public List<Publicationresponse> getUserPublications(Long idUser){
		List<Publicationresponse> retrievedPublications = new ArrayList<>();
		return retrievedPublications = publicationServiceClient.getPublications(idUser);
	} 
	
	//Retourner un  utilisateur par son id 
	public Optional<User> getUserbyID(Long idUser){
		Optional<User> retrievedUser = userRepository.findById(idUser);
		if(retrievedUser.isPresent()) {
			return retrievedUser;
		}else {
			return null;
		}
	}
	
	//Retourner un Utilisateur par son username
	public  Optional<User> getUserbyname(String username){
		Optional<User> retrievedUser = userRepository.findByUsername(username);
		if(retrievedUser.isPresent()) {
			return retrievedUser;
		}else {
			return null;
		}
	}
}
